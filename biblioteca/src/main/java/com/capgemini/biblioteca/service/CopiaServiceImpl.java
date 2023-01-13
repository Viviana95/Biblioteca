package com.capgemini.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca.model.Copia;
import com.capgemini.biblioteca.model.Lector;
import com.capgemini.biblioteca.repository.CopiaRepository;
import com.capgemini.biblioteca.repository.CopiaRepositoryImpl;

@Service
public class CopiaServiceImpl implements CopiaService {
	
	@Autowired
	private CopiaRepositoryImpl copiaRepo;
	
	@Autowired
	private CopiaRepository jpaRepo;
	
	@Override
	public List<Copia> getAllCopias() {
		return this.jpaRepo.findAll();
	}

	@Override
	public List<Copia> getCopiasByIsbn(String isbn) {
		List<Copia> copias = copiaRepo.getCopiasByIsbn(isbn);
//		if (copias.isEmpty()) 
//			throw new RuntimeException("no se encuentran copias del isbn: " + isbn);
		return copias;
	}
	
	public Copia getCopiaById(Long id) {
		Optional<Copia> optionalCopia = this.jpaRepo.findById(id);
		Copia copia=null;
		if(optionalCopia.isPresent()) {
			copia = optionalCopia.get() ;
		}else {throw new RuntimeException("no se encuentra el lector con el Número de Socio: " + id);	}
		return copia;
	}

	@Override
	public void saveCopia(Copia copia) {
		this.jpaRepo.save(copia);
	}

	@Override
	public void deleteCopiaById(long id) {
		this.jpaRepo.deleteById(id);

	}

	@Override
	public Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.jpaRepo.findAll(pageable);
	}

}
