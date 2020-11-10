package zdz.joanna.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;
import zdz.joanna.travelagency.service.ClientService;
import org.springframework.ui.Model;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("/client")
	public String mainPage(Model model) {
		model.addAttribute("allClients", clientService.getAllClients());
		model.addAttribute("clientToCreate", new Client());
		model.addAttribute("clientToDelete");
		return "client";
	}
	
	@PostMapping("/addclient")
	public String addClient(@ModelAttribute("clientToCreate") ClientDto clientDto) {
		clientService.addClient(clientDto);
		return "redirect:client";
	}
	
    @PostMapping("/delete")
    public String delete(@ModelAttribute("clientToDelete") ClientDto clientDto) {
        clientService.deleteClient(clientDto);
        return "redirect:client";
    }


//	@GetMapping("/edit/{id}")
//	public String showUpdateForm(@PathVariable("id") long id, Model model) {
//		Client client = clientRepository.findById(id)
//				.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
//		model.addAttribute("client", client);
//		return "update"; //stworzyc nowa podstorne
//	}

}
