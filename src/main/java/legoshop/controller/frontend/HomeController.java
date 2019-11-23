package legoshop.controller.frontend;

import legoshop.service.impl.PartTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Контроллер главной страницы
 */
@Controller
public class HomeController {

    @Autowired
    private PartTypeServiceImpl partTypeService;

    /**
     * Главная страница
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("types", partTypeService.findAll());
        return "index";
    }

}
