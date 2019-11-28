package legoshop.sorting;


import org.springframework.data.domain.Pageable;

/**
 * Интерфейс опций сортировки и разбивки на страницы.
 */

public interface Sorter {

    /**
     * Обновление значений опций сортировки.
     *
     * @param sortingValues новые значения опций
     * @return сформированный Pageable-объект для обращения с ним к базе
     */
    Pageable updateSorting (SortingValuesDTO sortingValues);

}
