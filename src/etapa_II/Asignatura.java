package etapa_II;

import java.util.Objects;

public class Asignatura implements Comparable<Asignatura> {

	private String codigo;
	private String descripcion;
	private double nota;
	
	
	//METODO CONSTRUCTOR POR DEFECTO
	public Asignatura() {
		this.codigo = "NULL";
		this.descripcion = "NULL";
		this.nota = 0.0;
	}
	
	//METODO CONSTRUCTOR DE COPIA 
	public Asignatura(Asignatura objetocopia) {
		this.codigo = objetocopia.codigo;
		this.descripcion = objetocopia.descripcion;
		this.nota = objetocopia.nota;
		
	}
	//METODO CONSTRUCTOR POR PARAMETRO
	public Asignatura (String codigo, String descripcion,
			double nota) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nota = nota;
			}
	
	
	
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

	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nota);
	}
	

	public boolean equals(Asignatura objetocomparar) {
		
		
		return false;
	}
	
	@Override
	public int compareTo(Asignatura o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return (this.codigo + " - " + this.nota);
	}
	
	
}
	