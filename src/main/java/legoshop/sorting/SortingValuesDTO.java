package legoshop.sorting;

public class SortingValuesDTO {

   private Integer page;
   private Integer size;
   private String sort;
   private String order;

    public SortingValuesDTO(Integer page, Integer size, String sort, String order) {
        this.page = page;
        this.size = size;
        this.sort = sort;
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "SortingValuesDTO{" +
                "page=" + page +
                ", size=" + size +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
