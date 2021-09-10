package fr.pops.website2.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.pops.website2.business.service.CvService;

@Controller
public class WebsiteController {

	@Autowired
	private CvService cvServ;
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("cv", this.cvServ.getCv());
		return "index.html";
	}
	
	@GetMapping("/about-me")
	public String aboutMe() {
		return "about-me.html";
	}
	
}