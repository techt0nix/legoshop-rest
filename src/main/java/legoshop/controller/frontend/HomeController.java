package legoshop.controller.frontend;

import legoshop.domain.Part;
import legoshop.domain.Type;
import legoshop.service.BlobDecoder;
import legoshop.service.PagedModelPreparer;
import legoshop.service.PartService;
import legoshop.service.TypeService;
import legoshop.sorting.SortingValuesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * Контроллер главной страницы
 * Также занимается обработкой поисковых запросов
 */

@Controller
public class HomeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlobDecoder blobDecoder;

    @Autowired
    private PartService partService;

    @Autowired
    @Qualifier("pagedPartModelPreparer")
    private PagedModelPreparer pagedModelPreparer;

    /**
     * Главная страница
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<Type> typesList = typeService.findAll();
        List<String> base64List = blobDecoder.getBase64List(typesList);
        model.addAttribute("types", typesList);
        model.addAttribute("images", base64List);
        return "index";
    }


    @RequestMapping(value = "/search/", method = RequestMethod.POST)
    public String filter(@RequestParam String tag,
                         @RequestParam  (defaultValue = "0", required = false) Integer page,
                         @RequestParam  (required = false) Integer size,
                         @RequestParam  (required = false) String sort,
                         @RequestParam  (required = false) String direction,
                         Model model ) {

        SortingValuesDTO sortingValues = new SortingValuesDTO(page, size, sort, direction);
        Page<Part> pagedParts = partService.searchParts(tag, sortingValues);
        pagedModelPreparer.preparePagedModel(pagedParts, model);
        model.addAttribute("tag", tag);
        return "search-results";
    }


    @RequestMapping(value = "/search/tag={tag}", method = RequestMethod.GET)
    public String switchSearchResultsPage(@PathVariable String tag,
                         @RequestParam  (required = false) Integer page,
                         @RequestParam  (required = false) Integer size,
                         @RequestParam  (required = false) String sort,
                         @RequestParam  (required = false) String direction,
                         Model model ) {

        SortingValuesDTO sortingValues = new SortingValuesDTO(page, size, sort, direction);
        Page<Part> pagedParts = partService.searchParts(tag, sortingValues);
        pagedModelPreparer.preparePagedModel(pagedParts, model);
        model.addAttribute("tag", tag);
        return "search-results";
    }
}
