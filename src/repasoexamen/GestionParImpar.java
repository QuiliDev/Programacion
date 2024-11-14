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
public class GestionParImpar extends JFrame implements ActionListener {

    private static final long serialVersionUID = 20231122L; // Versión de la clase serializable
    private JPanel contentPane; // Panel principal de contenido
    private JTextField txtNumero; // Campo de texto para ingresar el número
    private JLabel lblTotalNumeros; // Etiqueta que muestra la suma total de los números
    private JLabel lblMediaValor; // Etiqueta que muestra la media de los valores
    private DefaultListModel<Integer> dlmPares; // Modelo de lista para números pares
    private DefaultListModel<Integer> dlmImpares; // Modelo de lista para números impares
    private JList<Integer> lstPares; // Lista visual para mostrar números pares
    private JList<Integer> lstImpares; // Lista visual para mostrar números impares

    // Método principal para iniciar la aplicación en la cola de eventos
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GestionParImpar frame = new GestionParImpar();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor que configura la interfaz gráfica de la ventana
    public GestionParImpar() {
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
        		 txtNumero.requestFocus();  // FOCO EN EL CAMPO DE TEXTO
 		        txtNumero.selectAll();  // Seleccionar todo el texto
 		        //txtEquipoNombre1.setText(""); PARA QUE DESAPAREZCA AL HACER CLICK
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

        // Panel central que contiene listas de números pares e impares
        JPanel panelCentral = new JPanel(new BorderLayout());
        contentPane.add(panelCentral, BorderLayout.CENTER);

        // Panel para lista de números pares
        JPanel panelPares = new JPanel(new BorderLayout());
        panelPares.setPreferredSize(new Dimension(150, 200)); // Tamaño preferido para el panel de pares
        panelPares.add(new JLabel("Números Pares", SwingConstants.CENTER), BorderLayout.NORTH);
        dlmPares = new DefaultListModel<>(); // Modelo para lista de pares
        lstPares = new JList<>(dlmPares);
        panelPares.add(new JScrollPane(lstPares), BorderLayout.CENTER);
        panelCentral.add(panelPares, BorderLayout.WEST);

        // Panel para lista de números impares
        JPanel panelImpares = new JPanel(new BorderLayout());
        panelImpares.setPreferredSize(new Dimension(150, 200)); // Tamaño preferido para el panel de impares
        panelImpares.add(new JLabel("Números Impares", SwingConstants.CENTER), BorderLayout.NORTH);
        dlmImpares = new DefaultListModel<>(); // Modelo para lista de impares
        lstImpares = new JList<>(dlmImpares);
        panelImpares.add(new JScrollPane(lstImpares), BorderLayout.CENTER);
        panelCentral.add(panelImpares, BorderLayout.EAST);

        // Panel inferior que muestra información sobre la suma y media de los números
        JPanel panelPie = new JPanel();
        contentPane.add(panelPie, BorderLayout.SOUTH);

        lblTotalNumeros = new JLabel("Total Números: 0"); // Muestra el total de los números
        panelPie.add(lblTotalNumeros);

        lblMediaValor = new JLabel("Media Valor: 0"); // Muestra la media de los valores
        panelPie.add(lblMediaValor);
        
        //SI BOTON INSERTAR NO VA, METER DATOS A MANO
        
        //int[] valoresPares = {2, 4, 6, 8}; // Valores por defecto para números pares
        //int[] valoresImpares = {1, 3, 5, 7}; // Valores por defecto para números impares

        //for (int par : valoresPares) {
            //dlmPares.addElement(par);
        //}

        //for (int impar : valoresImpares) {
            //dlmImpares.addElement(impar);
        //}
    }

    // Método para verificar si un número es par
    private boolean esPar(int numero) {
        return numero % 2 == 0; // Devuelve true si el número es par
    }

    // Método para calcular el total de los números en ambas listas
    private int calcularTotalNumeros() {
    	int total = dlmPares.size() + dlmImpares.size(); // Suma las cantidades de elementos en ambas listas
	    return total; // Retorna el total de elementos
	}

    // Método para calcular la media de los números en ambas listas
    private double calcularMediaNumeros() {
    	int totalElementos = dlmPares.size() + dlmImpares.size(); // Número total de elementos en ambas listas

	    if (totalElementos == 0) return 0; // Evita división por cero si no hay elementos

	    int sumaTotal = 0;

	    // Sumar los valores en la lista de pares
	    for (int i = 0; i < dlmPares.size(); i++) {
	        sumaTotal += dlmPares.get(i);
	    }

	    // Sumar los valores en la lista de impares
	    for (int i = 0; i < dlmImpares.size(); i++) {
	        sumaTotal += dlmImpares.get(i);
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
            	
            	
                // Insertar número en la lista correspondiente
              
                
                if (txtNumero.getText().trim().isEmpty()) {
			        JOptionPane.showMessageDialog(this, "No se ha introducido ningún número.", "Error", JOptionPane.ERROR_MESSAGE);
			        return; // Salir del bloque de inserción si está vacío
			    }
                
                int numero = Integer.parseInt(txtNumero.getText());
                
                //SI EL NUMERO YA ESTA EN LA LISTA
			    if (dlmPares.contains(numero) || dlmImpares.contains(numero)) {
			        JOptionPane.showMessageDialog(this, "Error, ese número ya ha sido introducido", "Error", JOptionPane.ERROR_MESSAGE);
			        return; // Salir del bloque de inserción
			    }
			    
			    // INSERTAR NUMERO EN LISTA PAR
                if (esPar(numero)) {
                // Insertar en la lista de primos en orden descendente
			    	
			        int i = 0;
			        // Buscar la posición donde el número es mayor que los números existentes
			        while (i < dlmPares.size() && dlmPares.get(i) > numero) {
			            i++;
			        }
			        dlmPares.add(i, numero); // Inserta el número en la posición correcta
			        
			        //INSERTA NUMERO EN LISTA impar
                } else {
                	int i = 0;
			        // Buscar la posición donde el número es menor que los números existentes
			        while (i < dlmImpares.size() && dlmImpares.get(i) < numero) {
			            i++;
			        }
			        dlmImpares.add(i, numero); // Inserta el número en la posición correcta
                }
                lblTotalNumeros.setText("Total Números: " + calcularTotalNumeros()); // Actualiza el total
                lblMediaValor.setText("Media Valor: " + calcularMediaNumeros()); // Actualiza la media

            } else if (boton.getText().equals("Borrar")) {
                // Eliminar el elemento seleccionado en cualquiera de las dos listas
                int indexPares = lstPares.getSelectedIndex();
                int indexImpares = lstImpares.getSelectedIndex();
                
                // Esta variable servirá para saber si se ha borrado al menos un elemento.
                boolean elementoBorrado = false;

                if (indexPares != -1) { // Si hay un número seleccionado en la lista de pares
                    dlmPares.remove(indexPares); // Elimina el número seleccionado
                    elementoBorrado = true;
                    
                } if (indexImpares != -1) { // Si hay un número seleccionado en la lista de impares
                    dlmImpares.remove(indexImpares); // Elimina el número seleccionado
                    elementoBorrado = true;
                }
                
                //SI NO HAY NADA PA BORRAR 
                if (!elementoBorrado) {
	                JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
	            }

                // Actualiza las etiquetas de total y media
                lblTotalNumeros.setText("Total Números: " + calcularTotalNumeros());
                lblMediaValor.setText("Media Valor: " + calcularMediaNumeros());

            } else if (boton.getText().equals("Limpiar")) {
            	
            	 if (dlmPares.isEmpty() && dlmImpares.isEmpty()) {
 			        JOptionPane.showMessageDialog(this, "No hay nada que limpiar.", "Error", JOptionPane.ERROR_MESSAGE);
            	 }
            	 
            	 else {
                // Limpia ambas listas y restablece las etiquetas de total y media
                dlmPares.clear();
                dlmImpares.clear();
                txtNumero.setText("0");
                lblTotalNumeros.setText("Total Números: 0");
                lblMediaValor.setText("Media Valor: 0");
            }
        }
    }}
}