package legoshop.controller.frontend;

import legoshop.domain.Part;
import legoshop.domain.Category;
import legoshop.service.BlobDecoder;
import legoshop.service.PagedModelPreparer;
import legoshop.service.PartService;
import legoshop.service.CategoryService;
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
    private CategoryService categoryService;

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
        List<Category> categoriesList = categoryService.findAll();
        List<String> base64List = blobDecoder.getBase64List(categoriesList);
        model.addAttribute("categories", categoriesList);
        model.addAttribute("images", base64List);
        return "index";
    }


    @RequestMapping(value = "/search/", method = RequestMethod.POST)
    public String filter(@RequestParam String tag,
                         @RequestParam  (defaultValue = "0", required = false) Integer page,
                         @RequestParam  (required = false) Integer size,
                         @RequestParam  (defaultValue = "id", required = false) String sort,
                         @RequestParam  (defaultValue = "asc", required = false) String direction,
                         Model model ) {

        SortingValuesDTO sortingValues = new SortingValuesDTO(page, size, sort, direction);
        Page<Part> pagedParts = partService.searchParts(tag, sortingValues);
        pagedModelPreparer.preparePagedModel(pagedParts, model);
        model.addAttribute("tag", tag);
        model.addAttribute("categories", categoryService.findAll());
        return "search-results";
    }


    @RequestMapping(value = "/search/tag={tag}", method = RequestMethod.GET)
    public String switchSearchResultsPage(@PathVariable String tag,
                                          @RequestParam  (required = false) Integer page,
                                          @RequestParam  (required = false) Integer size,
                                          @RequestParam  (required = false) String sort,
                                          @RequestParam  (required = false) String direction,
                                          Model model) {

        SortingValuesDTO sortingValues = new SortingValuesDTO(page, size, sort, direction);
        Page<Part> pagedParts = partService.searchParts(tag, sortingValues);
        pagedModelPreparer.preparePagedModel(pagedParts, model);
        model.addAttribute("tag", tag);
        model.addAttribute("categories", categoryService.findAll());
        return "search-results";
    }
}
