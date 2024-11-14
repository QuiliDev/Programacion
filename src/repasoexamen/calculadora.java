package repasoexamen;
//import java.io.IOException;
import java.util.Scanner;
public class calculadora {

	public static void main(String[] args) /*throws IOException, InterruptedException*/{
		String Nombre;
		Scanner scan;
		scan = new Scanner(System.in);
		float suma = 0, resta = 0, multiplicacion = 0, operador = 0, division = 0;
		float vector[] = new float [10];
		int cantidadVector;
		char opcion;
		
		do {
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("====== MI PROGRAMA =======");
			System.out.print("Introduce la cantidad de numeros a introducir: ");
			cantidadVector = scan.nextInt();
			for (int i= 0; i < cantidadVector ; i++) {
				System.out.print("Introduce el valor del numero[" + i + "]: ");
				vector[i] = scan.nextFloat();
				
			}
			System.out.print("Indicame que operacion deseas realizar.\n");
			System.out.println("(+). Suma");
			System.out.println("(-). Resta");
			System.out.println("(*). Multiplicación");
			System.out.println("(/). División");
			System.out.print("Selecciona la opcion: ");
			opcion  = scan.next().charAt(0);
			switch(opcion) {
			case '+' : {
				suma = vector[0];
				//System.out.println("suma: " + suma);
				for (int i=1; i<cantidadVector ;i++) {
				suma += vector[i];
				//System.out.println("vector[" + i + "]: " + vector[i]);
				//System.out.println("suma: " + suma);
				}	
				/*System.out.print(vector[0] + "\n");
				System.out.print(vector[1] + "\n");
				System.out.print(vector[2] + "\n");*/
			System.out.print("La suma de los numeros es: " + suma + "\n");
			System.out.print("Desea volver al inicio? (y/n): ");
			opcion = scan.next().charAt(0);
			}break;
				
			case '-':  {
				resta = vector[0];
				for (int i=1; i<cantidadVector ;i++) {
				resta -= vector[i];}
			System.out.print("La resta de los numeros es: " + resta + "\n");
			System.out.print("Desea volver al inicio? (y/n): ");
			opcion = scan.next().charAt(0);
			}
			break;
			
			case '*':  {
				multiplicacion = vector[0];
				for (int i=1; i<cantidadVector ;i++) {
				multiplicacion *= vector[i];}
			System.out.print("La multiplicacion de los numeros es: " + multiplicacion + "\n");
			System.out.print("Desea volver al inicio? (y/n): ");
			opcion = scan.next().charAt(0);
			}
			break;
			
			case '/':  {
				division = vector[0];
				for (int i=1; i<cantidadVector ;i++) {
				division /= vector[i];}
			System.out.print("La division de los numeros es: " + division + "\n");
			System.out.print("Desea volver al inicio? (y/n): ");
			opcion = scan.next().charAt(0);
			}
			
			break;
			
			default: {
				System.out.print("La opcion elegida no es valida, desea volver al inicio? (y/n): ");
				opcion = scan.next().charAt(0);
			} break;}	
			
		}
		while (opcion=='y');
		
		System.out.print("Fin del programa.");
		if (opcion=='n') {scan.close();}
		
	}

}
