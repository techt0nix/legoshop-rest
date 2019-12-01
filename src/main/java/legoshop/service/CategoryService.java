package legoshop.service;

import legoshop.domain.Category;
import java.util.List;

/**
 * Сервис типов деталей
 */

public interface CategoryService {

    List<Category> findAll();

    Category findTypeById(Long id);

}
