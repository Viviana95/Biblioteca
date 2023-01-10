package com.capgemini.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long titulo;	
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
	private String fechNacAutor;
	
	public Libro() {
		super();
	}

	public Libro(Long titulo, TipoLibro tipo, String editorial, String anyo, String nombreAutor, String nacAutor,
			String fechNacAutor) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.editorial = editorial;
		this.anyo = anyo;
		this.nombreAutor = nombreAutor;
		this.nacAutor = nacAutor;
		this.fechNacAutor = fechNacAutor;
	}

	public Long getTitulo() {
		return titulo;
	}

	public void setTitulo(Long titulo) {
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

	public String getFechNacAutor() {
		return fechNacAutor;
	}

	public void setFechNacAutor(String fechNacAutor) {
		this.fechNacAutor = fechNacAutor;
	}
	

}
