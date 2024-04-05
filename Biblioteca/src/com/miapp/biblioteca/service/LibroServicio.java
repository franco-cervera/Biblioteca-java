package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.clase.Libro;

public class LibroServicio {

	private ArrayList<Libro> biblioteca; //Arraylist que contiene los libros

	public LibroServicio(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}


	public LibroServicio() {
	}


	//Crear un nuevo libro
	public void crearLibro (String titulo, String autor, String ISBN, String genero) {
		Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
		biblioteca.add(nuevoLibro);
	}
	
	//Leer todos los libros
	public ArrayList<Libro> obtenerTodosLosLibros (){
		return biblioteca;
	}
	
	//Actualizar libro
	public void actualizarLibro (String ISBN, String nuevoTitulo, String nuevoAutor, String nuevoGenero) {
		
		for (Libro libro : biblioteca) {
			if (libro.getISBN().equals(ISBN)) {
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setGenero(nuevoGenero);
			}
		}
	}
	
	//Eliminar libro
	public void eliminarLibro(String ISBN) {
		Iterator<Libro> it = biblioteca.iterator();
		
		while(it.hasNext()) {
			if(it.next().getISBN().equals(ISBN)) {
				it.remove();
			}
		}
	}
	
	//Buscar libro por ISBN
	public Libro buscarLibroPorISBN(String ISBN) {
		for (Libro libro : biblioteca) {
			if(libro.getISBN().equals(ISBN)) {
				return libro;
			}
		}
		return null; //Retorna null si no encuentra ningún libro con el ISBN
	}
	
	//Buscar libro por titulo
	public ArrayList<Libro> buscarLibrosPorTiutulo(String titulo){
		ArrayList<Libro> librosEncontrados = new ArrayList<>();
		for (Libro libro : biblioteca) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) {
				librosEncontrados.add(libro);
			}
		}
		return librosEncontrados;
	}
	
	//Verificar disponibilidad del libro
	public boolean verificarDisponibilidad (Libro libro) {
		return libro.isDisponible();
	}
}
