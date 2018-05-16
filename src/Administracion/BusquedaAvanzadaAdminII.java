package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusquedaAvanzadaAdminII {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaAvanzadaAdminII window = new BusquedaAvanzadaAdminII();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BusquedaAvanzadaAdminII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public BusquedaAvanzadaAdminII(AdminsitracionI administracion) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				administracion.setVisible(true);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				administracion.setVisible(true);
			}
		});
		
	}
	private void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Apéndice de método generado automáticamente
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 439, 181);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del Producto");
		lblNewLabel.setBounds(10, 25, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(137, 22, 136, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Categoria");
		lblNombreDeLa.setBounds(10, 87, 145, 14);
		frame.getContentPane().add(lblNombreDeLa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		comboBox.setBounds(155, 84, 136, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(7, 53, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(63, 50, 52, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblA = new JLabel("a");
		lblA.setBounds(134, 53, 21, 14);
		frame.getContentPane().add(lblA);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 50, 52, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(227, 53, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblOrdenar = new JLabel("Ordenar");
		lblOrdenar.setBounds(10, 115, 66, 14);
		frame.getContentPane().add(lblOrdenar);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Productos");
		chckbxNewCheckBox.setBounds(71, 111, 91, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxPrecio = new JCheckBox("Precio");
		chckbxPrecio.setBounds(165, 111, 66, 23);
		frame.getContentPane().add(chckbxPrecio);
		
		JCheckBox chckbxCategoria = new JCheckBox("Categoria");
		chckbxCategoria.setBounds(228, 111, 81, 23);
		frame.getContentPane().add(chckbxCategoria);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAtras.setBounds(353, 111, 66, 23);
		frame.getContentPane().add(btnAtras);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBuscar.setBounds(311, 31, 108, 52);
		frame.getContentPane().add(btnBuscar);
	}
}
