package legoshop.service.impl;

import legoshop.dao.PartDao;
import legoshop.domain.Part;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Page<Part> findPartsByType(Long typeId, Integer page, Integer pageSize, String sortBy, String order) {
        Sort sort;

        if (order.equals("asc"))
             sort = Sort.by(sortBy).ascending();
        else
            sort = Sort.by(sortBy).descending();

        Pageable paging = PageRequest.of(page, pageSize, sort);
        return partDao.findPartsByType(typeId, paging);
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
