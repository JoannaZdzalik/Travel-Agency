package zdz.joanna.travelagency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zdz.joanna.travelagency.service.ClientService;
import zdz.joanna.travelagency.dto.ClientDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/travelagency")
public class IndexController {

	@Autowired
	private ClientService clientService;
	
    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }
    
	
    @PostMapping("/addclient")
    void addUser(@RequestBody ClientDto client) {
        clientService.addClient(client);
    }
    
    
}
