package com.capgemini.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca.model.Prestamo;


public interface PrestamoService {
	List<Prestamo> getAllPrestamos();
	List<Prestamo> getPrestamoBySocio(Long nSocio);
	void savePrestamo(Prestamo prestamo);
	void deletePrestamoById(long id);
	
	Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);

}
