package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.clase.Libro;
import com.miapp.biblioteca.clase.Usuario;

public class UsuarioServicio {
	
	private ArrayList<Usuario> usuarios; //ArrayList que contiene usuarios

	public UsuarioServicio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioServicio() {
	}
	
	//Crear nuevo Usuario
	public void crearUsuario(String nombre, String id) {
		Usuario nuevoUsuario = new Usuario(nombre,id);
		usuarios.add(nuevoUsuario);
	}
	
	//Leer todos los Usuarios
	public ArrayList<Usuario> obtenerTodosLosUsuarios(){
		return usuarios;
	}
	
	//Actualizar usuario
	public void actualizarUsuario(String id, String nuevoNombre) {
		for (Usuario usuario : usuarios) {
			if(usuario.getid().equals(id)) {
				usuario.setNombre(nuevoNombre);
				return;
			}
		}
	}
	
	//Eliminar usuario
	public void eliminarUsuario(String id) {
		Iterator<Usuario> it = usuarios.iterator();
		
		while(it.hasNext()) {
			if(it.next().getid().equals(id)) {
				it.remove();
			}
		}
	}
	
	//Prestar libro
	public void prestarLibro(Usuario usuario, Libro libro) {
		if(libro.isDisponible()) {
			usuario.getLibrosPrestados().add(libro);
			libro.setDisponible(false);
			//Registrar prestamo en lista y actualizar la disponibilidad
		} else {
			System.out.println("El libro no está disponible para préstamo");
		}
	}
	
	//Buscar usuario por ID
	public Usuario buscarUsuarioporID(String id) {
		for (Usuario usuario : usuarios) {
			if(usuario.getid().equals(id)) {
				return usuario;
			}
		}
		return null; //Retorna null si no encuentra ningun usuario por ID
}
	//Devolver libro
	public void devolverLibro(Usuario usuario, Libro libro) {
		if(usuario.getLibrosPrestados().contains(libro)) {
			usuario.getLibrosPrestados().remove(libro);
			libro.setDisponible(true);
			//Registrar devolucion del libro y actualizar la disponibilidad
		} else {
			System.out.println("Este libro no fue prestado por este usuario");
		}
	}
	
	//Ver libros prestados por el usuario
	public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
		return usuario.getLibrosPrestados();
	}
	

}
