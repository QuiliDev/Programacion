package repasoexamen;

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


public class VentanaJListNumero extends JFrame implements ActionListener {

	private static final long serialVersionUID = 20241112L;
	private JPanel contentPane;
	private JTextField txtNumero;
	JPanel panel;
	JLabel lblNumero;
	JButton btnInsertar;
	JButton btnBorrar;
	JButton btnLimpiar;
	JList<Integer> lstNumeros;
	DefaultListModel<Integer> dlm;
	private JPanel panel_1;
	private JList list;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListNumero frame = new VentanaJListNumero();
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
	public VentanaJListNumero() {
		setTitle("VentanaJListNumeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNumero = new JLabel("Número");
		panel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setText("0");
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		txtNumero.addActionListener(this);
		
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
		dlm = new DefaultListModel<Integer>();
		
		// creo la lista
		lstNumeros = new JList<Integer>();
		// asocio el modelo de datos a la lista
		lstNumeros.setModel(dlm);
		contentPane.add(lstNumeros, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		list = new JList();
		panel_1.add(list);
		//DatosdePrueba();
	}
	public void DatosdePrueba() {
		dlm.addElement(1);
		dlm.addElement(5);
		dlm.addElement(9);
		dlm.addElement(10);
		
	}
	@Override
	public void actionPerformed(ActionEvent evento) {
		Object botonseleccionado = evento.getSource();
		if (botonseleccionado == btnInsertar || botonseleccionado == txtNumero) {

			
			//MENSAJE SI NO HAY TEXTO EN EL CAMPO
			if (txtNumero.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "No se ha introducido ningun numero", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
			}
			
			String texto = txtNumero.getText();
			int numero = Integer.parseInt(texto);
			
			//MENSAJE SI ES MENOR QUE 0
			if (numero < 0) {
				JOptionPane.showMessageDialog(this, "El numero no puede ser menor a 0", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
				
			}

		
			// VERIFICAR SI ESTA EN LA LISTA
			if (dlm.contains(numero)) {
				JOptionPane.showMessageDialog(this, "Error, el numero 	" + numero + " ya ha sido introducido", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
				
			}
			
			//INSERTAR DE MANERA ORDENADA
			//LOGICA PARA BUSCAR LA POSICION CORRESPONDIENTE PARA EL NUMERO
			//METODO 1
//			int indice = 0;
//			int numeroElementos = dlm.size();
//			while (indice < numeroElementos) {
//				int numeroLista = dlm.get(indice);
//				if (numero > numeroLista) {
//					indice++;
//				}
//				else {break;}
//				
//			}
//			dlm.add(indice,numero);
			
			//METODO 2  // si quieres ascendente el numero >, descendente el numero <
			/*OTRA FORMA ES CREAR UNA VARIABLE BOOLEANA Y ANIADIR UNA CONDICION SI ES TRUE O FOLSE */
			int indice = 0;
			boolean ordenAscendente = true; //cambiar a folse si quieres descendente
			while (indice < dlm.size() && 
					((ordenAscendente && numero > dlm.get(indice)) || 
					(!ordenAscendente && numero < dlm.get(indice)))) {
				indice++;
				
			} 
			//INGRESAR NUMERO
			this.dlm.add(indice, numero);
		}
		
		
		/*-----------BOTON BORRAR---------*/
		else if (botonseleccionado == btnBorrar) {
			// Obtener los índices de los elementos seleccionados en la lista
	        int[] ArregloSeleccionados = lstNumeros.getSelectedIndices();
	        
	        //SI NO HAY ELEMENTOS SELECCIONADOS
	        if (ArregloSeleccionados.length == 0) {
	        	JOptionPane.showMessageDialog(this, "Error, no hay elementos seleccionados.", "Error", JOptionPane.ERROR_MESSAGE);
				return;//salir del bloque
	        }
//	        //COMPROBRAR POR CONSOLA LOS ELEMENTOS SELECCIONADOS POR SU INDICE
//			for (int i = 0; i < ArregloSeleccionados.length; i++) {
//				System.out.println(ArregloSeleccionados[i]);
//			}

	        //BORRAR LOS ELEMENTOS SELECCIONADOS (SE BORRAN DE MAYOR A MENOR INDICE)
	        for (int i = ArregloSeleccionados.length - 1; i >= 0; i--) {
	        	dlm.remove(ArregloSeleccionados[i]);
	        }
	        JOptionPane.showMessageDialog(this, "Elementos eliminados con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
	        }
		
		else if (botonseleccionado == btnLimpiar) {
			if (dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, "La Lista no tiene elementos por borrar", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				dlm.clear();
		        JOptionPane.showMessageDialog(this, "Lista Limpiada con exito", "Información", JOptionPane.INFORMATION_MESSAGE);
		        
			}
		}
		
	}

	
}
/*		Object botonseleccionado = evento.getSource();
		if(botonseleccionado == btnInsertar) {
			int num = Integer.parseInt(txtNumero.getText());
			dlm.addElement(num);
		}else if(botonseleccionado == btnBorrar) {
			int num = Integer.parseInt(txtNumero.getText());
			dlm.removeElement(num);
		}else if(botonseleccionado == btnLimpiar) {
			dlm.clear();
		}*/