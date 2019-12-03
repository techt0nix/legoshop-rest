package legoshop.service;

import legoshop.domain.IncomeItem;
import legoshop.domain.OutcomeItem;
import legoshop.domain.Part;
import legoshop.sorting.SortingValuesDTO;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Set;

/**
 * Сервис деталей
 */

public interface PartService {

    Page<Part> findPartsByCategory(Long categoryId, SortingValuesDTO sortingValues);

    Page<Part> searchParts (String tag, SortingValuesDTO sortingValues);

    Part getPartById(Long id);

    Set<IncomeItem> getIncomeItemsById(Long id);

    Set<OutcomeItem> getOutcomeItemsById(Long id);


    List<Part> findPartsByColor(Long colorId, SortingValuesDTO sortingValues);

    List<Part> findPartByPartNumber(String partNumber);

}
