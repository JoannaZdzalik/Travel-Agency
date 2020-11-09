package zdz.joanna.travelagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zdz.joanna.travelagency.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
