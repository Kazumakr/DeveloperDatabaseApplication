package com.a0521.dda.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a0521.dda.dao.DeveloperRepository;
import com.a0521.dda.entity.Developer;



@Controller
@RequestMapping("/index")
public class DeveloperController {

	@Autowired
	DeveloperRepository devRepo;
	
	@GetMapping
	public String displayDeveloperForm(Model model) {
		List<Developer> developers= devRepo.findAll();
		model.addAttribute("developerList",developers);
		model.addAttribute("developer",new Developer());
		return "/index";
		
	}

	@PostMapping("/save")
	public String addDeveloper(Developer developer, Model model) {
		devRepo.save(developer);
		
		return "redirect:/index";
	}
}
