package legoshop.service;

/**
 * Интерфейс подсчета общего количества прихода и ухода соответственно конкретного part.
 *
 */

public interface InOutCounter {

    Integer countTotalIncome(Long partId);

    Integer countTotalOutcome(Long partId);

}
