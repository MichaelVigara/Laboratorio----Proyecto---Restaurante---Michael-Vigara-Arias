package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ConexionBBDD.ConexionBBDD;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AñadProductoIIAdmin {

	public JFrame frame;
	private JTextField textNombre;
	private JTextField textPrecio;
	ConexionBBDD Prueba;
	private JTextField textID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadProductoIIAdmin window = new AñadProductoIIAdmin();
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
	public AñadProductoIIAdmin() {
		initialize();
		Prueba = new ConexionBBDD();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 383, 198);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 36, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(90, 33, 130, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(24, 67, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(90, 64, 130, 20);
		frame.getContentPane().add(textPrecio);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 96, 60, 14);
		frame.getContentPane().add(lblCategoria);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		comboBoxCategoria.setBounds(76, 95, 144, 20);
		frame.getContentPane().add(comboBoxCategoria);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_producto = textID.getText();
				String producto = textNombre.getText();
				String precio = textPrecio.getText();
				String categoria = (String) comboBoxCategoria.getSelectedItem();
				Prueba.AñadirProd(id_producto, producto, precio, categoria);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(230, 32, 127, 83);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(10, 127, 70, 23);
		frame.getContentPane().add(btnAtras);
		
		JButton btnListo = new JButton("Listo");
		btnListo.setBounds(287, 127, 70, 23);
		frame.getContentPane().add(btnListo);
		
		textID = new JTextField();
		textID.setBounds(90, 11, 31, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\DAW1\\Documents\\DAW1\\Programacion\\Marte\\Proyecto BBDD - Restaurante\\src\\Inicio\\fondo3.jpg"));
		lblFondo.setBounds(-502, -13, 869, 175);
		frame.getContentPane().add(lblFondo);
	}
}
