package etapa_II;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javax.swing.JComboBox;

public class VentanaJListAlumnosFicheros extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 20241127L;
	private JPanel contentPane;
	private JTextField txtDia;
	private JPanel panel;
	private JLabel lblFecha;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Alumno> lstAlumnos;
	private DefaultListModel<Alumno> dlm;
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
	private JLabel lblGrupo;
	private JComboBox<String> cmbGrupos;
	public boolean DatosModificados;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListAlumnosFicheros frame = new VentanaJListAlumnosFicheros();
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
	public VentanaJListAlumnosFicheros() {
		setTitle("VentanaJListAlumnosFicheros");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
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
		txtAño.setText("2024");
		txtAño.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAño.setColumns(4);
		panel.add(txtAño);
		
		lblGrupo = new JLabel("Grupo");
		panel.add(lblGrupo);
		
		cmbGrupos = new JComboBox<String>();
		cmbGrupos.addItem("1AS3");
		cmbGrupos.addItem("2AS3");
		cmbGrupos.addItem("1DW3");
		cmbGrupos.addItem("2DW3");
		cmbGrupos.setSelectedIndex(2);
		panel.add(cmbGrupos);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		panel.add(btnInsertar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		// creo el modelo de datos de la lista
		dlm = new DefaultListModel<Alumno>();
		
		// creo la lista
		lstAlumnos = new JList<Alumno>();
		// asocio el modelo de datos a la lista
		lstAlumnos.setModel(dlm);
		contentPane.add(lstAlumnos, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		lblTotalElementos = new JLabel("Total Elementos:");
		panel_1.add(lblTotalElementos);
		
		lblTotalElementosValor = new JLabel("0");
		lblTotalElementosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblTotalElementosValor);
		
		// Inserto valores de prueba usando btnInsertar
		txtDNI.setText("8");
		txtNombre.setText("N8");
		txtApellidos.setText("A81 A82");
		btnInsertar.doClick();
		
		txtDNI.setText("4");
		txtNombre.setText("N4");
		txtApellidos.setText("A41 A42");
		btnInsertar.doClick();
		
		txtDNI.setText("6");
		txtNombre.setText("N6");
		txtApellidos.setText("A61 A62");
		btnInsertar.doClick();
		
		txtDNI.setText("9");
		txtNombre.setText("N9");
		txtApellidos.setText("A91 A92");
		btnInsertar.doClick();
		
		// compruebo si ya esta
		//btnInsertar.doClick();
		
		// compruebo campo vacio
		//txtDNI.setText("");
		//btnInsertar.doClick();
		//cargarDatos();
		DatosModificados = false;
	}

	// actionPerformed
	@Override
	public void actionPerformed(ActionEvent ae) {
		// obtengo sobre que componente se ha realizado la accion
		Object o = ae.getSource();
		
		if (o == btnInsertar){
			// si se ha pulsado btnInsertar
			// compruebo si txtNumerador O txtDenominador estan vacios
			// obtengo el valor de la propiedad Text
			String textoDNI = txtDNI.getText();
			String textoNombre = txtNombre.getText();
			String textoApellidos = txtApellidos.getText();
			if(textoDNI.isEmpty() || textoNombre.isEmpty() || textoApellidos.isEmpty()) {
				// si algun campo de texto esta vacio
				JOptionPane.showMessageDialog(this,(String)"Error. Los campos de texto NO pueden estar vacios","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si los campos de texto NO estan vacios
				// creo una nueva Persona con los datos de los campos
				// creo fechanacimiento de tipo Fecha
				String textoDia = txtDia.getText();
				int dia = Integer.parseInt(textoDia);
				String textoMes = txtMes.getText();
				int mes = Integer.parseInt(textoMes);
				String textoAño = txtAño.getText();
				int año = Integer.parseInt(textoAño);
				//Fecha fecha = new Fecha(dia,mes,año);
				
				// creo una nueva Persona
				//Persona persona = new Persona(textoDNI,textoNombre,textoApellidos,fecha);
				
				// creo un nuevo Alumno
				String grupo = (String) cmbGrupos.getSelectedItem();
				//Alumno valor = new Alumno(persona,grupo);
				Alumno valor = new Alumno(textoDNI,textoNombre,textoApellidos,dia,mes,año,grupo);
				
				if (dlm.contains(valor)) {
					// si ya esta en la lista
					JOptionPane.showMessageDialog(this,(String)"Error. El valor "+valor+" ya esta en la lista","Error",JOptionPane.ERROR_MESSAGE,null);
				}
				else {
					// si NO esta en la lista
					// busco la posicion donde insertar el valor
					int posicion = 0;
					int numeroElementos = dlm.getSize();
					Alumno valorLista;
					while(posicion < numeroElementos) {
						// compruebo si es la posicion a insertar
						valorLista = dlm.get(posicion);
						if(valor.compareTo(valorLista) < 0) {
							// si he encontrado la posicion
							// salgo del bucle
							break;
						}
						posicion = posicion + 1;
					}
					// lo Inserto en su posicion
					dlm.add(posicion, valor);
					DatosModificados = true;
				}
			}
		}
		else if (o == btnBorrar){
			// si se ha pulsado btnBorrar
			// obtengo cuantas opciones hay seleccionadas en la lista
			int[]indices = this.lstAlumnos.getSelectedIndices();
			int numeroOpciones = indices.length;
			if (numeroOpciones <= 0) {
				// si NO hay opciones seleccionadas
				JOptionPane.showMessageDialog(this,(String)"Error. No Hay Opciones Seleccionadas","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si hay opciones seleccionadas
				// las borro empezando por la ultima
				for(int posicion=numeroOpciones-1;posicion>=0;posicion--) {
					// borro el elemento cuyo indice esta en esa posicion
					dlm.remove(indices[posicion]);
					DatosModificados = true;
				}
			}
		}
		else if (o == btnLimpiar){
			// si se ha pulsado btnLimpiar
			// compruebo si la lista esta vacia
			if(dlm.isEmpty()) {
				// si esta vacia
				JOptionPane.showMessageDialog(this,(String)"Error. La lista esta vacia","Error",JOptionPane.ERROR_MESSAGE,null);
			}
			else {
				// si NO esta vacia
				// la vacio
				dlm.clear();
				DatosModificados = true;
			}
		}
		
	}
	
	
    public void guardarDatos2() {
    	
    	try {
            FileOutputStream fos = new FileOutputStream("alumnos.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            // Obtén la lista de personas a guardar
            Alumno valor;
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
            FileInputStream fis = new FileInputStream("alumnos.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Limpiar el modelo de lista antes de cargar nuevos datos
            dlm.clear();

            // Leer cada objeto de tipo Persona desde el archivo y agregarlo al DefaultListModel
            Alumno alumno;
            while (fis.available() > 0) {  // Mientras haya datos disponibles para leer
                alumno = (Alumno) ois.readObject();  // Leer el siguiente objeto Persona
                dlm.addElement(alumno);  // Agregar la persona al modelo de lista
            }


            // Cerrar los flujos
            ois.close();
            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
		
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
