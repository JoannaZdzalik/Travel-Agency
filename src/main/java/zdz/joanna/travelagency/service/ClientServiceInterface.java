package zdz.joanna.travelagency.service;

import java.util.List;
import java.util.Optional;

import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;

public interface ClientServiceInterface {

	String addClient(ClientDto clientDto);

	boolean deleteClient(ClientDto clientDto);

	List<ClientDto> getAllClients();

	public boolean update(ClientDto client);

	public Optional<Client> getById(Long id);
}
