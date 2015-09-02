package controller;

import java.awt.Image;

public class Persona {
	
	private String nombre;
	private int edad;
	private String descripcion;
	private String dni;
	private Image foto;
	
	public Persona() {
	}

	public Persona(int edad, String nombre, String descripcion) {
		
		this.edad = edad;
		this.nombre = nombre;
		this.descripcion = descripcion;

	}
	
	public Persona(int edad, String nombre, String descripcion, String dni, Image foto) {
		
		this.edad = edad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dni = dni;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return (this.nombre + " " + this.edad + " " + this.descripcion);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Image getFoto() {
		return foto;
	}

	public void setFoto(Image foto) {
		this.foto = foto;
	}

}
