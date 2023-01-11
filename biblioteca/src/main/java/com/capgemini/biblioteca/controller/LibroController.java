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

import com.capgemini.biblioteca.model.Libro;
import com.capgemini.biblioteca.service.LibroServiceImpl;


@Controller
public class LibroController {
	
	@Autowired
	private LibroServiceImpl libroService;
	
	@GetMapping("/libros")
	public String viewLibros(Model model) {
		return null;
	}
	@GetMapping("/libros/page/{pageNro}")
	public String findPaginate(@PathVariable(value = "pageNro") int pageNro,
			                   @RequestParam(value = "sortField") String sortField, 
			                   @RequestParam(value = "sortDir") String sortDirection,
			                   Model model) {
		int pageSize = 4;
		Page<Libro> page = libroService.findPaginated(pageNro, pageSize, sortField, sortDirection);
		List<Libro> listLibros = page.getContent();

		model.addAttribute("currentPage", pageNro);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir", sortDirection.equals("asc")? "desc" : "asc");
		model.addAttribute("listBooks", listLibros);

		return "index";
	}
	
	@PostMapping("/save")
	public String saveLibro(@ModelAttribute("course") Libro libro) {
		libroService.saveLibro(libro);
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteLibro(@PathVariable(value="id") String isbn) {
		this.libroService.deleteLibroByIsbn(isbn);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String showFormForUpdate(@PathVariable(value="isbn") String isbn, Model model) {
		Libro libro =libroService.getLibroByIsbn(isbn);
		model.addAttribute("book",libro);
		return "update_book";
	}
	
	@GetMapping("/add")
	public String showNewCursoForm(Model model) {
		Libro libro =new Libro();
		model.addAttribute("book",libro);
		return "new_book";
	}

}
