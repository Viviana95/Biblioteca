package com.capgemini.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.biblioteca.model.Copia;
import com.capgemini.biblioteca.model.Libro;
import com.capgemini.biblioteca.service.CopiaServiceImpl;
import com.capgemini.biblioteca.service.LibroServiceImpl;

@Controller
public class CopiaController {
	@Autowired
	private CopiaServiceImpl copiaService;
	@Autowired
	private LibroServiceImpl libroService;
	
	
	@GetMapping("/copies/{isbn}")
	public String viewCopies(@PathVariable (value = "isbn")String isbn, Model model) {
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
	
	@GetMapping("/copies/update-copy/{id}")
	public String showFormForUpdate(@PathVariable(value="id") Long id, Model model) {
		Copia copia = copiaService.getCopiaById(id);
		model.addAttribute("copy",copia);
		return "update_copy";
	}
	
	@PostMapping("/copies/update-copy/{id}")
	public String updateCopia(@PathVariable (value = "id")String id,@ModelAttribute("copy") Copia copia) {
		copiaService.saveCopia(copia);
		return "redirect:/copies/"+copia.getLibro().getIsbn();
	}
}
