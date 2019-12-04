package legoshop.dao;

import legoshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Long>, JpaRepository<Order, Long> {

}
