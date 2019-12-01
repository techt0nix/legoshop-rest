package legoshop.service.impl;

import legoshop.domain.AbstractEntityWithImage;
import legoshop.service.BlobDecoder;
import legoshop.service.PagedModelPreparer;
import legoshop.sorting.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Реализация интерфейса PagedModelPreparer для подтоготовки модели с типом Part
 */

@Component
public class PagedPartModelPreparer implements PagedModelPreparer {

    @Autowired
    @Qualifier("partSorter")
    private Sorter sorter;

    @Autowired
    private BlobDecoder blobDecoder;


    @Override
    public Model preparePagedModel(Page<? extends AbstractEntityWithImage> pagedList, Model model) {
        List<? extends AbstractEntityWithImage> content = pagedList.getContent();
        int totalPages = pagedList.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<String> base64List = blobDecoder.getBase64List(content);
        model.addAttribute("images", base64List);
        model.addAttribute("parts", content);
        sorter.prepareModel(model);
        return model;
    }
}
