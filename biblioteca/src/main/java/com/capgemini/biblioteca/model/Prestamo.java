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

	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestamo(Long id_prestamo, LocalDate inicio, LocalDate fin, Copia copia, Lector lector) {
		super();
		this.id_prestamo = id_prestamo;
		this.inicio = inicio;
		this.fin = fin;
		this.copia = copia;
		this.lector = lector;
	}

	public Long getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(Long id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
	
	
}
