package repasoexamen;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionBisiestos extends JFrame implements ActionListener {

    private static final long serialVersionUID = 20231122L;
    private JPanel contentPane;
    private JTextField txtNumero;
    private JLabel lblTotalNumeros;
    private JLabel lblMediaValor;
    private DefaultListModel<Integer> dlmBisiestos;
    private DefaultListModel<Integer> dlmNoBisiestos;
    private JList<Integer> lstBisiestos;
    private JList<Integer> lstNoBisiestos;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GestionBisiestos frame = new GestionBisiestos();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GestionBisiestos() {
        setTitle("Examen1 - Alain Luque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 344);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Cuando se hace clic en otra parte, quitar el foco y deseleccionar el texto
		        txtNumero.setFocusable(false); // Para evitar que se mantenga el foco en el campo
		        txtNumero.setFocusable(true); // Volver a permitir el foco
		    }
		});
        
        JPanel panelCabecera = new JPanel();
        contentPane.add(panelCabecera, BorderLayout.NORTH);

        JLabel lblNumero = new JLabel("Año");
        panelCabecera.add(lblNumero);

        txtNumero = new JTextField("0", 10);
        txtNumero.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txtNumero.requestFocus();  // FOCO EN EL CAMPO DE TEXTO
 		        txtNumero.selectAll();     // Seleccionar todo el texto
 		      //txtEquipoNombre1.setText(""); PARA QUE DESAPAREZCA AL HACER CLICK
 		    }
 		});
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        panelCabecera.add(txtNumero);

        JButton btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(this);
        panelCabecera.add(btnInsertar);

        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(this);
        panelCabecera.add(btnBorrar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(this);
        panelCabecera.add(btnLimpiar);

        JPanel panelCentral = new JPanel(new BorderLayout());
        contentPane.add(panelCentral, BorderLayout.CENTER);

        JPanel panelBisiestos = new JPanel(new BorderLayout());
        panelBisiestos.setPreferredSize(new Dimension(150, 200));
        panelBisiestos.add(new JLabel("Años Bisiestos", SwingConstants.CENTER), BorderLayout.NORTH);
        dlmBisiestos = new DefaultListModel<>();
        lstBisiestos = new JList<>(dlmBisiestos);
        panelBisiestos.add(new JScrollPane(lstBisiestos), BorderLayout.CENTER);
        panelCentral.add(panelBisiestos, BorderLayout.WEST);

        JPanel panelNoBisiestos = new JPanel(new BorderLayout());
        panelNoBisiestos.setPreferredSize(new Dimension(150, 200));
        panelNoBisiestos.add(new JLabel("Años No Bisiestos", SwingConstants.CENTER), BorderLayout.NORTH);
        dlmNoBisiestos = new DefaultListModel<>();
        lstNoBisiestos = new JList<>(dlmNoBisiestos);
        panelNoBisiestos.add(new JScrollPane(lstNoBisiestos), BorderLayout.CENTER);
        panelCentral.add(panelNoBisiestos, BorderLayout.EAST);

        JPanel panelPie = new JPanel();
        contentPane.add(panelPie, BorderLayout.SOUTH);

        lblTotalNumeros = new JLabel("Total Años: 0");
        panelPie.add(lblTotalNumeros);

        lblMediaValor = new JLabel("Media Valor: 0");
        panelPie.add(lblMediaValor);
    }

 // Método que verifica si un año es bisiesto
    private boolean esBisiesto(int anio) {
        // Un año es bisiesto si es divisible entre 4 y no entre 100, o si es divisible entre 400
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

 // Método que calcula el total de años ingresados en ambas listas (bisiestos y no bisiestos)
    private int calcularTotalAnios() {
        // Retorna la suma de los elementos en las listas de años bisiestos y no bisiestos
        return dlmBisiestos.size() + dlmNoBisiestos.size();
    }

 // Método que calcula la media de los años en ambas listas
    private double calcularMediaAnios() {
        // Obtiene el total de elementos en ambas listas
        int totalElementos = calcularTotalAnios();

        // Si no hay elementos, retorna 0 para evitar división por cero
        if (totalElementos == 0) return 0;

        // Suma todos los años en las listas de bisiestos y no bisiestos
        int sumaTotal = 0;
        for (int i = 0; i < dlmBisiestos.size(); i++) {
            sumaTotal += dlmBisiestos.get(i);
        }
        for (int i = 0; i < dlmNoBisiestos.size(); i++) {
            sumaTotal += dlmNoBisiestos.get(i);
        }

        // Calcula y retorna la media dividiendo la suma total entre el número de elementos
        return (double) sumaTotal / totalElementos;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o instanceof JButton) {
            JButton boton = (JButton) o;

            if (boton.getText().equals("Insertar")) {

               

                
    		    //SI EL CAMPO ESTA VACIO
                if (txtNumero.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se ha introducido ningún año.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int anio = Integer.parseInt(txtNumero.getText().trim());

              //SI EL NUMERO YA ESTA EN LA LISTA
                if (dlmBisiestos.contains(anio) || dlmNoBisiestos.contains(anio)) {
                    JOptionPane.showMessageDialog(this, "Error, ese año ya ha sido introducido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (esBisiesto(anio)) {
                	
                	  // Insertar en la lista de primos en orden descendente
                	
                	int i = 0;
			        // Buscar la posición donde el número es mayor que los números existentes
                	while (i < dlmBisiestos.size() && dlmBisiestos.get(i) > anio) {
			            i++;
			        }
                	
                	dlmBisiestos.add(i, anio); // Inserta el número en la posición correcta
                	
    		    //INSERTA NUMERO EN LISTA NO PRIMOS
                } else {
                	 // Insertar en la lista de no primos en orden ascendente
			        int i = 0;
			        // Buscar la posición donde el número es menor que los números existentes
			        while (i < dlmNoBisiestos.size() && dlmNoBisiestos.get(i) < anio) {
			            i++;
			        }
			        dlmNoBisiestos.add(i, anio); // Inserta el número en la posición correcta
			    }

                lblTotalNumeros.setText("Total Años: " + calcularTotalAnios());
                lblMediaValor.setText("Media Valor: " + calcularMediaAnios());

            } else if (boton.getText().equals("Borrar")) {
                int indexBisiestos = lstBisiestos.getSelectedIndex();
                int indexNoBisiestos = lstNoBisiestos.getSelectedIndex();
                
                boolean elementoBorrado = false;

                if (indexBisiestos != -1) {
                    dlmBisiestos.remove(indexBisiestos);
                    elementoBorrado = true;
                }
                if (indexNoBisiestos != -1) {
                    dlmNoBisiestos.remove(indexNoBisiestos);
                    elementoBorrado = true;
                }
                
                // SI NO HAY NADA PA BORRAR Si no se ha borrado ningún elemento, mostrar un mensaje de error
	            if (!elementoBorrado) {
	                JOptionPane.showMessageDialog(this, "No hay ningún elemento seleccionado para borrar.", "Error", JOptionPane.ERROR_MESSAGE);
	                
	            }

                lblTotalNumeros.setText("Total Años: " + calcularTotalAnios());
                lblMediaValor.setText("Media Valor: " + calcularMediaAnios());

            } else if (boton.getText().equals("Limpiar")) {
                if (dlmBisiestos.isEmpty() && dlmNoBisiestos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No hay nada que limpiar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dlmBisiestos.clear();
                    dlmNoBisiestos.clear();
                    txtNumero.setText("0");
                    lblTotalNumeros.setText("Total Años: 0");
                    lblMediaValor.setText("Media Valor: 0");
                }
            }
        }
    }
}