package etapa_II;

public class MainRacional {
	public static void main(String[] args) {
		Racional r1 = new Racional();
		System.out.println("Racional 1: " + r1);
		

		Racional r2 = new Racional(r1);
		System.out.println("Racional 2: " + r2.toString());
		//r2.factorial(4);

		
		Racional r5 = new Racional();
		r5.setNumerador(21);
		r5.setDenominador(3);
		
		Racional r6 = new Racional();
		r6.setNumerador(20);
		r6.setDenominador(5);
		
		if (r5.equals(r6)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("Son distintos");
		}
		if (r5.compareTo(r6) == 1) {
			System.out.println("r5 es mayor que r6");
		} else {
			System.out.println("r5 es menor que r6");
		}
	
		
		
		
		
		
		
	}

}
