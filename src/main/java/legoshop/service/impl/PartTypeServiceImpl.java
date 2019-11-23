package legoshop.service.impl;

import legoshop.domain.Type;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис, отвечающий за типы деталей
 */

@Service
public class PartTypeServiceImpl implements legoshop.service.PartTypeService {

    @Override
    public List<Type> findAll() {
        return null;
    }
}
