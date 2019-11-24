package legoshop.service;

import legoshop.domain.AbstractEntityWithImage;
import legoshop.domain.Type;
import java.util.List;

/**
 * Сервис типов деталей
 */

public interface TypeService {

    List<Type> findAll();

}
