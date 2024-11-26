package etapa_II;

public class Asignatura {

	private String codigo;
	private String descripcion;
	private double nota;
	
	
	//METODO CONSTRUCTOR POR DEFECTO
	public Asignatura() {}
	
	//METODO CONSTRUCTOR DE COPIA 
	public Asignatura(Asignatura objetocopia) {
		
	}
	//METODO CONSTRUCTOR POR PARAMETRO
	
	
	
	//METODOS GETTERS

	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getNota() {
		return nota;
	}
	
	//METODOS SETTERS
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
	