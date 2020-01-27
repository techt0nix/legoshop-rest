package legoshop.controller.frontend;

import legoshop.domain.Cart;
import legoshop.domain.CartItem;
import legoshop.domain.Part;
import legoshop.dto.CartItemDto;
import legoshop.service.CategoryService;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PartService partService;


    @RequestMapping(method = RequestMethod.GET)
    public String getCart(Model model, HttpSession httpSession) {
        Cart cart = retrieveCart(httpSession);

        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("cart-list", cart);
        System.out.println("total items in cart : " + cart.getTotalItems());
        for (CartItem cartItem : cart.getCartItems()) {
            System.out.println("Item : " + cartItem.getPart().getPartNumber() + " | Quantity : " + cartItem.getQuantity());
        }
        return "cart";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody CartItemDto cartItemDto, HttpSession httpSession) {
        System.out.println("ITEM ID : " + cartItemDto.getItemId());
        System.out.println("QUANITITY : " + cartItemDto.getQuantity());
        Cart cart = updateCart(cartItemDto, httpSession);
        return cart.getTotalItems().toString();
    }


    @RequestMapping(value = "/getTotalCount", method = RequestMethod.GET)
    @ResponseBody
    public String getTotalCount(HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        return (cart == null) ? "0" : cart.getTotalItems().toString();
    }

    private Cart updateCart(CartItemDto cartItemDto, HttpSession httpSession) {
        Cart cart = retrieveCart(httpSession);

        Part part = partService.getPartById(cartItemDto.getItemId());
        Integer quantity = cartItemDto.getQuantity();

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
