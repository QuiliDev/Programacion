	package repasoexamen;
	import java.util.Scanner;
	public class Hola {
	
		public static float suma = 0, resta = 0, multiplicacion = 0, division = 0, vector[] = new float [10];
		public static int cantidadVector, programa;
		public static char opcion;
		public static Scanner scan;
		
		public static void menu1() {
			scan = new Scanner(System.in);
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("================ MIS PROGRAMAS =================");
			System.out.print("Elige la opción del programa a ejecutar: ");
			System.out.print("Indicame que operacion deseas realizar.\n");
			System.out.println("1. Calculadora");
			System.out.println("2. Valorabs");
			System.out.println("3. Par o Impar");
			System.out.println("4. Calcular IVA");
			System.out.println("5. NxN");
			System.out.println("6. MayoroMenor");
			System.out.println("7. Retesuel");
			System.out.println("8. Segundoi");
			System.out.println("9. TabNotas");
			System.out.println("10. Bisiesto");
			System.out.println("11. Ec2grado");
			System.out.println("12. Mayor3n");
			System.out.println("13. Expendedorcambio");
			System.out.print("Selecciona la opción: ");
			programa  = scan.nextInt();
		};
		public static void menu_calculadora() {
			scan = new Scanner(System.in);
			//new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("================ MI PROGRAMA =================");
			System.out.print("Introduce la cantidad de números a introducir: ");
			cantidadVector = scan.nextInt();
			for (int i= 0; i < cantidadVector ; i++) {
				System.out.print("Introduce el valor del número[" + (i+1) + "]: ");
				vector[i] = scan.nextFloat();
				}
			System.out.print("Indicame que operacion deseas realizar.\n");
			System.out.println("[+]. Suma");
			System.out.println("[-]. Resta");
			System.out.println("[*]. Multiplicación");
			System.out.println("[/]. División");
			System.out.print("Selecciona la opción: ");
			opcion  = scan.next().charAt(0);
		};
	
		public static void main(String[] args) {
			do {
				menu1();
				switch (programa) {
				case 1: menu_calculadora(); break;
				case 2: valorabs(); break;
				case 3: parimpar(); break;
				case 4: calcuiva(); break;
				case 5: nxn(); break;
				case 6: mayoromenor(); break;
				case 7: retesuel(); break;
				case 8: segundoi(); break;
				case 9: tabnotas(); break;
				case 10: Bisiesto(); break;
				case 11: Ec2grado(); break;
				case 12: Mayor3n(); break;
				case 13: Expendedorcambio(); break;
				default: break;
				};
				
				switch(opcion) {
				case '+' : suma();break;
					
				case '-':  resta();break;
				
				case '*':  multiplicacion();break;
				
				case '/':  division();break;
				
				default: {
					System.out.print("\nDesea volver al inicio? (y/n): ");
					opcion = scan.next().charAt(0);
						 } break;}	
			}
			while (opcion=='y');
			
			System.out.print("Fin del programa.");
			if (opcion=='n') {scan.close();}
		}
		
		
		public static void suma() {
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
		System.out.print("La suma de los números es: " + suma + "\n");
		System.out.print("Desea volver al inicio? (y/n): ");
		opcion = scan.next().charAt(0);
		}
		
		public static void resta() {
		resta = vector[0];
		for (int i=1; i<cantidadVector ;i++) {
		resta -= vector[i];}
		System.out.print("La resta de los números es: " + resta + "\n");
		System.out.print("Desea volver al inicio? (y/n): ");
		opcion = scan.next().charAt(0);
		}
		
		public static void multiplicacion() {
		multiplicacion = vector[0];
		for (int i=1; i<cantidadVector ;i++) {
		multiplicacion *= vector[i];}
		System.out.print("La multiplicacion de los números es: " + multiplicacion + "\n");
		System.out.print("Desea volver al inicio? (y/n): ");
		opcion = scan.next().charAt(0);
		}
		
		public static void division() {
		division = vector[0];
		for (int i=1; i<cantidadVector ;i++) {
		division /= vector[i];}
		System.out.print("La division de los números es: " + division + "\n");
		System.out.print("Desea volver al inicio? (y/n): ");
		opcion = scan.next().charAt(0);
		}
		
		public static void valorabs () {
			System.out.print("Introduce un número: ");
			vector[1] = scan.nextFloat();
			if (vector[1]>=0) {
				System.out.print("El valor abosuluto del númeroes: " + vector[1]);
			}
			else {
				vector[1] = -(vector[1]);
				System.out.print("El valor abosuluto del número introducido es: " + vector[1]);
			};
			
		};
		
		public static void parimpar () {
			System.out.print("Introduce un número: ");
			vector[1] = scan.nextFloat();
			if ((vector[1]%2)==0) {
				System.out.println("El número es par.");
			}
			else {
				System.out.println("El número es impar.");
			};
		};
		
		public static void calcuiva () {
			float valorconiva;
			System.out.print("Introduce una cantidad de euros: ");
			vector[1] = scan.nextFloat();
			if (vector[1]<20000) {
				valorconiva = (vector[1]*7)/100;
				System.out.println("El valor del IVA es: " + valorconiva);
			}
			else {
				valorconiva = (vector[1]*16)/100;
				System.out.println("El valor del IVA es: " + valorconiva);
			};
		};
		
		public static void nxn () {
			float valorcuadrado, restante;
			System.out.println("Introduce un número: ");
			vector[1] = scan.nextFloat();
			valorcuadrado = (float) Math.pow(vector[1], 2);
			if (valorcuadrado>100) {
				valorcuadrado -= 100;
				System.out.println("el numero elevado al cuadrado es mayor a 100 y restando 100 es: " + valorcuadrado);
			}
			else {
				restante =(100-valorcuadrado);
				System.out.println("Al numero le falta " + restante + " para llegar a 100.");
			};
		};
	
		public static void mayoromenor () {
			System.out.print("Introduce el valor del número[1]:");
			vector[1] = scan.nextFloat();
			System.out.print("Introduce el valor del número[2]:");
			vector[2] = scan.nextFloat();
			
			if (vector[1]>vector[2]) {
			System.out.println("El primer número es mayor al segundo.");
			}
			else if (vector[1]<vector[2]) {
			System.out.println("El segundo número es mayor al segundo.");
			}else {
			System.out.println("Ambos números son iguales.");
			};
			
			
		};
		
		public static void retesuel () {
			System.out.print("Introduce tu sueldo:");
			vector[1] = scan.nextFloat();
			float retencion;
			if (vector[1]>1000 && vector[1]<2000) {
				retencion = (vector[1]*14)/100;
			System.out.println("La retención del sueldo es: " + retencion);
			}
			else if (vector[1]<1000) {
				retencion = (vector[1]*10)/100;
			System.out.println("La retención del sueldo es: " + retencion);} 
			else if (vector[1] == 1000){
				retencion = (vector[1]*12)/100;
			System.out.println("La retención del sueldo es: " + retencion);
			}
			else if (vector[1]==2000) {
				retencion = (vector[1]*16)/100;
			System.out.println("La retención del sueldo es: " + retencion);
			}
			else if (vector[1]>2000) {
				retencion = (vector[1]*18)/100;
			System.out.println("La retención del sueldo es: " + retencion);
			};
		};
		
		public static void segundoi () {
			int horas, minutos, segundos;
			System.out.print("Introduce el valor de la hora: ");
			horas = scan.nextInt();
			System.out.print("Introduce el valor de los minutos: ");
			minutos = scan.nextInt();
			System.out.print("Introduce el valor de los segundos: ");
			segundos = scan.nextInt();
			
			if (segundos<=58) {
			segundos++;
			}
			else if (segundos==59) {
			segundos = 0;
				if (segundos == 0) {
				minutos++;
					if (minutos == 60) {
						minutos = 0;
							if (minutos == 0) {
								horas++;
							}
					}
				}
			}
			
			if (segundos == 0 && minutos == 0) {
				System.out.println("Añadiendo un segundo obtenemos: " + horas + ":" + minutos + "0:" + segundos + "0");
				
			}
			else if (segundos == 0) {
				System.out.println("Añadiendo un segundo obtenemos: " + horas + ":" + minutos + ":" + segundos + "0");
			}
			else {
				System.out.println("Añadiendo un segundo obtenemos: " + horas + ":" + minutos +":" + segundos);}
			
		};
		
		public static void tabnotas () {
			System.out.print("Introduce el valor de tu nota: ");
			vector[1] = scan.nextFloat();
			/*
			 * NOTA CALIFICACION
				>=1 y <3 MD
				>=3 y <5 INS
				>=5 y <6 SUF
				>=6 y <7 BIEN
				>=7 y <9 NOT
				>=9 y <=10 SOBRE*/
			
			if (vector[1]>=1 && vector[1]<3) {	System.out.println("MD");}
			else if (vector[1]>=3 && vector[1]<5) {	System.out.println("INS");}
			else if (vector[1]>=5 && vector[1]<6) {	System.out.println("SUF");}
			else if (vector[1]>=6 && vector[1]<7) {	System.out.println("BIEN");}
			else if (vector[1]>=7 && vector[1]<9) {	System.out.println("NOT");}
			else if (vector[1]>9 && vector[1]<=10) {	System.out.println("SOBRE");}
			
		}
		
		public static void Bisiesto () {
			
			System.out.print("Introduce el año: ");
			vector[1] = scan.nextFloat();
			if ((vector[1]%4 == 0) && (vector[1]%100!=0 || vector[1]%400==0)) {
				System.out.println("El año es bisiesto");
			}
			else {
				System.out.println("El año no es bisiesto");
			};
		}
		
		public static void Ec2grado () {
			int valorA, valorB, valorC, raiz1, raiz2, delta;
			/*	A	B	C		X1	X2
			 * 	1	4	3		-1	-3
			 * 	1	2	1		-1	-1
			 * 	1	1	1		RAIZ COMPLEJA
			 * */
			System.out.print("Introduce el valor de A:");
			valorA = scan.nextInt();
			System.out.print("Introduce el valor de B:");
			valorB = scan.nextInt();
			System.out.print("Introduce el valor de C:");
			valorC = scan.nextInt();
			
			delta = (int) Math.pow(valorB, 2) - (4 * valorA * valorC);
			if (delta>0) {
				raiz1 = (int) ((-1 * valorB) + Math.sqrt(delta)) / (2 * valorA);
				raiz2 = (int) ((-1 * valorB) - Math.sqrt(delta)) / (2 * valorA);
				System.out.println("Las raices son: " + raiz1 + " y " + raiz2);
			}
			else if (delta<0) {
				System.out.println("No tiene raices reales");
			}
			else if (delta==0) {
				raiz1 = (int) ((-1 * valorB) + Math.sqrt(delta)) / (2 * valorA);
				raiz2 = raiz1;
				System.out.print("Las raices son coincidentes: " + raiz1 + " y " + raiz2);
			}
		}
			
		public static void Mayor3n () {
				//crea un programa que pida 3 numeros y muestre el mayor
	
			float mayor3n = 0;
				for(int i=0;i<3;i++) {
					System.out.print("Introduce el valor del numero " + i + ": ");
					vector[i] = scan.nextFloat();
					if (vector[i]>mayor3n) {
						mayor3n = vector[i];
					}
				}
				System.out.println("El numero mayor es" + mayor3n);
		}
		
		public static void Articulos () {
			
			System.out.print("Introduce el Codigo del Articulo: ");
			vector[1] = scan.nextFloat();
			System.out.print("Introduce la Cantidad: ");
			vector[2] = scan.nextFloat();
			System.out.print("Introduce el precio unitario del Articulo: ");
			vector[3] = scan.nextFloat();

			if (vector[1]>vector[2] && vector[1]>vector[3]) {
				
			}
		
	}
		
		public static void Expendedor () {
			
			
			
		}

		public static void Expendedorcambio() {
			float dinero;
			int centavos, E2, E1, C50, C20, C10, C5, C2, C1, restante;
			System.out.println("==============MAQUINA EXPENDEDORA==============");
			System.out.print("Introduce el dinero: ");
			dinero = scan.nextFloat();
			System.out.println("1. Cafe (0.43€)");
			System.out.println("2. Refresco (1.11€)");
			System.out.println("3. Agua (0.36€)");
			System.out.print("Introduce una opcion: ");
			int opcion = scan.nextInt();
			int saldo = 0;
			switch(opcion) {
			case 1:
				{	
					if (dinero>0.43) {
						//saldo = (float) (dinero - 0.43);
						//System.out.println("Dinero restante: " + saldo);
						//centavos = ((int) (saldo*100)%100);
						//7.88
						saldo = (int) ((dinero-0.43)*100); //9-0.43*100 = 857
						System.out.println("saldo: " + saldo);
						E2 =(saldo/200); // = 4.285 = 4
						System.out.println("E2: " + E2);
						saldo -= (E2*200); // 857-800 = 57
						System.out.println("saldo: " + saldo);
						E1 = (saldo/100); // 1.8 = 1   0.80
						System.out.println("E1: " + E1);
						saldo -= (E1*100); //188-100 = 88
						System.out.println("saldo: " + saldo);
						C50 =  (saldo/50); //1.76 = 1
						System.out.println("C50: " + C50);
						saldo -= 50; // 88 - 50 = 38
						System.out.println("saldo: " + saldo);
						C20 = (saldo/20); // 38/20 = 1.9 = 1
						System.out.println("C20: " + C20);
						saldo -= 20; // 38-20 = 18
						System.out.println("saldo: " + saldo);
						C10 = (saldo/10);// 18/10= 1.8
						System.out.println("C10: " + C10);
						saldo -=10; // 8
						System.out.println("saldo: " + saldo);
						C5 = (saldo/5);// 8/5=1.6 = 1
						System.out.println("C5: " + C5);
						saldo -=5; // 3
						System.out.println("saldo: " + saldo);
						C2 = (saldo/2); //3/2 =1.5 = 1
						System.out.println("C2: " + C2);
						saldo -=1;
						System.out.println("saldo: " + saldo);
						C1 = (saldo/1); // 1
						System.out.println("C1: " + C1);
						
//						System.out.println("E2: " + E2);
//						System.out.println("E1: " + E1);
//						System.out.println("C50: " + C50);
//						System.out.println("C20: " + C20);
//						System.out.println("C10: " + C10);
//						System.out.println("C5: " + C5);
//						System.out.println("C2: " + C2);
//						System.out.println("C1: " + C1);
						
						
						
						//System.out.println((int)(saldo) + "€ " + centavos + "cts");
						
								
						}
//						System.out.println("saldo " + saldo);
//						System.out.println("int saldo*100   " + (int)(saldo*100));
//						System.out.println("saldo % 100   " + (saldo*100)%100);
//						System.out.println("int saldo % 100   " + ((int) (saldo*100)%100));
					
					else {
						System.out.println("No hay suficiente dinero");
					}
				}
				System.out.println("Aqui tiene su Cafe, Gracias.");
				break;
			case 2:
				System.out.println("Aqui tiene su Refresco, Gracias.");
				break;
			case 3:
				System.out.println("Aqui tiene su Agua, Gracias.");
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
			
			
			
			
		}
		
		};
		
		