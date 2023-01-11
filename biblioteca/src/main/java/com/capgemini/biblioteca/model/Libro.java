package com.capgemini.biblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	
	@Id
	private String isbn;
	
	@Column
	private String titulo;	
	@Column
	private TipoLibro tipo;	
	@Column
	private String editorial;	
	@Column
	private String anyo;
	
	@Column(name="nombre_autor")
	private String nombreAutor;
	
	@Column(name="nacionalidad_autor")
	private String nacAutor;
	
	@Column(name="nacimiento_autor")
	private LocalDate fechNacAutor;
	
	public Libro() {
		super();
	}

	public Libro(String isbn, String titulo, TipoLibro tipo, String editorial, String anyo, String nombreAutor,
			String nacAutor, LocalDate fechNacAutor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.tipo = tipo;
		this.editorial = editorial;
		this.anyo = anyo;
		this.nombreAutor = nombreAutor;
		this.nacAutor = nacAutor;
		this.fechNacAutor = fechNacAutor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoLibro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLibro tipo) {
		this.tipo = tipo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNacAutor() {
		return nacAutor;
	}

	public void setNacAutor(String nacAutor) {
		this.nacAutor = nacAutor;
	}

	public LocalDate getFechNacAutor() {
		return fechNacAutor;
	}

	public void setFechNacAutor(LocalDate fechNacAutor) {
		this.fechNacAutor = fechNacAutor;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", tipo=" + tipo + ", editorial=" + editorial + ", anyo="
				+ anyo + ", nombreAutor=" + nombreAutor + ", nacAutor=" + nacAutor + ", fechNacAutor=" + fechNacAutor.toString()
				+ "]";
	}

	
	

}
