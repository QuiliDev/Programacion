package etapa_II;

import java.util.Objects;

public class Persona implements Comparable<Persona> {
	
	private String dni;
	private String nombre;
	private String apellido;
	private Fecha fechaNacimiento;
	
	
	
	//METODO CONSTRUCTOR POR DEFECTO
	public Persona() {
		this.dni = "NULL";
		this.nombre = "NULL";
		this.apellido = "NULL";
		this.fechaNacimiento = new Fecha(0, 0, 0);
	}
	
	//METODO CONSTRUCTOR COPIA
	public Persona(Persona objetocopia) {
		this.dni = objetocopia.dni;
		this.nombre = objetocopia.nombre;
		this.apellido = objetocopia.apellido;
		this.fechaNacimiento = new Fecha(objetocopia.fechaNacimiento);
	}
	
	//METODO CONSTRUCTOR POR PARAMETRO
	public Persona(String dni, String nombre, String apellido,
					int dia, int mes, int anio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = new Fecha(dia, mes, anio);
	}
	
	
	
	
	//METODOS GETTERS
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}	

	public String getApellido() {
		return apellido;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	//METODOS SETTERS

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(int dia, int mes, int anio) {
	    this.fechaNacimiento = new Fecha(dia, mes, anio);
	}
	
	
	//METODO DE toString
	public String toString() {
		return (this.dni + " " + this.nombre + " " + this.apellido + " " + this.fechaNacimiento);
	}
//	public String toString() {
//		return (("Informacion de la persona: ") +"\n" +("DNI: " + this.dni) +"\n" +
//				("NOMBRE: " + this.nombre)+"\n" +("APELLIDO: " + this.apellido)+"\n" +
//				("FECHA NACIMIENTO: " + this.fechaNacimiento)
//				);
//	}
//	
	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, apellido, fechaNacimiento);
	}
	
//	public boolean equals(Persona objetocomparar) {
//		
//		if (this.dni.equals(objetocomparar.dni)) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	public boolean equals(Object objetocomparar) {
		if (this == objetocomparar) {
			return true; // Si el objeto es el mismo, se considera igual
		}
		
		if (objetocomparar == null) {
			return false; // Si el objeto es null, se considera diferente
		}
		
		if (getClass() != objetocomparar.getClass()) {
			return false; // Si el objeto no es de la misma clase, se considera diferente
		}
		
		// Verificar si los atributos son iguales
		Persona other = (Persona) objetocomparar; // Convertir el objeto a la clase Persona
		if (dni.equals(other.dni)) {
			return true;
		}
		return false;
	}


	
	
	@Override
	public int compareTo(Persona objetocomparar) {
		return (this.dni.compareTo(objetocomparar.dni));
	}
	
	
	
}
