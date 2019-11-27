package legoshop.service;

import legoshop.domain.Part;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Сервис деталей
 */

public interface PartService {

    Page<Part> findPartsByType (Long typeId, Integer page, Integer pageSize, String sortBy, String order);

    List<Part> findPartsByColor(Long colorId);

    List<Part> findPartByPartNumber(String partNumber);

}
