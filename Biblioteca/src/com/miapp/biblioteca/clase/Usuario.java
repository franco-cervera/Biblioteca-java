package com.miapp.biblioteca.clase;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private String id;
	private ArrayList<Libro> librosPrestados;
	
	public Usuario() {
	}

	public Usuario(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
		this.librosPrestados = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	
	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", id=" + id + "]";
	
}
	

}
