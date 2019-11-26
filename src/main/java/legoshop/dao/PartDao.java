package legoshop.dao;

import legoshop.domain.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartDao extends CrudRepository<Part, Long>, JpaRepository<Part, Long> {

    @Query(value = "SELECT * from part where type_id = ?", nativeQuery = true)
    public List<Part> findPartsByType(Long typeId);

}
