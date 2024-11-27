package etapa_II;

public class Alumno extends Persona {
	
	String grupo;
	
	public Alumno(String dni, String nombre, 
			String apellido, int dia, int mes, 
			int anio, String grupo) {
		
		super(dni, nombre, apellido, dia, mes, anio);
		this.grupo = grupo;
	}
	
	
	public String toString() {
		return (super.toString() + "\n" + "GRUPO: " + this.grupo);
		
	};
	
}
