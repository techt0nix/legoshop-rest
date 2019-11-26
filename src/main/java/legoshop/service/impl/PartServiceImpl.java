package legoshop.service.impl;

import legoshop.dao.PartDao;
import legoshop.domain.Part;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Реализация сервиса деталей PartService
 */

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartDao partDao;


    @Transactional(readOnly = true)
    @Override
    public List<Part> findPartsByType(Long typeId) {
        return partDao.findPartsByType(typeId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Part> findPartsByColor(Long colorId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Part> findPartByPartNumber(String partNumber) {
        return null;
    }
}
