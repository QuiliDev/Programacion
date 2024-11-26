	package etapa_II;

public class MainFecha {

	public static void main(String[] args) {
		
		Fecha f1 = new Fecha();
		System.out.println("Fecha1: " + f1);
		
		Fecha f2= new Fecha(16,12,1996);

		System.out.println("Fecha2: " + f2);
		
		//objeto prueba error constructor
		Fecha f3 = new Fecha(15,12,1996);
		System.out.println("Fecha3: " + f3);
		
		if(f2.compareTo(f3) == -1) {
			System.out.println("la f3 es mayor a f1");
		}
		else if (f2.compareTo(f3) == 1) {
			System.out.println("la f3 es menor a f1");
		}
		else if (f2.compareTo(f3) == 0) {
			System.out.println("Ambas fechas son iguales");
		}
		

		System.out.println("Hashcode f1: " + f1.hashCode());
		System.out.println("Hashcode f2: " + f2.hashCode());
		System.out.println("Hashcode f3: " + f3.hashCode());
		
		
		
	}

}
