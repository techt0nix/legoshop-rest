package legoshop.service.impl;

import legoshop.dao.PartDao;
import legoshop.domain.IncomeItem;
import legoshop.domain.OutcomeItem;
import legoshop.domain.Part;
import legoshop.service.PartService;
import legoshop.sorting.Sorter;
import legoshop.sorting.SortingValuesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Реализация сервиса деталей PartService
 */

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartDao partDao;

    @Autowired
    @Qualifier("partSorter")
    private Sorter sorter;


    @Transactional(readOnly = true)
    @Override
    public Page<Part> findPartsByCategory(Long categoryId, SortingValuesDTO sortingValues) {
        Pageable paging = sorter.updateSorting(sortingValues);
        return partDao.findPartsByType(categoryId, paging);
    }


    @Transactional(readOnly = true)
    @Override
    public Page<Part> searchParts(String tag, SortingValuesDTO sortingValues) {
        Pageable paging = sorter.updateSorting(sortingValues);
        return partDao.searchParts(tag, paging);
    }


    @Transactional(readOnly = true)
    @Override
    public Part getPartById(Long id) {
        return partDao.findPartById(id);
    }


    @Transactional(readOnly = true)
    @Override
    public Set<IncomeItem> getIncomeItemsById(Long id) {
        Part part = partDao.findPartById(id);
        return part.getIncomes();
    }


    @Transactional(readOnly = true)
    @Override
    public Set<OutcomeItem> getOutcomeItemsById(Long id) {
        Part part = partDao.findPartById(id);
        return part.getOutcomes();
    }


    @Transactional(readOnly = true)
    @Override
    public Part getPartByPartNumber(String partNumber) {
        return partDao.findPartByPartNumber(partNumber);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Part> findPartsByColor(Long colorId, SortingValuesDTO sortingValues) {
        return null;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Part> findPartByPartNumber(String partNumber) {
        return null;
    }
}
