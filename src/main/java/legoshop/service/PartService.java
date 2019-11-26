package legoshop.service;

import legoshop.domain.Part;
import java.util.List;

/**
 * Сервис деталей
 */

public interface PartService {

    List<Part> findPartsByType (Long typeId);

    List<Part> findPartsByColor(Long colorId);

    List<Part> findPartByPartNumber(String partNumber);

}
