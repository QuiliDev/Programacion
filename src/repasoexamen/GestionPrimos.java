package repasoexamen;

// Importación de clases necesarias para la interfaz gráfica y eventos
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Clase principal que extiende JFrame e implementa ActionListener para manejar eventos de los botones
public class GestionPrimos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 20231122L; 	// Versión de la clase serializable
	private JPanel contentPane;		 // Panel principal de contenido
	private JTextField txtNumero; 	// Campo de texto para ingresar el número
	private JLabel lblTotalNumeros; 	// Etiqueta que muestra la suma total de los números
	private JLabel lblMediaValor;	 //Etiqueta que muestra la media de los valores
	private DefaultListModel<Integer> dlmPrimos; 	// Modelo de lista para números primos
	private DefaultListModel<Integer> dlmNoPrimos;	 // Modelo de lista para números no primos
	private JList<Integer> lstPrimos; 	//Lista visual para mostrar números primos
	private JList<Integer> lstNoPrimos; 	// Lista visual para mostrar números no primos

	// Método principal para iniciar la aplicación en la cola de eventos
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				GestionPrimos frame = new GestionPrimos();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// Constructor que configura la interfaz gráfica de la ventana
	public GestionPrimos() {
		setTitle("Examen1 - Alain Luque"); // Título de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierre de la ventana al salir
		setBounds(100, 100, 500, 344); // Posición y tamaño de la ventana
		contentPane = new JPanel(); // Creación del panel principal
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Márgenes
		setContentPane(contentPane); // Establecer el panel como contenido de la ventana
		contentPane.setLayout(new BorderLayout(0, 0)); // Diseño de la ventana
		contentPane.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Cuando se hace clic en otra parte, quitar el foco y deseleccionar el texto
		        txtNumero.setFocusable(false); // Para evitar que se mantenga el foco en el campo
		        txtNumero.setFocusable(true); // Volver a permitir el foco
		    }
		});

		// Panel superior para la entrada de número y botones
		JPanel panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);

		JLabel lblNumero = new JLabel("Número"); // Etiqueta para el número
		panelCabecera.add(lblNumero);

		txtNumero = new JTextField("0", 10); // Campo de texto para el número
		txtNumero.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        txtNumero.requestFocus();  // Establecer el foco en el campo de texto
		        txtNumero.selectAll();     // Seleccionar todo el texto
		    }
		});
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCabecera.add(txtNumero);

		// Botones de acción
		JButton btnInsertar = new JButton("Insertar"); // Botón para insertar el número
		btnInsertar.addActionListener(this);
		panelCabecera.add(btnInsertar);

		JButton btnBorrar = new JButton("Borrar"); // Botón para borrar el número seleccionado
		btnBorrar.addActionListener(this);
		panelCabecera.add(btnBorrar);

		JButton btnLimpiar = new JButton("Limpiar"); // Botón para limpiar todas las listas
		btnLimpiar.addActionListener(this);
		panelCabecera.add(btnLimpiar);

		// Panel central que contiene listas de números primos y no primos
		JPanel panelCentral = new JPanel(new BorderLayout());
		contentPane.add(panelCentral, BorderLayout.CENTER);

		// Panel para lista de números primos
		JPanel panelPrimos = new JPanel(new BorderLayout());
		panelPrimos.setPreferredSize(new Dimension(150, 200)); // Tamaño preferido para el panel de primos
		panelPrimos.add(new JLabel("Números Primos", SwingConstants.CENTER), BorderLayout.NORTH);
		dlmPrimos = new DefaultListModel<>(); // Modelo para lista de primos
		lstPrimos = new JList<>(dlmPrimos);
		panelPrimos.add(new JScrollPane(lstPrimos), BorderLayout.CENTER);
		panelCentral.add(panelPrimos, BorderLayout.WEST);

		// Panel para lista de números no primos
		JPanel panelNoPrimos = new JPanel(new BorderLayout());
		panelNoPrimos.setPreferredSize(new Dimension(150, 200)); // Tamaño preferido para el panel de no primos
		panelNoPrimos.add(new JLabel("Números No Primos", SwingConstants.CENTER), BorderLayout.NORTH);
		
		// Modelo para lista de no primos
		dlmNoPrimos = new DefaultListModel<>(); 
		lstNoPrimos = new JList<>(dlmNoPrimos);
		panelNoPrimos.add(new JScrollPane(lstNoPrimos), BorderLayout.CENTER);
		panelCentral.add(panelNoPrimos, BorderLayout.EAST);

		// Panel inferior que muestra información sobre la suma y media de los números
		JPanel panelPie = new JPanel();
		contentPane.add(panelPie, BorderLayout.SOUTH);

		lblTotalNumeros = new JLabel("Total Números: 0"); // Muestra el total de los números
		panelPie.add(lblTotalNumeros);

		lblMediaValor = new JLabel("Media Valor: 0"); // Muestra la media de los valores
		panelPie.add(lblMediaValor);
	}

	// Método para verificar si un número es primo
	private boolean esPrimo(int numero) {
		if (numero < 2) return false; // Números menores a 2 no son primos
		for (int i = 2; i <= Math.sqrt(numero); i++) { // Verificación hasta raíz cuadrada
			if (numero % i == 0) return false; // Si es divisible, no es primo
		}
		return true; // Es primo si no es divisible
	}

	// Método para calcular el total de los números en ambas listas
	private int calcularTotalNumeros() {
	    int total = dlmPrimos.size() + dlmNoPrimos.size(); // Suma las cantidades de elementos en ambas listas
	    return total; // Retorna el total de elementos
	}

	// Método para calcular la media de los números en ambas listas
	private double calcularMediaNumeros() {
	    int totalElementos = dlmPrimos.size() + dlmNoPrimos.size(); // Número total de elementos en ambas listas

	    if (totalElementos == 0) return 0; // Evita división por cero si no hay elementos

	    int sumaTotal = 0;

	    // Sumar los valores en la lista de primos
	    for (int i = 0; i < dlmPrimos.size(); i++) {
	        sumaTotal += dlmPrimos.get(i);
	    }

	    // Sumar los valores en la lista de no primos
	    for (int i = 0; i < dlmNoPrimos.size(); i++) {
	        sumaTotal += dlmNoPrimos.get(i);
	    }

	    return (double) sumaTotal / totalElementos; // Calcula y retorna la media
	}

	// Método de respuesta a eventos de los botones
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o instanceof JButton) {
			JButton boton = (JButton) o;
			
			if (boton.getText().equals("Insertar")) {
			    // SI EL CAMPO ESTA VACIO
				 if (txtNumero.getText().trim().isEmpty()) {
				        JOptionPane.showMessageDialog(this, "No se ha introducido ningún número.", "Error", JOptionPane.ERROR_MESSAGE);
				        return; // Salir del bloque de inserción
				    }
			    int numero = Integer.parseInt(txtNumero.getText());

			    // SI YA SE HA INTRODUCIDO UN NUMERO
			    if (dlmPrimos.contains(numero) || dlmNoPrimos.contains(numero)) {
			        JOptionPane.showMessageDialog(this, "Error, ese número ya ha sido introducido", "Error", JOptionPane.ERROR_MESSAGE);
			        return; // Salir del bloque de inserción
			    }

			    // Insertar número en la lista correspondiente
			    if (esPrimo(numero)) {
			        // INSERTA EN LA LISTA DE PRIMOS EN ORDEN DESCENDENTE 
			        int i = 0;
			        // Buscar la posición donde el número es mayor que los números existentes
			        while (i < dlmPrimos.size() && dlmPrimos.get(i) > numero) {
			            i++;
			        }
			        dlmPrimos.add(i, numero); // Inserta el número en la posición correcta
			    } else {
			        // INSERTA EN LA LISTA DE NO PRIMOS EN ORDEN ASCENDENTE 
			        int i = 0;
			        // Buscar la posición donde el número es menor que los números existentes
			        while (i < dlmNoPrimos.size() && dlmNoPrimos.get(i) < numero) {
			            i++;
			        }
			        dlmNoPrimos.add(i, numero); // Inserta el número en la posición correcta
			    }

			    lblTotalNumeros.setText("Total Números: " + calcularTotalNumeros()); // Actualiza el total
			    lblMediaValor.setText("Media Valor: " + calcularMediaNumeros()); // Actualiza la media
			

			} else if (boton.getText().equals("Borrar")) {
	            // Eliminar el elemento seleccionado en ambas listas, si están seleccionados
	            int indexPrimos = lstPrimos.getSelectedIndex();
	            int indexNoPrimos = lstNoPrimos.getSelectedIndex();

	            // Esta variable servirá para saber si se ha borrado al menos un elemento.
	            boolean elementoBorrado = false;

	            if (indexPrimos != -1) { // Si hay un número seleccionado en la lista de primos
	                dlmPrimos.remove(indexPrimos);
	                elementoBorrado = true;
	            }
	            if (indexNoPrimos != -1) { // Si hay un número seleccionado en la lista de no primos
	                dlmNoPrimos.remove(indexNoPrimos);
	                elementoBorrado = true;
	            }

	            // SI NO HAY NADA PA BORRAR
	            if (!elementoBorrado) {
	                JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
	            }

				lblTotalNumeros.setText("Total Números: " + calcularTotalNumeros()); // Actualiza el total
				lblMediaValor.setText("Media Valor: " + calcularMediaNumeros()); // Actualiza la media
				
				

			} else if (boton.getText().equals("Limpiar")) {
				
			    // SI ESTA VACIA LA LISTA Y NO HAY NADA PARA LIMPIAR
			    if (dlmPrimos.isEmpty() && dlmNoPrimos.isEmpty()) {
			        JOptionPane.showMessageDialog(this, "No hay nada que limpiar.", "Error", JOptionPane.ERROR_MESSAGE);
			    } else {
			        // Limpia ambas listas y restablece las etiquetas de total y media
			        dlmPrimos.clear();
			        dlmNoPrimos.clear();	
			        txtNumero.setText("0");
			        lblTotalNumeros.setText("Total Números: 0");
			        lblMediaValor.setText("Media Valor: 0");
			    }
		}
	}
}} 