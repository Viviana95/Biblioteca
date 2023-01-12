package com.capgemini.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca.model.Prestamo;
import com.capgemini.biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
	private PrestamoRepository prestamoRepo;
	@Override
	public List<Prestamo> getAllPrestamos() {
		return this.prestamoRepo.findAll();
	}

	@Override
	public List<Prestamo> getPrestamoBySocio(Long nSocio) {
		List<Prestamo> prestamos = prestamoRepo.findAll();
		for (Prestamo prestamo : prestamos) {
			if(prestamo.getLector().getnSocio( )!= nSocio){
				prestamos.remove(prestamo);
			}
		}
		
		return prestamos;
	}
	
	public Prestamo getPrestamoById(Long id) {
		Optional<Prestamo> optionalPrestamo = this.prestamoRepo.findById(id);
		Prestamo prestamo=null;
		if(optionalPrestamo.isPresent()) {
			prestamo = optionalPrestamo.get() ;
		}else {throw new RuntimeException("no se encuentra el lector con el Número de Socio: " + id);	}
		return prestamo;
	}
	

	@Override
	public void savePrestamo(Prestamo prestamo) {
		this.prestamoRepo.save(prestamo);
		
	}

	@Override
	public void deletePrestamoById(long id) {
		this.prestamoRepo.deleteById(id);
		
	}

	@Override
	public Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

}
