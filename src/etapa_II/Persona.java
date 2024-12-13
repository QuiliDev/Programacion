package etapa_II;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Comparable<Persona>, Serializable {
	
	private static final long serialVersionUID = -3263859482296705000L;
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
	
	//METODO CONSTRUCTOR POR PARAMETRO
	public Persona(String dni, String nombre, String apellido, Fecha fechaNacimiento) {
	    this.dni = dni;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.fechaNacimiento = fechaNacimiento;  // No necesitas crear un nuevo objeto Fecha
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
	    String dni1 = this.dni;
	    String dni2 = objetocomparar.dni;
	    
	    // Comparar las letras
	    int resultado = dni1.substring(0, 3).compareTo(dni2.substring(0, 3));
	    if (resultado == 0) {
	        // Comparar los números como enteros
	        int num1 = Integer.parseInt(dni1.substring(3));
	        int num2 = Integer.parseInt(dni2.substring(3));
	        resultado = Integer.compare(num1, num2);
	    }
	    return resultado;
	}
	public String toXML() {
		String xml = "<persona>\n";
		xml += "<dni>" + this.dni + "</dni>\n";
		xml += "<nombre>" + this.nombre + "</nombre>\n";
		xml += "<apellido>" + this.apellido + "</apellido>\n";
		xml += "<fechaNacimiento>" + this.fechaNacimiento.toXML() + "</fechaNacimiento>\n";
		xml += "</persona>\n";
		return xml;
	}
	
	
}
