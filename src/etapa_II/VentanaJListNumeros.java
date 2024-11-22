package etapa_II;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;


public class VentanaJListNumeros extends JFrame implements ActionListener {

	private static final long serialVersionUID = 20241112L;
	private JPanel contentPane;
	private JTextField txtNumerador;
	JPanel panel;
	JLabel lblNumero;
	JButton btnInsertar;
	JButton btnBorrar;
	JButton btnLimpiar;
	JList<Racional> lstNumeros;
	DefaultListModel<Racional> dlm;
	private JLabel lblDenominador;
	private JTextField txtDenominador;
	private JPanel panelInferior;
	private JLabel lblTotalElementosValor;
	private JLabel lblTotalElementos;
	private JLabel lblSumaTotal;
	private JLabel lblTotalSumaValor;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListNumeros frame = new VentanaJListNumeros();
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
	public VentanaJListNumeros() {
		setTitle("VentanaJListNumeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNumero = new JLabel("Numerador");
		panel.add(lblNumero);
		
		txtNumerador = new JTextField();
		txtNumerador.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumerador.setText("0");
		panel.add(txtNumerador);
		txtNumerador.setColumns(4);
		txtNumerador.addActionListener(this);
		
		lblDenominador = new JLabel("Denominador");
		panel.add(lblDenominador);
		
		txtDenominador = new JTextField();
		txtDenominador.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDenominador.setText("0");
		panel.add(txtDenominador);
		txtDenominador.setColumns(4);
		txtDenominador.addActionListener(this);
		
		btnInsertar = new JButton("Insertar");
		panel.add(btnInsertar);
		btnInsertar.addActionListener(this);
		
		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		btnBorrar.addActionListener(this);
		
		btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);
		btnLimpiar.addActionListener(this);
		
		// creo el modelo de datos de la lista
		dlm = new DefaultListModel<Racional>();
		
		// creo la lista
		lstNumeros = new JList<Racional>();
		// asocio el modelo de datos a la lista
		lstNumeros.setModel(dlm);
		contentPane.add(lstNumeros, BorderLayout.CENTER);
		
		panelInferior = new JPanel();
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		
		lblTotalElementos = new JLabel("Total Elementos: ");
		panelInferior.add(lblTotalElementos);
		
		lblTotalElementosValor = new JLabel("0");
		lblTotalElementosValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelInferior.add(lblTotalElementosValor);
		
		lblSumaTotal = new JLabel("Suma Total: ");
		panelInferior.add(lblSumaTotal);
		
		lblTotalSumaValor = new JLabel("0.0");
		lblTotalSumaValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelInferior.add(lblTotalSumaValor);
	}
	//METODO PARA CALCULAR EL TOTAL DE ELEMENTOS
	public int calcularTotalElementos() {
		int totalElementos = dlm.size();
		return totalElementos;
		
	}
	
	//METODO PARA CALCULAR LA SUMA TOTAL
	public Racional calcularTotalSuma() {
		//CREAR UN OBJETO RACIONAL PARA SUMAR TODOS LOS RACIONALES
		Racional SumaTotal = new Racional(0,1);
		
		
	    for (int i = 0; i < dlm.size(); i++) {
	        Racional numeroActual = dlm.get(i);
	        // Sumar el número actual al acumulador usando el método sumar
	        SumaTotal = SumaTotal.sumar(numeroActual);
	    }
		
		return SumaTotal;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botonSeleccionado = evento.getSource();
		if (botonSeleccionado == btnInsertar || 
			botonSeleccionado == txtNumerador || 
			botonSeleccionado == txtDenominador) {
			
			//MENSAJE SI NO HAY TEXTO EN EL CAMPO
			if (txtNumerador.getText().isEmpty() || txtDenominador.getText().isEmpty()) {
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










//List<Racional> elementosSeleccionados = lstNumeros.getSelectedValuesList();
////BORRAR LOS ELEMENTOS SELECCIONADOS
//for (Racional r : elementosSeleccionados) {
//	dlm.removeElement(r);
//}