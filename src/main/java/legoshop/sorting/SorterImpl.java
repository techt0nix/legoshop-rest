package legoshop.sorting;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class SorterImpl implements Sorter {

    private static Integer FIRST_PAGE = 0;
    private static Integer PAGE_SIZE_DEFAULT = 2;
    private static String SORT_DEFAULT = "id";
    private static String ORDER_DEFAULT = "asc";
    private static Pageable pagable = PageRequest.of(FIRST_PAGE, PAGE_SIZE_DEFAULT, Sort.by(SORT_DEFAULT));

    private Integer pageNumber;
    private Integer pageSize;
    private Sort sort;
    private String order;

    public Pageable updateSorting (SortingValuesDTO sortingValues) {
        this.pageNumber = (sortingValues.getPage() == null) ? pagable.getPageNumber() : sortingValues.getPage();
        this.pageSize = (sortingValues.getSize() == null) ? pagable.getPageSize() : sortingValues.getSize();
        this.sort = (sortingValues.getSort() == null) ? pagable.getSort() : Sort.by(sortingValues.getSort());
        this.order = (sortingValues.getOrder() == null) ? getOrderDefault() : sortingValues.getOrder();
        pagable = PageRequest.of(getPageNumber(), getPageSize(), sort);
        return pagable;
    }

//    private Sort createSort(String sortBy, String order) {
//        Sort sort;
//        if (order.equals("desc"))
//            sort = Sort.by(Sort.Direction.DESC, sortBy);
//        else
//            sort = Sort.by(Sort.Direction.ASC, sortBy);
//        return sort;
//    }

    public String getOrderDefault() {
        return ORDER_DEFAULT;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Sort getSort() {
        return sort;
    }

    public String getOrder() {
        return order;
    }
}
