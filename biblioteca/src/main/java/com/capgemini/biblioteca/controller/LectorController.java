package com.capgemini.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.biblioteca.model.Lector;
import com.capgemini.biblioteca.service.LectorServiceImpl;


@Controller
public class LectorController {
	@Autowired
	private LectorServiceImpl lectorService;
	
	@GetMapping("/readers")
	public String viewLectores(Model model) {
		return findPaginated(1, "nombre", "asc", model);
	}
	
	@GetMapping("/readers/page/{pageNro}")
	public String findPaginated(@PathVariable(value = "pageNro") int pageNro,
			                   @RequestParam(value = "sortField") String sortField, 
			                   @RequestParam(value = "sortDir") String sortDirection,
			                   Model model) {
		int pageSize = 4;
		Page<Lector> page = lectorService.findPaginated(pageNro, pageSize, sortField, sortDirection);
		List<Lector> listLectores = page.getContent();

		model.addAttribute("currentPage", pageNro);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir", sortDirection.equals("asc")? "desc" : "asc");
		model.addAttribute("listBooks", listLectores);

		return "readers/readers";
	}
	
	@PostMapping("/save-reader")
	public String saveLector(@ModelAttribute("reader") Lector lector) {
		lectorService.saveLector(lector);
		return "redirect:/readers";
	}
	@GetMapping("/delete-reader/{nSocio}")
	public String deleteLector(@PathVariable(value="nSocio") Long nSocio) {
		this.lectorService.deleteLectorByNSocio(nSocio);
		return "redirect:/readers";
	}
	
	@GetMapping("/update-reader/{nSocio}")
	public String showFormForUpdate(@PathVariable(value="nSocio") Long nSocio, Model model) {
		Lector lector =lectorService.getLectorByNSocio(nSocio);
		model.addAttribute("reader",lector);
		return "readers/update_reader";
	}
	
	@GetMapping("/add-reader")
	public String showNewBookForm(Model model) {
		Lector lector =new Lector();
		model.addAttribute("reader",lector);
		return "readers/new_reader";
	}

}
