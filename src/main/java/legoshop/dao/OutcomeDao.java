package legoshop.dao;

import legoshop.domain.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OutcomeDao extends CrudRepository<Outcome, Long>, JpaRepository<Outcome, Long> {

}
