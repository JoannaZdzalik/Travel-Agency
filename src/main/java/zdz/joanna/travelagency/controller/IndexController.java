package zdz.joanna.travelagency.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zdz.joanna.travelagency.service.ClientService;
import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IndexController {

	@Autowired
	private ClientService clientService;
	
    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }
    
	@RequestMapping("/getById/{id}")
	public ClientDto getOne(@PathVariable("id") Long id, HttpServletResponse response) { 
		ClientDto cl = clientService.getById(id);
		if (cl != null) {
			response.setStatus(200);
		} else {
			 response.setStatus(404);
		}
		return cl;
	}
    
	
    @PostMapping("/addclient")
    public ResponseEntity<String> addClient(@RequestBody ClientDto client) {
        String status = clientService.addClient(client);
        boolean valid = clientService.isValid(client);
        System.err.println("Kurde to valid czy nie????? " + valid);
        return valid ? ResponseEntity.ok().body(status) : ResponseEntity.badRequest().body(status);
    }
    
    @DeleteMapping("deleteclient/{id}")  
    public HttpStatus deleteClient(@PathVariable("id") Long id,ClientDto clientDto) {  
        clientDto.setId(id); 
        boolean deleted = clientService.deleteClient(clientDto);
        if(deleted) {
        	return HttpStatus.OK;
        }else {
        	return HttpStatus.NOT_FOUND;
        }
    } 
    
    @PutMapping("updateclient/{id}")  
    public boolean updateClient(@RequestBody ClientDto client,@PathVariable("id") Long id) {  
    	client.setId(id);
    	return clientService.update(client);
       
    }
    
    
}
