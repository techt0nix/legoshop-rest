package legoshop.service;

import legoshop.domain.Category;
import java.util.List;

/**
 * Сервис типов деталей
 */

public interface CategoryService {

    List<Category> findAll();

    List<String> getCategoriesNames();

    Category findTypeById(Long id);

}
