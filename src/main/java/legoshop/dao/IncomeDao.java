package legoshop.dao;

import legoshop.domain.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IncomeDao extends CrudRepository<Income, Long>, JpaRepository<Income, Long> {


}
