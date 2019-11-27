package legoshop.service;

import legoshop.domain.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Сервис деталей
 */

public interface PartService {

    Page<Part> findPartsByType (Long typeId, Pageable pageable);

    List<Part> findPartsByColor(Long colorId);

    List<Part> findPartByPartNumber(String partNumber);

}
