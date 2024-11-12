package repasoexamen;

import java.awt.EventQueue;

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


public class VentanaJListNumeros extends JFrame {

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
		
		btnInsertar = new JButton("Insertar");
		panel.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);
		
		// creo el modelo de datos de la lista
		dlm = new DefaultListModel<Integer>();
		
		// creo la lista
		lstNumeros = new JList<Integer>();
		// asocio el modelo de datos a la lista
		lstNumeros.setModel(dlm);
		contentPane.add(lstNumeros, BorderLayout.CENTER);
	}

}
