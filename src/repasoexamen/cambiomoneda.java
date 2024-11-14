package repasoexamen;
import java.util.Scanner;
public class cambiomoneda {
	public static float dinero ,vuelto, verificador, vueltoperador, cafe= (float)0.43, refresco= (float)1.11, agua = (float)0.36;
	public static int opcion;
	public static int[] nominacion = {200, 100, 50, 20, 10, 5, 2, 1};
	public static int[] guardarcambio = {0, 0, 0, 0, 0, 0, 0, 0};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("======= MAQUINA EXPENDEDORA =======");
		System.out.print("Ingresa tu dinero: ");
		dinero = scan .nextFloat();
		System.out.println("1. Cafe (0.43€)");
		System.out.println("2. Refresco(1.11€)");
		System.out.println("3. Agua (0.36€)");
		System.out.print("Selecciona una opcion: ");
		opcion = scan.nextInt();
		switch (opcion) {
		case 1: { Algoritmomoneda(cafe);}	break;
		case 2: { Algoritmomoneda(refresco);}	break;
		case 3: { Algoritmomoneda(agua);}	break;
		default: System.out.println("La opcion introducida no es valida: "); break;
		}
	}
	public static void Algoritmomoneda(float producto) {
		vuelto = ((dinero - producto)*100);System.out.println(vuelto/100);
		for (int i = 0; i <8; i++) {
			verificador = nominacion[i];
			vueltoperador = vuelto / verificador;
			if (vueltoperador>=1) {
				guardarcambio[i] = (int) vueltoperador;
			}
			else {
				guardarcambio[i] = 0;
			}
			vuelto = (vuelto - ((int)vueltoperador * nominacion[i]));
		}
		for (int i = 0; i<8; i++){//
			if (i<=1 && guardarcambio[i] >= 1) {
				System.out.printf(guardarcambio[i] +"x"+ (nominacion[i]/100)+ "€ ");
			}
			else if (guardarcambio[i] >=1){
				System.out.print((guardarcambio[i]*nominacion[i]) + "cts ");
			}
		}
	}
}

// codigo sucio

/**
package miprograma;
import java.util.Scanner;
public class deprueba {
	public static float dinero ,vuelto, verificador, vueltoperador;
	public static float cafe= (float)0.43, refresco= (float)1.11, agua = (float)0.36;
	public static int opcion;
	public static int[] nominacion = {200, 100, 50, 20, 10, 5, 2, 1};
	public static int[] guardarcambio = {0, 0, 0, 0, 0, 0, 0, 0};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("======= MAQUINA EXPENDEDORA =======");
		System.out.print("Ingresa tu dinero: ");
		dinero = scan .nextFloat();
		System.out.println("1. Cafe (0.43€)");
		System.out.println("2. Refresco(1.11€)");
		System.out.println("3. Agua (0.36€)");
		System.out.print("Selecciona una opcion: ");
		opcion = scan.nextInt();
		switch (opcion) {
		case 1: { Algoritmomoneda(cafe);}	break;
		case 2: { Algoritmomoneda(refresco);}	break;
		case 3: { Algoritmomoneda(agua);}	break;
		default: System.out.println("La opcion introducida no es valida: "); break;
		}
	}
	public static void Algoritmomoneda(float producto) {
		System.out.println(dinero);
		System.out.println(producto);
		vuelto = ((dinero - producto)*100);System.out.println(vuelto);
		for (int i = 0; i <8; i++) {
			verificador = nominacion[i];//System.out.println("Loop " + i+" verificador: "+verificador);
			vueltoperador = vuelto / verificador;
			//System.out.println("vueltoperador: "+vuelto+"/"+verificador+"="+vueltoperador);
			//System.out.println("Loop " + i+" vueltoperador: "+vueltoperador);
			if (vueltoperador>=1) {
				guardarcambio[i] = (int) vueltoperador;//System.out.print(guardarcambio[i] + "€ ");
			}
			else {
				guardarcambio[i] = 0;//System.out.println(guardarcambio[i]);
			}//System.out.print("vuelto=("+vuelto+"-("+(int)vueltoperador+"*"+nominacion[i]+")=");
			vuelto = (vuelto - ((int)vueltoperador * nominacion[i]));//System.out.println(vuelto);
			//System.out.println(vuelto);System.out.println("nominacion["+i+"]:"+nominacion[i]+" = "+guardarcambio[i]+"€ ");
		}
		for (int i = 0; i<8; i++){//
			if (i<=1 && guardarcambio[i] >= 1) {
				System.out.printf(guardarcambio[i] +"x"+ (nominacion[i]/100)+ "€ ");
			}
			else if (guardarcambio[i] >=1){
				System.out.print((guardarcambio[i]*nominacion[i]) + "cts ");
			}
		}
	}
}
 
 
 */
