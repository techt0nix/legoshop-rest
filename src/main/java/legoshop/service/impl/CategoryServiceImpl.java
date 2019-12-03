package legoshop.service.impl;

import legoshop.dao.CategoryDao;
import legoshop.domain.Category;
import legoshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Реализация сервиса категорий деталей
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }


    @Transactional(readOnly = true)
    @Override
    public Category findTypeById(Long id) {
        Category category = categoryDao.getOne(id);
        return category;
    }
}
