package legoshop.sorting;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * Управляющий сортировкой и разбивкой на страницы
 *
 * Инкапсулирует операции с опциями сортировки и разбивку на страницы
 * Хранит в себе объект Pageable, его текущие значения, подгатавливает его и изменяет в соответствии с выбранными опциями
 *
 * В конструкторе по умолчанию инициализует значения по умолчанию
 *
 */
@Component
public class SorterImpl implements Sorter {

    private final Integer firstPageDefault = 0;
    private final Integer pageSizeDefault = 2;
    private final String sortDefault = "id";
    private final String orderDefault = "asc";

    private Integer pageNumber;
    private Integer pageSize;
    private Sort sort;
    private String order;
    private Pageable paging;

    public SorterImpl() {
        this.paging = PageRequest.of(firstPageDefault, pageSizeDefault, Sort.by(sortDefault));
        this.pageNumber = firstPageDefault;
        this.pageSize = pageSizeDefault;
        this.sort = Sort.by(sortDefault);
        this.order = orderDefault;
    }


    public Pageable updateSorting (SortingValuesDTO sortingValues) {
        if (sortingValues.getPage() != null)
            this.pageNumber = sortingValues.getPage();
        if (sortingValues.getSize() != null)
            this.pageSize = sortingValues.getSize();
        if (sortingValues.getSort() != null)
            this.sort = Sort.by(sortingValues.getSort());
        if (sortingValues.getOrder() != null) {
            if (!sortingValues.getOrder().equals(orderDefault))
                this.sort = sort.descending();
        }
        paging = PageRequest.of(pageNumber, pageSize, sort);
        return paging;
    }
}
