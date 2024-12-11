package FicheroBinario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroCopia {

	public static void main(String[] args) {
		//ABRO LOGO.PNG EN MODO LECTURA
		FileOutputStream fos;
		BufferedOutputStream bos;
		try {
			
			fos = new FileOutputStream("logo.png");
			bos = new BufferedOutputStream(fos);
			//SI ABRO LOGO.PNG EN MODO LECTURA
			// ABRO/CREO LOGOCOPOIA.PNG EN MODO ESCRITURA
			FileInputStream fis = new FileInputStream("logocopia.png");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			byte [] datos = new byte[512];
			int bytesLeidos = bis.read(datos);
            // Leer y escribir en bloques de 512 bytes
            while ((bytesLeidos) != -1) {
                // Si leemos algo, escribimos esos datos en el archivo de destino
                bos.write(datos, 0, bytesLeidos);
                
                // Leo el siguiente bloque de logo.png
                bytesLeidos = bis.read(datos);
                
            }
			//libero recuersos
			bis.close();
			fis.close();
			bos.close();
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Error, El fichero no existe.");
		} catch (IOException e) {
			System.out.println("Error, 	El fichero no existe.");
		}
	}

}
