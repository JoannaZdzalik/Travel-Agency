package zdz.joanna.travelagency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import zdz.joanna.travelagency.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findAllByOrderBySurname();
	Long countByPassportNr(String passportNr);
}
