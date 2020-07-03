package fr.pops.website2.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.pops.website2.business.entity.Message;
import fr.pops.website2.business.service.CvService;
import fr.pops.website2.business.service.MessageService;

@Controller
public class WebsiteController {

	@Autowired
	private CvService cvServ;
	
	@Autowired
	private MessageService mServ;
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("cv", this.cvServ.getCv());
		return "index.html";
	}
	
	@GetMapping("/about-me")
	public String aboutMe() {
		return "about-me.html";
	}
	
	@GetMapping("/contact-me")
	public String contactMe(Model model) {
		Message message = new Message();
		model.addAttribute("message", message);
		return "contact-me.html";
	}
	
	@PostMapping("/contact-me")
	public String sendMessage(Message message) {
		this.mServ.createMessage(message);
		return "redirect:/";
	}
}