package legoshop.sorting;

import org.springframework.stereotype.Component;

@Component
public class PartSorter extends SorterImpl {
    
    {
        sortFieldOptions.put("id", "По id");
        sortFieldOptions.put("eng_name", "По имени");
        sortFieldOptions.put("part_number", "По партномеру");
    }
}
