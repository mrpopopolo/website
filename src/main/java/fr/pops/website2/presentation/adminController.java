package fr.pops.website2.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.pops.website2.business.entity.CvItem;
import fr.pops.website2.business.service.CvService;

@Controller
@RequestMapping("/backstage")
public class adminController {
	
	@Autowired
	private CvService cvServ;

	@GetMapping("/edit-cv")
	public String editCv(Model model, CvItem cv) {
		model.addAttribute("cv", this.cvServ.getCv());
		return "edit-cv.html";
	}
	
	@PostMapping("/newItem")
	public String newItem(CvItem cv) {
		this.cvServ.saveCvItem(cv, -1);
		return "redirect:/backstage/edit-cv";
	}
	
	@PostMapping("/editItem")
	public String editItem(CvItem cv, @RequestParam Integer id) {
		this.cvServ.saveCvItem(cv, id);
		return "redirect:/backstage/edit-cv";
	}
	
	@GetMapping("/edit-cv/edit-item/{id}")
	public String editItem(Model model, @PathVariable Integer id) {
		model.addAttribute("cvItem", cvServ.loadCvItem(id));
		return "edit-item.html";
	}
	
	@GetMapping("/edit-cv/delete-item/{id}")
	public String deleteItem(@PathVariable Integer id) {
		this.cvServ.deleteCvItem(id);
		return "redirect:/backstage/edit-cv";
	}
}
