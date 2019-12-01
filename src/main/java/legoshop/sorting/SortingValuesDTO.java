package legoshop.sorting;

/**
 * Data transfer object для передачи опций сортировки, направления сортировки, размера Page, текущей страницы
 */

public class SortingValuesDTO {

   private Integer page;
   private Integer size;
   private String sort;
   private String direction;

    public SortingValuesDTO(Integer page, Integer size, String sort, String direction) {
        this.page = page;
        this.size = size;
        this.sort = sort;
        this.direction = direction;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "SortingValuesDTO{" +
                "page=" + page +
                ", size=" + size +
                ", sort='" + sort + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
