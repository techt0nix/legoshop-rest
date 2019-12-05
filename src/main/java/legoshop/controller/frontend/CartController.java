package legoshop.controller.frontend;

import legoshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCart(Model model, HttpSession httpSession) {
        model.addAttribute("categories", categoryService.findAll());
        return "cart";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    public String addToCart(@PathVariable Long id,
                            @RequestParam int quantity,
                            Model model) {

        model.addAttribute("categories", categoryService.findAll());
        return "cart";
    }
}
