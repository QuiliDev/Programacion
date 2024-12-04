package FicheroTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheroHolaHTML {

	public static void main(String[] args) {

		FileWriter fichero = null;
		BufferedWriter bw = null; // Usar BufferedWriter directamente
		try {
			fichero = new FileWriter("index.html");
			bw = new BufferedWriter(fichero); // BufferedWriter recibe FileWriter directamente
			// Escribo unas líneas
			bw.write("<!DOCTYPE html>\n"+
					"<html lang="+"es"+">\n"+
					"<head>\n"+
					"</head>\n"+
					"<body>\n"+
					  "<p>Esta página web es una página HTML válida.</p>\n"+
					"</body>\n"+
					"</html>\n");
			
			
			bw.close(); // Cerrar el BufferedWriter
			fichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
	}
}
