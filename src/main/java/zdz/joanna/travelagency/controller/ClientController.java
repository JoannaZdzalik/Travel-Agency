package zdz.joanna.travelagency.controller;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/client")
	public ModelAndView createNewOffer() {
		return new ModelAndView("client", "clientToCreate", new ClientDto());
	}
	
	@PostMapping("/addclient")
	public String addClient(@ModelAttribute ClientDto clientDto) {
		clientService.addClient(clientDto);
		return "redirect:index";
	}

}
