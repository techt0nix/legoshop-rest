package legoshop.controller.frontend;

import legoshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCart(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "cart";
    }
}