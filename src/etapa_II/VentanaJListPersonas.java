package etapa_II;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
		setBounds(100, 100, 1032, 221);
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
		
		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);
		
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
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botonSeleccionado = evento.getSource();
		if (botonSeleccionado == btnInsertar || 
			botonSeleccionado == txtDNI || 
			botonSeleccionado == txtNombre || 
			botonSeleccionado == txtApellidos) {
			
			//MENSAJE SI NO HAY TEXTO EN EL CAMPO
			if (txtDNI.getText().isEmpty() || txtNombre.getText().isEmpty()|| txtApellidos.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Error al Insertar. El campo Numero no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			
			//GUARDAR LOS DATOS EN VARIABLE NUMERADOR Y DENOMINADOR
			String textonumerador = txtNumerador.getText();
			String textodenominador = txtDenominador.getText();
			//GUARDAR LOS DATOS EN VARIABLE NUMERADOR Y DENOMINADOR Y PASAR A ENTERO
			int numerador = Integer.parseInt(textonumerador);
			int denominador = Integer.parseInt(textodenominador);
			//CONSTRUIR UN NUMERO RACIONAL
			Racional r1 = new Racional(numerador, denominador);

					
			//MENSAJE SI ES MENOR QUE 0
			if (numerador < 0 || denominador < 0) {
				JOptionPane.showMessageDialog(this, "Error al Insertar. El numero no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			
			
			// VERIFICAR SI ESTA EN LA LISTA
			if (dlm.contains(r1)) {
				JOptionPane.showMessageDialog(this, "Error al Insertar. El Número " + r1.toString() + " ya esta en una de las listas.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
							
			}
			
			// SI NO SE ENCUENTRA, AGREGARLO A LA LISTA (descendente)
			else {
				int indice = 0;
				int numeroElementos = dlm.size();
				while (indice < numeroElementos) {
					Racional numeroLista = dlm.get(indice);
					if (r1.compareTo(numeroLista) < 0) {
						indice++;
					} else {break;}
				}
				dlm.add(indice, r1);
			}	
			lblTotalElementosValor.setText(String.valueOf(calcularTotalElementos()));
			lblTotalSumaValor.setText(calcularTotalSuma().toString());
		}
		
		//BOTON BORRAR 
		else if (botonSeleccionado == btnBorrar) {
			
			//OBTENER EL ELEMENTO SELECCIONADO Y GUARDARLOS EN UNA LISTA
			int[] Arregloseleccionados = lstNumeros.getSelectedIndices();

			//SI NO HAY ELEMENTOS SELECICONADOS
			if (Arregloseleccionados.length == 0) {
				JOptionPane.showMessageDialog(this, "Error, no hay elementos seleccionados.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			//BORRAR LOS ELEMENTOS SELECCIONADOS
			for (int i = Arregloseleccionados.length -1; i>= 0; i--) {
				dlm.remove(Arregloseleccionados[i]);
		        JOptionPane.showMessageDialog(this, "Elementos eliminados con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);			
			}

		}
		else if (botonSeleccionado == btnLimpiar) {
			if (dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, "La Lista no tiene elementos por borrar", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				dlm.clear();
		        JOptionPane.showMessageDialog(this, "Lista Limpiada con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
		        
			}
			
		}
		
	}

}