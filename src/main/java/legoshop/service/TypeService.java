package legoshop.service;

import legoshop.domain.Type;
import java.util.List;

/**
 * Сервис типов деталей
 */

public interface TypeService {

    List<Type> findAll();


    /**
     * метод, возвращающий список base64 представлений blob-файлов (картинок)
     */
    List<String> getBase64List(List<Type> typesList);

}
