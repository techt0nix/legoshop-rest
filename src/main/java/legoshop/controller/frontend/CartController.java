package legoshop.controller.frontend;

import legoshop.domain.Cart;
import legoshop.domain.CartItem;
import legoshop.domain.Part;
import legoshop.dto.AddToCartItemDto;
import legoshop.dto.CartDto;
import legoshop.dto.DtoAssembler.CartDtoAssembler;
import legoshop.service.BlobDecoder;
import legoshop.service.CategoryService;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PartService partService;

    @Autowired
    private CartDtoAssembler cartDtoAssembler;

    @Autowired
    private BlobDecoder blobDecoder;


    @RequestMapping(method = RequestMethod.GET)
    public String getCart(Model model, HttpSession httpSession) {
        Cart cart = retrieveCart(httpSession);
        List<Part> partList = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            partList.add(cartItem.getPart());
        }
        model.addAttribute("images", blobDecoder.getBase64List(partList));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("cart", cart);
        System.out.println("total items in cart : " + cart.getTotalItems());
        for (CartItem cartItem : cart.getCartItems()) {
            System.out.println("Item : " + cartItem.getPart().getPartNumber() + " | Quantity : " + cartItem.getQuantity());
        }
        return "cart";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody AddToCartItemDto addToCartItemDto, HttpSession httpSession) {
        System.out.println("ITEM ID : " + addToCartItemDto.getItemId());
        System.out.println("QUANITITY : " + addToCartItemDto.getQuantity());
        Cart cart = updateCart(addToCartItemDto, httpSession);
        return cart.getTotalItems().toString();
    }


    @RequestMapping(value = "/getTotalCount", method = RequestMethod.GET)
    @ResponseBody
    public String getTotalCount(HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        return (cart == null) ? "0" : cart.getTotalItems().toString();
    }

    @RequestMapping(value = "/restcart", method = RequestMethod.GET)
    @ResponseBody
    public CartDto restcart(HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        return cartDtoAssembler.toAnonymousResource(cart);
    }


    private Cart updateCart(AddToCartItemDto addToCartItemDto, HttpSession httpSession) {
        Cart cart = retrieveCart(httpSession);

        Part part = partService.getPartById(addToCartItemDto.getItemId());
        Integer quantity = addToCartItemDto.getQuantity();

        cart.update(part, quantity);
        httpSession.setAttribute("cart", cart);

        return cart;
    }


    private Cart retrieveCart(HttpSession httpSession) {
        Cart cart;
        cart = (Cart) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        httpSession.setAttribute("cart", cart);
        return cart;
    }

}
