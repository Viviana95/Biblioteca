package com.capgemini.biblioteca.controller;

import java.util.List;

import org.aspectj.weaver.AjAttribute.PrivilegedAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.biblioteca.model.Copia;
import com.capgemini.biblioteca.model.Lector;
import com.capgemini.biblioteca.service.CopiaServiceImpl;
import com.capgemini.biblioteca.service.LibroService;
import com.capgemini.biblioteca.service.LibroServiceImpl;

@Controller
public class CopiaController {
	@Autowired
	private CopiaServiceImpl copiaService;
	@Autowired
	private LibroServiceImpl libroService;
	
	
	@GetMapping("/copies/{isbn}")
	public String viewCopias(@PathVariable (value = "isbn")String isbn, Model model) {
//		return findPaginated(isbn, 1, "id", "asc", model);
		List<Copia> listCopias = copiaService.getCopiasByIsbn(isbn);
		model.addAttribute("listCopies", listCopias);
		return "copies";
	}
	
	@GetMapping("/copies/add-copy/{isbn}")
	public String showNewCopyForm(@PathVariable (value = "isbn")String isbn,Model model) {
		Copia copia =new Copia();
		copia.setLibro(libroService.getLibroByIsbn(isbn));
		model.addAttribute("copy",copia);
		return "new_copy";
	}
	@PostMapping("/copies/save-copy/{isbn}")
	public String saveCopia(@PathVariable (value = "isbn")String isbn,@ModelAttribute("copy") Copia copia) {
		copiaService.saveCopia(copia);
		return "redirect:/copies/{isbn}";
	}
	
	@GetMapping("/copies/delete-copy/{id}")
	public String deleteLector(@PathVariable(value="id")Long id) {
		this.copiaService.deleteCopiaById(id);
		return "redirect:/books";
	}
	
//	@GetMapping("/copies/{isbn}/page/{pageNro}")
//	public String findPaginated(@PathVariable (value = "isbn")String isbn,
//								@PathVariable(value = "pageNro") int pageNro,
//			                   @RequestParam(value = "sortField") String sortField, 
//			                   @RequestParam(value = "sortDir") String sortDirection,
//			                   Model model) {
//		int pageSize = 4;
//		Page<Copia> page = copiaService.findPaginated(pageNro, pageSize, sortField, sortDirection);
//		List<Copia> listCopias = page.getContent();
//		
//		listCopias.removeIf(null);
//
//		model.addAttribute("currentPage", pageNro);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDirection);
//		model.addAttribute("reverseSortDir", sortDirection.equals("asc")? "desc" : "asc");
//		model.addAttribute("listCopies", listCopias);
//		return "copies";
//	}
}
