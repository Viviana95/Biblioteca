package com.capgemini.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca.model.Libro;

public interface LibroService {
	List<Libro> getAllLibros();
	Libro getLibroByIsbn(String isbn);
	void saveLibro(Libro libro);
	void deleteLibroByIsbn(String isbn);
	
	Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
	

}
