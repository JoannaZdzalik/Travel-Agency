package zdz.joanna.travelagency.service;

import org.springframework.stereotype.Service;

import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;
import zdz.joanna.travelagency.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientService implements ClientServiceInterface {

	@Autowired
	ModelMapper mapper;

	@Autowired
	private ClientRepository clientRepository;

	public boolean addClient(ClientDto clientDto) {
		if (clientDto != null && isValid(clientDto)) {
			Client client = mapper.map(clientDto, Client.class);
			try {
				clientRepository.save(client);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	public List<ClientDto> getAllClients() {
		List<Client> clients = clientRepository.findAllByOrderBySurname();
		return clients.stream().map(c -> mapper.map(c, ClientDto.class)).collect(Collectors.toList());
	}

	public boolean deleteClient(ClientDto clientDto) {
		if (clientDto != null) {
			try {
				Client cl = clientRepository.findById(clientDto.getId()).get();
				clientRepository.delete(cl);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	public boolean isValid(ClientDto clientDto) {
		try {
			passportNrExists(clientDto);
		} catch (IllegalArgumentException e) {
			System.err.println("This passport number already exists - not adding Client to db!");
			return false;
		}
		return true;
	}

	public boolean passportNrExists(ClientDto clientDto) {
		return clientRepository.countByPassportNr(clientDto.getPassportNr()) > 0;
	}
	
	public Optional<Client> getById(Long id){
		return clientRepository.findById(id);
	}
	
	public boolean update(Client client) {
			try {
				clientRepository.save(client);
			} catch (Exception e) {
				return false;
			}
			return true;
	}

}
