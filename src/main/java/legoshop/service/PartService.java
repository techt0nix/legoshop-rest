package legoshop.service;

import legoshop.domain.Part;
import legoshop.sorting.SortingValuesDTO;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Сервис деталей
 */

public interface PartService {

    Page<Part> findPartsByCategory(Long categoryId, SortingValuesDTO sortingValues);

    Page<Part> searchParts (String tag, SortingValuesDTO sortingValues);

    List<Part> findPartsByColor(Long colorId, SortingValuesDTO sortingValues);

    List<Part> findPartByPartNumber(String partNumber);

}
