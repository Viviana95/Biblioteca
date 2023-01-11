package com.capgemini.biblioteca.service;

import java.util.List;

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
	public Copia getCopiasByIsbn(long nSocio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCopia(Copia copia) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCopiaById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Copia> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortField).ascending() :
					Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNum -1, pageSize, sort);
		return this.copiaRepo.findAll(pageable);
	}

}
