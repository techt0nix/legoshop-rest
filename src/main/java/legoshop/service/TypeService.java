package legoshop.service;

import legoshop.domain.Type;
import java.util.List;

/**
 * Сервис типов деталей
 */

public interface TypeService {

    List<Type> findAll();

    Type findTypeById(Long id);

}
