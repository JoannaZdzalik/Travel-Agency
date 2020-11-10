package zdz.joanna.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zdz.joanna.travelagency.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}