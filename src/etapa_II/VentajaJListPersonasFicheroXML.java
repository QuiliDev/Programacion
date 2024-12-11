package etapa_II;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class VentajaJListPersonasFicheroXML extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 20241127L;
	private JPanel contentPane;
	private JTextField txtDia;
	private JPanel panel;
	private JLabel lblFecha;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Persona> lstPersonas;
	private DefaultListModel<Persona> dlm;
	private JPanel panel_1;
	private JLabel lblTotalElementos;
	private JLabel lblTotalElementosValor;
	private JLabel lbl1;
	private JTextField txtMes;
	private JLabel lbl2;
	private JTextField txtAño;
	private JLabel lblDNI;
	private JTextField txtDNI;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JButton btnOrdenar;
	private JRadioButton rbtAscendente;
	private JRadioButton rbtDescendente;
	private JComboBox<String> cmbOrdenar;
	private ButtonGroup btnOrdenacion;
	public boolean DatosModificados;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListPersonas frame = new VentanaJListPersonas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentajaJListPersonasFicheroXML() {
		setTitle("VentanaJListPersonas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		setBounds(100, 100, 1420, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblDNI = new JLabel("DNI");
		panel.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setText("X");
		txtDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDNI.setColumns(10);
		panel.add(txtDNI);
		
		lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("NombreX");
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		lblApellidos = new JLabel("Apellidos");
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setText("ApellidosX");
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellidos.setColumns(10);
		panel.add(txtApellidos);
		
		lblFecha = new JLabel("Fecha Nacimiento");
		panel.add(lblFecha);
		
		txtDia = new JTextField();
		txtDia.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDia.setText("1");
		panel.add(txtDia);
		txtDia.setColumns(2);
		
		lbl1 = new JLabel("/");
		panel.add(lbl1);
		
		txtMes = new JTextField();
		txtMes.setText("1");
		txtMes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMes.setColumns(2);
		panel.add(txtMes);
		
		lbl2 = new JLabel("/");
		panel.add(lbl2);
		
		txtAño = new JTextField();
		txtAño.setText("2023");
		txtAño.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAño.setColumns(4);
		panel.add(txtAño);
		
		btnInsertar = new JButton("Insertar");
		panel.add(btnInsertar);
		btnInsertar.addActionListener(this);
		
		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		btnBorrar.addActionListener(this);
		
		btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(this);
		
		btnOrdenar = new JButton("Ordenar");
		panel.add(btnOrdenar);
		btnOrdenar.addActionListener(this);
		
		cmbOrdenar = new JComboBox<String>();
		cmbOrdenar.addItem("Seleccionar...");
		cmbOrdenar.addItem("DNI");
		cmbOrdenar.addItem("Nombre");
		cmbOrdenar.addItem("Apellidos");
		cmbOrdenar.addItem("Fecha");
		panel.add(cmbOrdenar);
		
		rbtAscendente = new JRadioButton("Ascendente");
		panel.add(rbtAscendente);
		
		rbtDescendente = new JRadioButton("Descendente");
		panel.add(rbtDescendente);
		
		//AGRUPAMOS LOS BOTONES
		btnOrdenacion = new ButtonGroup();
		btnOrdenacion.add(rbtAscendente);
		btnOrdenacion.add(rbtDescendente);
		
		// creo el modelo de datos de la lista
		dlm = new DefaultListModel<Persona>();
		
		// creo la lista
		lstPersonas = new JList<Persona>();
		// asocio el modelo de datos a la lista
		lstPersonas.setModel(dlm);
		contentPane.add(lstPersonas, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		lblTotalElementos = new JLabel("Total Elementos:");
		panel_1.add(lblTotalElementos);
		
		lblTotalElementosValor = new JLabel("0");
		lblTotalElementosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblTotalElementosValor);
		
		//DATOS DE PRUEBA
		cargarDatos();
		//DatosdePrueba();
		DatosModificados = false;
	}
	
	//METODO PARA CALCULAR EL TOTAL DE ELEMENTOS
	private void calcularTotalElementos() {
		int totalElementos = dlm.size();
		lblTotalElementosValor.setText(""+ totalElementos); // Actualiza el total

	}
	
	//METODO PARA ORDENAR LA LISTA SEGUN UNA COLUMNA
	public void ordenar() {
		String columna = (String) cmbOrdenar.getSelectedItem();
		boolean ascendente = rbtAscendente.isSelected();
		
		
		
	}
	
	public ArrayList<Persona> obtenerListaPersonas() {
	    ArrayList<Persona> lista = new ArrayList<Persona>();
	    // Llenar el ArrayList con las personas del DefaultListModel
	    for (int i = 0; i < dlm.size(); i++) {
	        lista.add(dlm.get(i));
	    }
	    return lista;
	}

	private void ordenarPersonas(String criterio, boolean ascendente) {
	    // Obtener el ArrayList de personas
	    ArrayList<Persona> listaPersonas = obtenerListaPersonas(); // Asegúrate de tener un método para obtener el ArrayList

	    // Elegir el criterio de comparación
	    switch (criterio) {
	        case "DNI":
	            // Ordenar por DNI utilizando el método compareTo
	            listaPersonas.sort((p1, p2) -> p1.compareTo(p2));
	            break;
	        case "Nombre":
	            // Ordenar por Nombre
	            listaPersonas.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
	            break;
	        case "Apellidos":
	            // Ordenar por Apellidos
	            listaPersonas.sort((p1, p2) -> p1.getApellido().compareTo(p2.getApellido()));
	            break;
	        case "Fecha":
	            // Ordenar por Fecha de Nacimiento
	            listaPersonas.sort((p1, p2) -> p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento()));
	            break;
	        default:
	            throw new IllegalArgumentException("Criterio de ordenación no válido");
	    }

	    // Si el orden es descendente, invertir el ArrayList
	    if (!ascendente) {
	        Collections.reverse(listaPersonas);
	    }

	    // Actualizar el modelo de la lista
	    actualizarModeloLista(listaPersonas);
	}

	private void actualizarModeloLista(ArrayList<Persona> personas) {
	    dlm.clear();
	    for (Persona persona : personas) {
	        dlm.addElement(persona);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botonSeleccionado = evento.getSource();
		if (botonSeleccionado == btnInsertar || 
			botonSeleccionado == txtDNI || 
			botonSeleccionado == txtNombre || 
			botonSeleccionado == txtApellidos) {
			
			//MENSAJE SI NO HAY TEXTO EN EL CAMPO
			if (txtDNI.getText().isEmpty() || 
				txtNombre.getText().isEmpty()|| 
				txtApellidos.getText().isEmpty()|| 
				txtDia.getText().isEmpty()||  
				txtMes.getText().isEmpty()|| 
				txtAño.getText().isEmpty() 
				
				) {
				JOptionPane.showMessageDialog(this, "Error al Insertar. El campo Numero no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			
			//GUARDAR LOS DATOS EN VARIABLE NUMERADOR Y DENOMINADOR
			String textoDNI = txtDNI.getText();
			String textoNombre = txtNombre.getText();
			String textoApellidos = txtApellidos.getText();
			String textoDia = txtDia.getText();
			String textoMes = txtMes.getText();
			String textoAño = txtAño.getText();
			
			//GUARDAR LOS DATOS EN VARIABLE NUMERADOR Y DENOMINADOR Y PASAR A ENTERO
			int FechaDia = Integer.parseInt(textoDia);
			int FechaMes = Integer.parseInt(textoMes);
			int FechaAño = Integer.parseInt(textoAño);
			
			//CONSTRUIR UN NUMERO RACIONAL
			Persona persona1 = new Persona(textoDNI, textoNombre, textoApellidos,
					FechaDia, FechaMes, FechaAño);

					
			//MENSAJE SI ES MENOR QUE 0
			if (FechaDia < 0 || FechaMes < 0 || FechaAño < 0) {
				JOptionPane.showMessageDialog(this, "Error al Insertar. Las Fechas no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			
			
			// VERIFICAR SI ESTA EN LA LISTA
			if (dlm.contains(persona1)) {
				JOptionPane.showMessageDialog(this, "Error al Insertar. El Número " + persona1.toString() + " ya esta en una de las listas.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
							
			}
			
			
			// SI NO SE ENCUENTRA, AGREGARLO A LA LISTA (ORDENADO ASCENDENTE DEFAULT)
			else {
				
				//METODO 2  // si quieres ascendente el numero >, descendente el numero <
				/*OTRA FORMA ES CREAR UNA VARIABLE BOOLEANA Y ANIADIR UNA CONDICION SI ES TRUE O FOLSE */
				int indice = 0;
				boolean ordenAscendente = true; //cambiar a folse si quieres descendente
				while (indice < dlm.size() && 
						((ordenAscendente && persona1.compareTo(dlm.get(indice))>0) || 
						(!ordenAscendente && persona1.compareTo(dlm.get(indice))< 0 ))) {
					indice++;
					
				} 
				
				dlm.add(indice, persona1);
				//datos modificados
				DatosModificados = true;
				//ACTUALIZAR EL TOTAL
				calcularTotalElementos();
			}
		}
		
		//BOTON BORRAR 
		else if (botonSeleccionado == btnBorrar) {
			
			//OBTENER EL ELEMENTO SELECCIONADO Y GUARDARLOS EN UNA LISTA
			
			int[] Arregloseleccionados = lstPersonas.getSelectedIndices();

			//SI NO HAY ELEMENTOS SELECICONADOS
			if (Arregloseleccionados.length == 0) {
				JOptionPane.showMessageDialog(this, "Error, no hay elementos seleccionados.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			
			//BORRAR LOS ELEMENTOS SELECCIONADOS
			for (int i = Arregloseleccionados.length -1; i>= 0; i--) {
				dlm.remove(Arregloseleccionados[i]);
		        }
			JOptionPane.showMessageDialog(this, "Elementos eliminados con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);			
			//ACTUALIZAR EL TOTAL
			calcularTotalElementos();
			//datos modificados
			DatosModificados = true;
			
		}
		else if (botonSeleccionado == btnLimpiar) {
			if (dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, "La Lista no tiene elementos por borrar", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				dlm.clear();
		        JOptionPane.showMessageDialog(this, "Lista Limpiada con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
		        
			}

			//datos modificados
			DatosModificados = true;
			//ACTUALIZAR EL TOTAL
			calcularTotalElementos();
		}
		//BOTON ORDENAR
		
		// Verificar si el criterio seleccionado es "Seleccionar..."
		else if (cmbOrdenar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un criterio de ordenamiento", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si no se ha seleccionado un criterio
        }
		
		// Verificar si no se ha seleccionado ninguno de los JRadioButton (Ascendente o Descendente)
		else if (!rbtAscendente.isSelected() && !rbtDescendente.isSelected()) {
		    JOptionPane.showMessageDialog(null, "Debe seleccionar un orden (Ascendente o Descendente)", "Error", JOptionPane.ERROR_MESSAGE);
		    return;  // Salir del método si no se ha seleccionado un orden
		}

		
        // Verificar si la lista está vacía
        else if(dlm.isEmpty()) {
	    	}
		else if (botonSeleccionado == btnOrdenar) {
		    // Obtener el criterio seleccionado en el ComboBox
		    String criterio = (String) cmbOrdenar.getSelectedItem();
		    
		    // Obtener la dirección de ordenamiento
		    boolean ascendente = rbtAscendente.isSelected();

		    // Llamar al método para ordenar la lista
		    ordenarPersonas(criterio, ascendente);
		    //No se ha seleccionado un criterio
		}
		
	}
	
	public void DatosdePrueba() {
		//txtNumero.setText(String.valueOf(valor)); por si el arreglo seria tipo int
		
	    // Valores de prueba que deseas agregar
	    String[] DNIPrueba = {"ABC1", "ABC222", "ABC3", "ABC4", "ABC5"};
	    String[] NombrePrueba = {"Pedro", "Juan", "Raul", "Marta", "Raul"};
	    String[] ApellidoPrueba = {"Perez", "Gomez", "Lopez", "Garcia", "Lopez"};
	    String[] FechaDia = {"11", "12", "13", "13", "13"};
	    String[] FechaMes = {"1", "2", "3", "4", "5"};
	    String[] FechaAño = {"2000", "2001", "2002", "2003", "2004"};
	    	
	    
	    
	    // Asegurarse de que todos los arrays tengan el mismo tamaño
	    int size = DNIPrueba.length; // Asumimos que todos los arrays tienen el mismo tamaño
	    for (int i = 0; i < size; i++) {
	        txtDNI.setText(DNIPrueba[i]);
	        txtNombre.setText(NombrePrueba[i]);
	        txtApellidos.setText(ApellidoPrueba[i]);
	        txtDia.setText(FechaDia[i]);
	        txtMes.setText(FechaMes[i]);
	    	txtAño.setText(FechaAño[i]);
	        
	        
	        btnInsertar.doClick();// Simular un clic en el botón insertar
	    }
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Método para guardar los datos (aquí solo como ejemplo)
    public void guardarDatos() {
    	
    	try {
            FileOutputStream fos = new FileOutputStream("personas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            // Obtén la lista de personas a guardar
            ArrayList<Persona> personas = obtenerListaPersonas();
            oos.writeObject(personas);  // Serializa la lista de personas
            
            oos.close();  // Cierra el ObjectOutputStream
            fos.close();  // Cierra el FileOutputStream	
            
            JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente.", 
                                          "Guardar datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            // Implementar la lógica para guardar los datos, por ejemplo, escribir a un archivo
            JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente.", 
                                          "Guardar datos", JOptionPane.INFORMATION_MESSAGE);
        }
	
	}
	
    
    public void guardarDatos2() {
    	
    	try {
            FileOutputStream fos = new FileOutputStream("personas.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            // Obtén la lista de personas a guardar
            Persona valor;
            for (int i=0; i<dlm.size(); i++) {
	            valor = dlm.get(i);
	            oos.writeObject(valor);  // Serializa la lista de personas
            }
            
            oos.close();  // Cierra el ObjectOutputStream
            fos.close();  // Cierra el FileOutputStream
            

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error, Fichero no encontrado.", 
                    "Guardar datos", JOptionPane.INFORMATION_MESSAGE);
        }
    	
    	catch (IOException e) {
            e.printStackTrace();
            // Implementar la lógica para guardar los datos, por ejemplo, escribir a un archivo
            JOptionPane.showMessageDialog(this, "Los datos se han guardado correctamente.", 
                                          "Guardar datos", JOptionPane.INFORMATION_MESSAGE);
        }
	
	}
    
    
    public void cargarDatos() {
        try {
            // Crear los flujos de entrada
            FileInputStream fis = new FileInputStream("personas.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Limpiar el modelo de lista antes de cargar nuevos datos
            dlm.clear();

            // Leer cada objeto de tipo Persona desde el archivo y agregarlo al DefaultListModel
            Persona persona;
            while (fis.available() > 0) {  // Mientras haya datos disponibles para leer
                persona = (Persona) ois.readObject();  // Leer el siguiente objeto Persona
                dlm.addElement(persona);  // Agregar la persona al modelo de lista
            }


            // Cerrar los flujos
            ois.close();
            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exportarXML() {
    	
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
    
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (DatosModificados) {
            // Muestra el cuadro de confirmación con opciones SÍ y NO
            int opcion = JOptionPane.showConfirmDialog(this, 
                "Los datos han sido modificados. ¿Desea guardar los cambios?", 
                "Confirmar salida", 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.WARNING_MESSAGE);
            
            switch (opcion) {
				case JOptionPane.YES_OPTION:
					// Si el usuario selecciona "Sí", guarda los datos
					guardarDatos2();
					System.exit(0); // Cerrar la aplicación luego de guardar
					break;
				case JOptionPane.NO_OPTION:
					// Si el usuario selecciona "No", cierra la aplicación sin guardar
					System.exit(0);
					break;
				case JOptionPane.CANCEL_OPTION:
					// Si el usuario selecciona "Cancelar", no se hace nada
				case JOptionPane.CLOSED_OPTION:
					return;
			}
            
//            if (opcion == JOptionPane.YES_OPTION) {
//                // Si el usuario selecciona "Sí", guarda los datos
//            	guardarDatos();
//                System.exit(0); // Cerrar la aplicación después de guardar
//            } else if (opcion == JOptionPane.NO_OPTION) {
//                // Si el usuario selecciona "No", cierra la aplicación sin guardar
//                System.exit(0);
//            } else if (opcion == JOptionPane.CANCEL_OPTION) {
//                // Si el usuario selecciona "No", cierra la aplicación sin guardar
//            }
//        } else {
//            // Si no hay modificaciones, cierra la aplicación sin mostrar mensaje
//            System.exit(0);
//        }
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}