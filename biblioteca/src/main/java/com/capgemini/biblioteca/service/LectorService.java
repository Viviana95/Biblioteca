package com.capgemini.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.capgemini.biblioteca.model.Lector;


public interface LectorService {
	List<Lector> getAllLectores();
	Lector getLectorByNSocio(long nSocio);
	void saveLector(Lector lector);
	void deleteLectorByNSocio(long nSocio);
	
	Page<Lector> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);

}
