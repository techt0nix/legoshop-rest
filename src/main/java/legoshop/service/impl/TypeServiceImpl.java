package legoshop.service.impl;

import legoshop.dao.TypeDao;
import legoshop.domain.Type;
import legoshop.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Реализация сервиса типов деталей
 */

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;


    @Transactional(readOnly = true)
    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Type findTypeById(Long id) {
        Type type = typeDao.getOne(id);
        return type;
    }
}
