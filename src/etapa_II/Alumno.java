package etapa_II;

import java.io.Serializable;

public class Alumno extends Persona implements Serializable {
	
	private static final long serialVersionUID = 1117800909222465499L;
	String grupo;
	
	public Alumno(String dni, String nombre, 
			String apellido, int dia, int mes, 
			int anio, String grupo) {
		
		super(dni, nombre, apellido, dia, mes, anio);
		this.grupo = grupo;
	}
	
	public Alumno(Persona persona, String grupo) {
		super(persona.getDni(), persona.getNombre(), 
				persona.getApellido(), 
				persona.getFechaNacimiento().getDia(), 
				persona.getFechaNacimiento().getMes(), 
				persona.getFechaNacimiento().getAnio());
		this.grupo = grupo;
	}
	
	public String toString() {
		return (super.toString() + "\n" + "GRUPO: " + this.grupo);
		
	};
	
	
	
	@Override
    public int compareTo(Persona otro) {
        // Compara por DNI (puedes elegir otro criterio de comparación)
        return this.getDni().compareTo(otro.getDni()); // Asumiendo que `dni` es un campo heredado de la clase `Persona`
    }
	
	
	public String toXML() {
	    // Accede directamente a los métodos de la clase Persona
	    String xml = "<alumno>\n";
	    xml += "<dni>" + this.getDni() + "</dni>\n";  // Usa getDni() heredado de Persona
	    xml += "<nombre>" + this.getNombre() + "</nombre>\n";  // Usa getNombre() heredado de Persona
	    xml += "<apellido>" + this.getApellido() + "</apellido>\n";  // Usa getApellido() heredado de Persona
	    xml += "<fechaNacimiento>" + this.getFechaNacimiento().toXML() + "</fechaNacimiento>\n";  // Usa getFechaNacimiento() heredado de Persona
	    xml += "</alumno>\n";
	    return xml;
	}

}
