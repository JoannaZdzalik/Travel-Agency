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

	public String addClient(ClientDto clientDto) {
		if (clientDto == null) {
			return "Bad request - client not specified";
		} else if (!isPassportNrValid(clientDto)) {
			return "This passport number already exists in db!";
		} else if (clientDto.getName() == null || clientDto.getName().length() < 2) {
			return "Bad request - name not specified or invalid";
		} else if (clientDto.getSurname() == null || clientDto.getSurname().length() < 2) {
			return "Bad request - surname not specified or invalid";
		} else if (clientDto.getPassportNr() == null || clientDto.getPassportNr().length() < 6) {
			return "Bad request - passportNr not specified or invalid";
		} else if (isValid(clientDto) && isPassportNrValid(clientDto)) {
			// Client client = mapper.map(clientDto, Client.class);
			Client client = new Client(clientDto.getName(), clientDto.getSurname(), clientDto.getPassportNr());
			try {
				clientRepository.save(client);
			} catch (Exception e) {
				return "Something went wrong!";
			}
			return "Client added sucessfully";
		}
		return "Something went soooo wrong and did not enter any loop :(";
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

	public boolean isPassportNrValid(ClientDto clientDto) {
		try {
			passportNrExists(clientDto);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public boolean isValid(ClientDto clientDto) {
		return isPassportNrValid(clientDto) && clientDto.getName() != null && clientDto.getSurname() != null
				&& clientDto.getPassportNr() != null && clientDto.getName().length() > 2
				&& clientDto.getSurname().length() > 2 && clientDto.getPassportNr().length() > 6;
	}

	public boolean passportNrExists(ClientDto clientDto) {
		return clientRepository.countByPassportNr(clientDto.getPassportNr()) > 0;
	}

	public ClientDto getById(Long id) {
		try {
			Optional<Client> cl = clientRepository.findById(id);
			ClientDto cldto = new ClientDto(cl.get().getId(), cl.get().getName(), cl.get().getSurname(),
					cl.get().getPassportNr());
			return cldto;
		} catch (Exception e) {
			System.err.println("Catched exception on getting client by Id. Message: " + e.getMessage());
		}
		return null;
	}

	public boolean update(ClientDto clientDto) {
		try {
			// Client client = mapper.map(clientDto, Client.class);
			Client client = new Client(clientDto.getId(), clientDto.getName(), clientDto.getSurname(),
					clientDto.getPassportNr());
			clientRepository.save(client);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
