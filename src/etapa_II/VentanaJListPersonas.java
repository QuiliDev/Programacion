package etapa_II;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class VentanaJListPersonas extends JFrame implements ActionListener{

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
	public VentanaJListPersonas() {
		setTitle("VentanaJListPersonas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		DatosdePrueba();
		
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
			
		}
		else if (botonSeleccionado == btnLimpiar) {
			if (dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, "La Lista no tiene elementos por borrar", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				dlm.clear();
		        JOptionPane.showMessageDialog(this, "Lista Limpiada con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
		        
			}
			
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
	    	JOptionPane.showMessageDialog(this, "La Lista no tiene elementos por ordenar", "Error", JOptionPane.ERROR_MESSAGE);	 
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
}