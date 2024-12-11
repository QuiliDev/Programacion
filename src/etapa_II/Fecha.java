package etapa_II;

import java.io.Serializable;
import java.util.Objects;

public class Fecha implements Serializable{
	
	private static final long serialVersionUID = -3725604523581528872L;
	private int dia;
	private int mes;
	private int anio;
	
	
	//CONSTRUCTOR POR DEFECTO
	public Fecha () {
	}
	
	public Fecha (Fecha objetocopia) {
		dia = objetocopia.dia;
		mes = objetocopia.mes;
		anio = objetocopia.anio;
	}
	
	//CONSTRUCTOR PARAMETRIZADO
	public Fecha(int dia, int mes, int anio) {
		if (dia >=1 && dia <=31) {
			this.dia = dia;
		}
		if (mes >=1 && mes <=12) {
			this.mes = mes;
		}
		if (anio >=1) {
			this.anio = anio;
		}
		
	}
	
	
	
	
	
	//METODOS GETTER
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getAnio() {
		return anio;
	}
	
	//METODO SETTER
	public void setDia(int dia) {
		if (dia >=1 && dia <=31) {
			this.dia = dia;
		}
	}
	public void setMes(int mes) {
		if (mes >=1 && mes <=12) {
			this.mes = mes;
		}
	}
	public void setAnio(int anio) {
		if (anio >=1) {
			this.anio = anio;
		}
	}
	
	public String toString() {
		return (dia + "/" + mes + "/" + anio);
	}
	
	public boolean equals(Fecha FECHA) {
		if (dia == FECHA.dia &&
			mes == FECHA.mes &&
			anio == FECHA.anio) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Fecha otraFecha) {
	    if (otraFecha.anio > anio) {
	        return -1; // otraFecha es mayor
	    } else if (otraFecha.anio < anio) {
	        return 1; // otraFecha es menor
	    } else {
	        // Si los años son iguales, comparar meses
	        if (otraFecha.mes > mes) {
	            return -1; // otraFecha es mayor
	        } else if (otraFecha.mes < mes) {
	            return 1; // otraFecha es menor
	        } else {
	            // Si los meses son iguales, comparar días
	            if (otraFecha.dia > dia) {
	                return -1; // otraFecha es mayor
	            } else if (otraFecha.dia < dia) {
	                return 1; // otraFecha es menor
	            } else {
	                return 0; // Las fechas son iguales
	            }
	        }
	    }
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dia, mes, anio);
	}

	public String toXML() {
		String xml = "<dia>" + this.dia + "</dia>\n";
		xml += "<mes>" + this.mes + "</mes>\n";
		xml += "<anio>" + this.anio + "</anio>\n";
		return xml;
	}
	
	
	
}
