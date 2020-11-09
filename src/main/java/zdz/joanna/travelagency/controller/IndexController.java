package zdz.joanna.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/client")
	public String client() {
		return "client";
	}
}
