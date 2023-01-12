package com.capgemini.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

}
