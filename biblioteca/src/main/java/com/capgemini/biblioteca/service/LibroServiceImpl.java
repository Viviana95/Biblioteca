package com.capgemini.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca.model.Libro;
import com.capgemini.biblioteca.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	private LibroRepository libroRepo;
	
	@Override
	public List<Libro> getAllLibros() {
		
		return this.libroRepo.findAll();
	}

	@Override
	public Libro getLibroByIsbn(String isbn) {
		Optional<Libro> optionalLibro = this.libroRepo.findById(isbn);
		Libro libro=null;
		if(optionalLibro.isPresent()) {
			libro = optionalLibro.get() ;
		}else {throw new RuntimeException("no se encuentra el libro con el isbn: " + isbn);	}		
		
		return libro;
	}

	@Override
	public void saveLibro(Libro libro) {
		this.libroRepo.save(libro);
		
	}

	@Override
	public void deleteLibroByIsbn(String isbn) {
		this.libroRepo.deleteById(isbn);
		
	}

	@Override
	public Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.libroRepo.findAll(pageable);
	}
	


}
