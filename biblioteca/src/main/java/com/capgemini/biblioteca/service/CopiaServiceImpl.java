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
import com.capgemini.biblioteca.repository.CopiaRepository;

@Service
public class CopiaServiceImpl implements CopiaService {
	
	@Autowired
	private CopiaRepository copiaRepo;
	
	@Override
	public List<Copia> getAllCopias() {
		return this.copiaRepo.findAll();
	}

	@Override
	public Copia getCopiasByIsbn(String isbn) {
		Optional<Copia> optionalCopia = this.copiaRepo.findById(Long.parseLong(isbn));
		Copia copia = null;
		if (optionalCopia.isPresent()) {
			copia = optionalCopia.get();
		} else
			throw new RuntimeException("no se encuentra el libro con el isbn: " + isbn);
		return copia;
	}

	@Override
	public void saveCopia(Copia copia) {
		this.copiaRepo.save(copia);
	}

	@Override
	public void deleteCopiaById(long id) {
		this.deleteCopiaById(id);

	}

	@Override
	public Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		copiaRepo.findBy(null, null).
		return this.copiaRepo.findAll(pageable);
	}

}
