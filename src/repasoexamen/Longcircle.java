package repasoexamen;

import java.util.Scanner;

public class Longcircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float radio;
		double circunferencia, area;
		Scanner scan;
		scan = new Scanner(System.in);
		
		System.out.print("Introduce el valor del radio: ");
		radio = scan.nextFloat();
		circunferencia = (2* radio * Math.PI);
		System.out.printf("El valor de la circunferencia es: %.2f", circunferencia );
		System.out.print("Develop by Anthony.\n\n");
		
		System.out.println("Calcular el area de una circunferencia.");
		System.out.print("Introduce el radio: ");
		radio = scan.nextFloat();
		scan.close();
		area = (Math.PI*Math.pow(radio,2));
		System.out.println("El area de un circulo con radio "  + radio + " es: " + area);
		
		
		
	}

}
