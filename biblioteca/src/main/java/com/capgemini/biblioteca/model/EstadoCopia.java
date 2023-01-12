package com.capgemini.biblioteca.model;

public enum EstadoCopia {
	PRESTADO(0), 
	RETRASO(1), 
	BIBLIOTECA(2), 
	REPARACION(3);

	private int id;

	private EstadoCopia(int id) {
		this.id = id;
	}

	public static EstadoCopia parseInt(int id) {
		for (EstadoCopia estado : values()) {
			if (estado.getId() == id)
				return estado;
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
