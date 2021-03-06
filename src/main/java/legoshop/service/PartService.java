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

    Part getPartByPartNumber(String partNumber);

    Set<IncomeItem> getIncomeItemsById(Long id);

    Set<OutcomeItem> getOutcomeItemsById(Long id);

    void updateQuantity(Part part, Integer quantity);

    List<Part> findPartsByColor(Long colorId, SortingValuesDTO sortingValues);

}
