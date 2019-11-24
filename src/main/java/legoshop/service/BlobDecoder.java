package legoshop.service;

import legoshop.domain.AbstractEntityWithImage;
import java.util.List;

public interface BlobDecoder {

    /**
     * метод, возвращающий список base64 представлений blob-файлов (картинок)
     */
    List<String> getBase64List(List<? extends AbstractEntityWithImage> entityList);
}
