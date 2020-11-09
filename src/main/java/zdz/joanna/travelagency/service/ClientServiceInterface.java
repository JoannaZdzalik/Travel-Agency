package zdz.joanna.travelagency.service;

import java.util.List;
import zdz.joanna.travelagency.dto.ClientDto;

public interface ClientServiceInterface {
	
	void addClient(ClientDto clientDto);
//	void removeClient(ClientDto clientDto);
//	void updateClient (ClientDto clientDto);
	List<ClientDto> getAllClients();
	
}
