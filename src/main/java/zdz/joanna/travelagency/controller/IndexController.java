package zdz.joanna.travelagency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import zdz.joanna.travelagency.dto.ClientDto;
//import zdz.joanna.travelagency.service.ClientService;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;


import zdz.joanna.travelagency.service.ClientService;

@Controller
public class IndexController {

	@Autowired
	private ClientService clientService;
	
	// @RequestMapping(path = "/index", method = RequestMethod.GET)
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("allClients", clientService.getAllClients());
        return "index";
    }
	
	@RequestMapping("/client")
	public String client() {
		return "client";
	}	
}
