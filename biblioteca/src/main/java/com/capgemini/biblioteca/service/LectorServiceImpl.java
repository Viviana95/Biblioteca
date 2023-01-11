package com.capgemini.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca.model.Lector;
import com.capgemini.biblioteca.repository.LectorRepository;

@Service
public class LectorServiceImpl implements LectorService{

	@Autowired
	private LectorRepository lectorRepo;

	@Override
	public List<Lector> getAllLectores() {
		
		return this.lectorRepo.findAll();
	}

	@Override
	public Lector getLectorByNSocio(long nSocio) {
		
		Optional<Lector> optionalLector = this.lectorRepo.findById(nSocio);
		Lector lector=null;
		if(optionalLector.isPresent()) {
			lector = optionalLector.get() ;
		}else {throw new RuntimeException("no se encuentra el lector con el Número de Socio: " + nSocio);	}
		return lector;
	}

	@Override
	public void saveLector(Lector lector) {
		this.lectorRepo.save(lector);
		
	}

	@Override
	public void deleteLectorByNSocio(long nSocio) {
		this.lectorRepo.deleteById(nSocio);;
		
	}

	@Override
	public Page<Lector> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.lectorRepo.findAll(pageable);
	}

	
	

}
