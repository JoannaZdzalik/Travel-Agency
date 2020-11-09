package zdz.joanna.travelagency.service;

import org.springframework.stereotype.Service;

import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;
import zdz.joanna.travelagency.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientService implements ClientServiceInterface {

	@Autowired
	ModelMapper mapper;

	@Autowired
	private ClientRepository clientRepository;

	public void addClient(ClientDto clientDto) {
		Client client = mapper.map(clientDto, Client.class);
		clientRepository.save(client);
	}

	public List<ClientDto> getAllClients() {
		List<Client> clients = clientRepository.findAll();
		System.out.println("clients : " + clients);
		return clients.stream().map(c -> mapper.map(c, ClientDto.class)).collect(Collectors.toList());
	}
	
	 public void deleteClient(ClientDto clientDto) {
			System.out.println("clientDto to be romoved : " + clientDto);
	    	Client cl = clientRepository.findById(clientDto.getId()).orElseThrow(()-> new IllegalArgumentException("Invalid client Id:" + clientDto.getId()));
	    	System.out.println("client to be romoved : " + cl);
	    	clientRepository.delete(cl);
		
	}

//	 void updateClient (ClientDto clientDto) {
	 // Client updatedClient = mapper.map(clientDto, Client.Class)
	 // clientRepository.save(updatedClient);
//	})

}
