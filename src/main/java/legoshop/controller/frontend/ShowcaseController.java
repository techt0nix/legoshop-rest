package legoshop.controller.frontend;

import legoshop.domain.Part;
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

/**
 * Контроллер витрины. Отвечает за обработку запросов с id типа на /category
 */

@Controller
@RequestMapping("/category")
public class ShowcaseController {

    @Autowired
    private PartService partService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    @Qualifier("pagedPartModelPreparer")
    private PagedModelPreparer pagedModelPreparer;


    @RequestMapping(method = RequestMethod.GET, value = "/{typeId}")
    public String getTypeParts(@PathVariable Long typeId,
                               @RequestParam  (required = false) Integer page,
                               @RequestParam  (required = false) Integer size,
                               @RequestParam  (required = false) String sort,
                               @RequestParam  (required = false) String direction,
                               Model model) {

        SortingValuesDTO sortingValues = new SortingValuesDTO(page, size, sort, direction);
        Page<Part> pagedParts = partService.findPartsByCategory(typeId, sortingValues);
        model.addAttribute("categoryId", typeId);
        pagedModelPreparer.preparePagedModel(pagedParts, model);
        model.addAttribute("categories", categoryService.findAll());
        return "showcase";
    }

}
