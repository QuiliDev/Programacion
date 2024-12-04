package FicheroTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheroTextoBufferLectura {

	public static void main(String[] args) {

		FileWriter fichero = null;
		BufferedWriter bw = null; // Usar BufferedWriter directamente
		try {
			fichero = new FileWriter("prueba.txt");
			bw = new BufferedWriter(fichero); // BufferedWriter recibe FileWriter directamente
			// Escribo unas líneas
			bw.write("Hola Mundo1.\n");
			bw.write("Hola Mundo2.");
			bw.newLine();
			bw.write("Hola Mundo3.\n");
			bw.close(); // Cerrar el BufferedWriter
			fichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
