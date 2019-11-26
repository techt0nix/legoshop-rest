package legoshop.controller.frontend;

import legoshop.domain.Part;
import legoshop.service.BlobDecoder;
import legoshop.service.PartService;
import legoshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * Контроллер витрины. Отвечает за обработку запросов с id типа на /types
 */

@Controller
@RequestMapping("/type")
public class ShowcaseController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private PartService partService;

    @Autowired
    private BlobDecoder blobDecoder;


    @RequestMapping(method = RequestMethod.GET, value = "/{typeId}")
    public String getTypeParts(@PathVariable Long typeId, Model model) {
        List<Part> parts = partService.findPartsByType(typeId);
        List<String> base64List = blobDecoder.getBase64List(parts);
        model.addAttribute("parts", parts);
        model.addAttribute("images", base64List);
        return "showcase";
    }
}
