package com.capgemini.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca.model.Copia;


public interface CopiaService {
	List<Copia> getAllCopias();
	List<Copia> getCopiasByIsbn(String isbn);
	void saveCopia(Copia copia);
	void deleteCopiaById(long id);
	
	Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);

}
