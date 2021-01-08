package zdz.joanna.travelagency.controller;

import org.springframework.stereotype.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;
import zdz.joanna.travelagency.service.ClientService;
import org.springframework.ui.Model;

@Controller
public class ClientController {

//	@Autowired
//	private ClientService clientService;
//	
//	@GetMapping("/client")
//	public String mainPage(Model model) {
//		model.addAttribute("allClients", clientService.getAllClients());
//		model.addAttribute("clientToCreate", new Client());
//		model.addAttribute("clientToDelete");
//		return "client";
//	}
//
//	@PostMapping("/addclient")
//	public String addClient(@ModelAttribute("clientToCreate") ClientDto clientDto) {
//		clientService.addClient(clientDto);
//		return "redirect:client";
//	}

//	@PostMapping("/delete")
//	public String delete(@ModelAttribute("clientToDelete") ClientDto clientDto) {
//		clientService.deleteClient(clientDto);
//		return "redirect:client";
//	}

//	@RequestMapping("/getOne/")
//	@ResponseBody
//	public Optional<Client> getOne(Long id) {
//		return clientService.getById(id);
//	}
//
//	@RequestMapping(value = "/update", method = { RequestMethod.PUT, RequestMethod.GET })
//	public String update(Client client) {
//		clientService.update(client);
//		return "redirect:client";
//	}

}
