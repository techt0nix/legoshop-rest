package legoshop.service;

import legoshop.domain.AbstractEntityWithImage;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

/**
 * Интерфейс для подтготовки пейджированной модели
 */

public interface PagedModelPreparer {

    Model preparePagedModel(Page<? extends AbstractEntityWithImage> pagedList, Model model);
}
