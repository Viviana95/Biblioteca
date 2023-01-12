package com.capgemini.biblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos")
public class Prestamo {
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_prestamo;
	
	@Column
	private LocalDate inicio;
	
	@Column
	private LocalDate fin;
	
	@OneToOne
	@JoinColumn( name="id_copia")
	private Copia copia;
	
	@ManyToOne
	@JoinColumn( name="nSocio")
	private Lector lector;
	
}
