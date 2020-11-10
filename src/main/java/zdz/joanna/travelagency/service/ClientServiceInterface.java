package zdz.joanna.travelagency.service;

import java.util.List;
import zdz.joanna.travelagency.dto.ClientDto;

public interface ClientServiceInterface {
	
	boolean addClient(ClientDto clientDto);
	void deleteClient(ClientDto clientDto);
//	void updateClient (ClientDto clientDto);
	List<ClientDto> getAllClients();
}
