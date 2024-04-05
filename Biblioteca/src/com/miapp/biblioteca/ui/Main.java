package com.miapp.biblioteca.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.miapp.biblioteca.clase.Libro;
import com.miapp.biblioteca.clase.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Usuario> usuario = new ArrayList<>();
		ArrayList<Libro> biblioteca = new ArrayList<>();
		LibroServicio libroServicio = new LibroServicio(biblioteca);	
		UsuarioServicio usuarioServicio = new UsuarioServicio(usuario);
	
		int opcion;
		do {
			System.out.println("===== Biblioteca Virtual =====");
			System.out.println(" ");
			System.out.println("--- Administrador ---");
			System.out.println("1. Crear Usuario");
			System.out.println("2. Actualizar usuario");
			System.out.println("3. Buscar Usuario por ID");
			System.out.println("4. Eliminar Usuario");
			System.out.println(" ");
			System.out.println("--- Usuario ----");
			System.out.println("5. Crear Libro");
			System.out.println("6. Actualizar Libro");
			System.out.println("7. Buscar Libro por ISBN");
			System.out.println("8. Buscar Libros por Titulo");
			System.out.println("9. Listar Libros");
			System.out.println("10. Eliminar Libro");
			System.out.println("11. Prestamos");
			System.out.println("12. Devoluciones");
			System.out.println(" ");
			System.out.println("0. Salir");
			System.out.println(" ");
			System.out.println("Seleccione una opcion: ");
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch(opcion) {
			case 1:
				//Crear Usuario
				System.out.println("Ingrese el nombre de usuario: ");
				String nombre = scan.nextLine();
				System.out.println("Ingrese el id: ");
				String id = scan.nextLine();
				usuarioServicio.crearUsuario(nombre, id);
				break;
				
			case 2:
				//Actualizar usuario
				System.out.println("Ingrese el id del usuario a actualizar: ");
				String idActualizar = scan.nextLine();
				System.out.println("Ingrese el nuevo nombre: ");
				String nuevoNombre = scan.nextLine();
				usuarioServicio.actualizarUsuario(idActualizar, nuevoNombre);
				break;
				
			case 3:
				//Buscar usuario por ID
				System.out.println("Ingrese el ID del usuario a buscar: ");
				String idBuscar = scan.nextLine();
				Usuario usuarioID = usuarioServicio.buscarUsuarioporID(idBuscar);
				if (usuarioID != null) {
					System.out.println("Usuario encontrado: " + usuarioID.getNombre());
				} else {
					System.out.println("Usuario no encontrado");
				}
				break;
				
			case 4:
				//Eliminar usuario
				System.out.println("Ingrese el ID del usuario a eliminar: ");
				String idEliminar = scan.nextLine();
				usuarioServicio.eliminarUsuario(idEliminar);
				break;
				
			
			case 5:
				//Crear Libro
				System.out.println("Ingrese el titulo: ");
				String titulo = scan.nextLine();
				System.out.println("Ingrese el autor: ");
				String autor = scan.nextLine();
				System.out.println("Ingrese el ISBN: ");
				String ISBN = scan.nextLine();
				System.out.println("Ingrese el genero: ");
				String genero = scan.nextLine();
				libroServicio.crearLibro(titulo, autor, ISBN, genero);
				break;
				
			case 6:
				//Actualizar Libro
				System.out.println("Ingrese el ISBN del libro a actualizar: ");
				String isbnActualizar = scan.nextLine();
				System.out.println("Ingrese el nuevo titulo: ");
				String nuevoTitulo = scan.nextLine();
				System.out.println("Ingrese el nuevo autor: ");
				String nuevoAutor = scan.nextLine();
				System.out.println("Ingrese el nuevo genero: ");
				String nuevoGenero = scan.nextLine();
				libroServicio.actualizarLibro(isbnActualizar, nuevoTitulo, nuevoAutor, nuevoGenero);
				break;
				
			case 7:
				//Buscar Libro por ISBN
				System.out.println("Ingrese el ISBN del libro a buscar: ");
				String isbnBuscar = scan.nextLine();
				Libro libroISBN = libroServicio.buscarLibroPorISBN(isbnBuscar);
				if (libroISBN != null) {
					System.out.println("Libro encontrado: " + libroISBN.getTitulo());
				} else {
					System.out.println("Libro no encontrado");
				}
				break;
				
			case 8:
				//Buscar Libro por titulo
				System.out.println("Ingrese el titulo a buscar: ");
				String tituloBuscar = scan.nextLine();
				ArrayList<Libro> librosPorTitulo = libroServicio.buscarLibrosPorTiutulo(tituloBuscar);
				if(!librosPorTitulo.isEmpty()) {
					System.out.println("Libros encontrados: ");
					for (Libro libro : librosPorTitulo) {
						System.out.println(libro.getTitulo());
					}
				} else {
					System.out.println("Ningun libro encontrado con ese titulo");
				}
				break;
				
			case 9:
				//Listar libros
				ArrayList<Libro> listaLibros = libroServicio.obtenerTodosLosLibros();
				for (Libro libro : listaLibros) {
					System.out.println(libro.getTitulo() + "[" + libro.getISBN() + "]");
				}
				break;
				
			case 10:
				//Eliminar libro
				System.out.println("Ingrese el ISBN del libro a eliminar: ");
				String isbnEliminar = scan.nextLine();
				libroServicio.eliminarLibro(isbnEliminar);
				break;
				
			case 11:
				//Prestamos
				System.out.println("Ingrese el id del usuario: ");
				String idUsuario = scan.nextLine();
				Usuario usuarioPrestamo = usuarioServicio.buscarUsuarioporID(idUsuario);
				if(usuarioPrestamo != null) {
					System.out.println("Ingrese el ISBN del libro a prestar: ");
					String isbnPrestamo = scan.nextLine();
					Libro libroPrestamo = libroServicio.buscarLibroPorISBN(isbnPrestamo);
					if(libroPrestamo != null) {
						if(libroServicio.verificarDisponibilidad(libroPrestamo)) {
						usuarioServicio.prestarLibro(usuarioPrestamo, libroPrestamo);
						System.out.println("Prestamo exitoso. Libro prestado a: " + usuarioPrestamo.getNombre());
					} else {  
						System.out.println("El libro no esta disponible para prestamo");
					}
				} else {
					System.out.println("Libro no encontrado");
				}
				} else {
					System.out.println("Usuario no encontado");			
				}
				break;
			
			case 12:
				//Devoluciones
				System.out.println("Ingrese el id del usuario: ");
				String idUsuario1 = scan.nextLine();
				Usuario usuarioDevolucion = usuarioServicio.buscarUsuarioporID(idUsuario1);
				if(usuarioDevolucion != null) {
					System.out.println("Ingrese el ISBN del libro a devolver: ");
					String isbnDevolucion = scan.nextLine();
					Libro libroDevolucion = libroServicio.buscarLibroPorISBN(isbnDevolucion);
					if(libroDevolucion != null) {
						usuarioServicio.devolverLibro(usuarioDevolucion, libroDevolucion);
						System.out.println("Devolucion exitosa. Libro devuelvo por: " + usuarioDevolucion.getNombre());
					} else {
						System.out.println("Libro no encontrado");
					}
				} else {
					System.out.println("Usuario no encontardo");
				}
				break;
			case 0: 
				System.out.println("### Gracias por utilizar la Biblioteca Virtual ###");
				break;
			default:
				System.out.println("Opcion no valida. Intente de nuevo");
								
			}			
			
		} while (opcion!=0);
	}

}
