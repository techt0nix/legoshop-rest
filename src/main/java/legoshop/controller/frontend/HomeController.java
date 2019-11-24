package legoshop.controller.frontend;


import legoshop.domain.Type;
import legoshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * Контроллер главной страницы
 */
@Controller
public class HomeController {

    @Autowired
    private TypeService typeService;

    /**
     * Главная страница
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Type> typesList = typeService.findAll();
        List<String> base64List = typeService.getBase64List(typesList);
        model.addAttribute("types", typesList);
        model.addAttribute("images", base64List);
        return "index";
    }
}
