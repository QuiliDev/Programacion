package etapa_II;

import java.util.Objects;

public class Racional implements Comparable<Racional>{

	private int numerador;	// Numerador
	private int denominador;	// Denominador
			
	// Constructor
	public Racional() {
		this.numerador = 0;
		this.denominador = 0;
	}
	
	//Constructor de copia
	public Racional(Racional r) {
		this.numerador = r.numerador;
		this.denominador = r.denominador;
	}
	
	// Constructor con parámetros
	public Racional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	
	// Método para simplificar un racional
	public void simplificar() {
		int mcd = mcd(this.numerador, this.denominador);
		this.numerador = this.numerador / mcd;
		this.denominador = this.denominador / mcd;
	}
	// Método para calcular el máximo común divisor
	private int mcd(int a, int b) {
		int mcd = 1;
		int min = Math.min(a, b);
		for (int i = 1; i <= min; i++) {
			if (a % i == 0 && b % i == 0) {
				mcd = i;
			}
		}
		return mcd;
	}
	
	// Método para dividir dos racionales
	public Racional dividir(Racional r) {
		Racional res = new Racional();
		res.numerador = this.numerador * r.denominador;
		res.denominador = this.denominador * r.numerador;
		return res;
	}
	
	// Método para comparar dos racionales
	public boolean equals(Racional r) {
		return (this.numerador * r.denominador == r.numerador * this.denominador);
	}
	
	//Metodo para restar un racional
	public Racional restar() {
		Racional res = new Racional();
		res.numerador = -this.numerador;
		res.denominador = this.denominador;
		return res;
	}
	
	// Método para sumar dos racionales
	public Racional sumar(Racional r) {
		Racional res = new Racional();
		res.numerador = this.numerador * r.denominador + r.numerador * this.denominador;
		res.denominador = this.denominador * r.denominador;
		return res;
	}
	
	// Método para restar dos racionales
	public Racional restar(Racional r) {
		Racional res = new Racional();
		res.numerador = this.numerador * r.denominador - r.numerador * this.denominador;
		res.denominador = this.denominador * r.denominador;
		return res;
	}
	// Método para multiplicar dos racionales
	public Racional multiplicar(Racional r) {
		Racional res = new Racional();
		res.numerador = this.numerador * r.numerador;
		res.denominador = this.denominador * r.denominador;
		return res;
	}
	// Método para calcular el factorial de un número
	public int factorial(int numero) {
        if (numero < 0) {
            System.out.println("Error, el número debe ser no negativo.");
        }
        int resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
	
	//Metodo para comparar dos racionales
	public boolean mayorQue(Racional r) {
		return (this.numerador * r.denominador > r.numerador * this.denominador);
	}
	
	
	// Métodos para obtener el numerador y el denominador
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}
	
	// Métodos para establecer el numerador y el denominador

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public void setDenominador(int denominador) {
        this.denominador = denominador;
        }
	
	//Metodo para mostrar el racional
	public String toString() {
		return (numerador + "/" + denominador);
	}

	
	public Double toDouble() {
        return ((double) numerador / (double) denominador);
        
    }

	@Override
	public int hashCode() {
		return Objects.hash(denominador, numerador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Racional other = (Racional) obj;
		
		
		return this.numerador * other.denominador == this.denominador * other.numerador;

		//return denominador == other.denominador && numerador == other.numerador;
	}

	@Override
	public int compareTo(Racional o) {
		
		if (this.numerador * o.denominador > this.denominador * o.numerador) {
			return 1;
		}
		return 0;

	}
	
	
}
