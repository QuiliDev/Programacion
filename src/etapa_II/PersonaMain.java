package etapa_II;

public class PersonaMain {

	public static void main(String[] args) {
		
		
		Persona p1 = new Persona();
		p1.setFechaNacimiento(16, 12, 1996);
		System.out.println(p1);
		System.out.println("-----------------------");
		
		Persona p2 =new Persona("Z2005813B","JUAN","PEREZ",16,12,1996);
		System.out.println(p2);
		System.out.println("-----------------------");
		
		Persona p3 =new Persona("Y2004713A","PEDRO","SUAREZ",26,05,2005);
		System.out.println(p3);
		
		
		if (p2.equals(p3)) {
			System.out.println(p2.getNombre()+" y "+p3.getNombre()+" Son iguales");
		}
		else {
			System.out.println("Son diferentes");
		}
	
		if (p2.compareTo(p3) > 0) {
			System.out.println(p2.getDni()+" es mayor que "+p3.getDni());
		}
		else if (p2.compareTo(p3) < 0) {
			System.out.println(p2.getDni()+" es menor que "+p3.getDni());
		}
		else {
			System.out.println("Son iguales");
		}
		
		
		
	}

}
