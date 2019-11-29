package legoshop.sorting;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Управляющий сортировкой и разбивкой на страницы
 *
 * Инкапсулирует операции с опциями сортировки и разбивку на страницы
 * Хранит в себе объект Pageable, его текущие значения, подгатавливает его и изменяет в соответствии с выбранными опциями
 *
 * В конструкторе по умолчанию инициализует значения по умолчанию
 * Добавление перечня опций сортировки (по умолчанию пустой) осуществляется в классах-потомках
 *
 *
 */

public class AbstractSorter implements Sorter {

    private final Integer firstPageDefault = 0;
    private final Integer pageSizeDefault = 2;
    private final String sortDefault = "id";
    private final String directionDefault = "asc";

    protected final Map<String, String> sortFieldOptions = new LinkedHashMap<>();
    private final Map<Integer, String> pageSizeOptions = new LinkedHashMap<>();
    private final Map<String, String> directionOptions = new LinkedHashMap<>();

    {
        directionOptions.put("asc", "По возрастанию");
        directionOptions.put("desc", "По убыванию");

        pageSizeOptions.put(1, "Показывать по 1");
        pageSizeOptions.put(2, "Показывать по 2");
        pageSizeOptions.put(3, "Показывать по 3");
    }

    private Integer pageNumber;
    private Integer pageSize;
    private Sort sort;
    private String direction;
    private Pageable paging;

    public AbstractSorter() {
        this.paging = PageRequest.of(firstPageDefault, pageSizeDefault, Sort.by(sortDefault));
        this.pageNumber = firstPageDefault;
        this.pageSize = pageSizeDefault;
        this.sort = Sort.by(sortDefault);
        this.direction = directionDefault;
    }

    @Override
    public Pageable updateSorting (SortingValuesDTO sortingValues) {
        if (sortingValues.getPage() != null)
            this.pageNumber = sortingValues.getPage();
        if (sortingValues.getSize() != null)
            this.pageSize = sortingValues.getSize();
        if (sortingValues.getSort() != null)
            this.sort = Sort.by(sortingValues.getSort());
        if (sortingValues.getDirection() != null) {
            this.sort = (!sortingValues.getDirection().equals(directionDefault)) ? sort.descending() : sort.ascending();
        }
        paging = PageRequest.of(pageNumber, pageSize, sort);
        return paging;
    }

    @Override
    public Model prepareModel(Model model) {
        model.addAttribute("sortOptions", sortFieldOptions);
        model.addAttribute("directions", directionOptions);
        model.addAttribute("pageSizes", pageSizeOptions);
        return model;
    }
}
