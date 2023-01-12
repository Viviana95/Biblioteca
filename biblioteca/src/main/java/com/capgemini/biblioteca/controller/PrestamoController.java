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
import com.capgemini.biblioteca.model.Prestamo;
import com.capgemini.biblioteca.service.CopiaServiceImpl;
import com.capgemini.biblioteca.service.LectorServiceImpl;
import com.capgemini.biblioteca.service.LibroServiceImpl;
import com.capgemini.biblioteca.service.PrestamoServiceImpl;

@Controller
public class PrestamoController {
	@Autowired
	private PrestamoServiceImpl prestamoService;
	@Autowired
	private LectorServiceImpl lectorService;
	
	
	@GetMapping("/loans/{nSocio}")
	public String viewLoans(@PathVariable (value = "nSocio")Long nSocio, Model model) {
		List<Prestamo> listPrestamos = prestamoService.getPrestamoBySocio(nSocio);
		model.addAttribute("listLoans", listPrestamos);
		return "loans";
	}
	
	@GetMapping("/loans/add-loan/{nSocio}")
	public String showNewLoanForm(@PathVariable (value = "nSocio")Long nSocio,Model model) {
		Prestamo prestamo =new Prestamo();
		prestamo.setLector(lectorService.getLectorByNSocio(nSocio));
		model.addAttribute("loan",prestamo);
		return "new_loan";
	}
	@PostMapping("/loans/save-loan/{nSocio}")
	public String saveLoan(@PathVariable (value = "nSocio")Long nSocio,@ModelAttribute("loan") Prestamo prestamo) {
		prestamoService.savePrestamo(prestamo);
		return "redirect:/copies/{nSocio}";
	}
	
	@GetMapping("/loans/delete-loan/{id}")
	public String deletePrestamo(@PathVariable(value="id")Long id) {
		this.prestamoService.deletePrestamoById(id);
		return "redirect:/readers";
	}
	
	@GetMapping("/loans/update-loan/{id}")
	public String showFormForUpdate(@PathVariable(value="id") Long id, Model model) {
		Prestamo prestamo = prestamoService.getPrestamoById(id);
		model.addAttribute("loan",prestamo);
		return "update_loan";
	}
	
	@PostMapping("/loans/update-loan/{id}")
	public String updateLoan(@PathVariable (value = "id")Long id,@ModelAttribute("loan") Prestamo prestamo) {
		prestamoService.savePrestamo(prestamo);
		return "redirect:/loans/"+prestamo.getLector().getnSocio();
	}
}
