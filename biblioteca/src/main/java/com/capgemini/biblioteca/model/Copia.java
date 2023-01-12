package com.capgemini.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="copias")
public class Copia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
//	@Column
//	private String isbn;
	
	@Column
	private EstadoCopia estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name="isbn")
	private Libro libro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoCopia getEstado() {
		return estado;
	}

	public void setEstado(EstadoCopia estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Copia() {
		super();
	}

	public Copia(Long id, EstadoCopia estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	public Copia(long id, int estado) {
		super();
		this.id = id;
		this.estado = EstadoCopia.parseInt(estado);
	}
	
	
}
