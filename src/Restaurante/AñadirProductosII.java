package Restaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AñadirProductosII {

	JFrame frame;
	private JTextField textNombreProd;
	private JTable AñadirProductoProdCateg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirProductosII window = new AñadirProductosII();
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
	public AñadirProductosII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 335, 313);
		frame.getContentPane().add(scrollPane);
		
		AñadirProductoProdCateg = new JTable();
		AñadirProductoProdCateg.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre del Producto", "Categoria"
			}
		));
		scrollPane.setViewportView(AñadirProductoProdCateg);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(355, 85, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombreProd = new JTextField();
		textNombreProd.setBounds(420, 82, 100, 20);
		frame.getContentPane().add(textNombreProd);
		textNombreProd.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(355, 113, 63, 14);
		frame.getContentPane().add(lblCategoria);
		
		JComboBox Categoria = new JComboBox();
		Categoria.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		Categoria.setBounds(420, 110, 148, 20);
		frame.getContentPane().add(Categoria);
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(10, 380, 65, 23);
		frame.getContentPane().add(btnAtras);
		
		ConexionBBDD Prueba = new ConexionBBDD();
		AñadirProductoProdCateg.setModel(Prueba.AñadirProd());
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(468, 342, 100, 57);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox Mesa = new JComboBox();
		Mesa.setModel(new DefaultComboBoxModel(new String[] {"Mesa 01", "Mesa 02", "Mesa 03", "Mesa 04", "Mesa 05", "Mesa 06", "Mesa 07", "Mesa 08", "Mesa 09", "Mesa 10", "Mesa 11", "Mesa 12", "Mesa 13", "Mesa 14", "Mesa 15"}));
		Mesa.setBounds(120, 15, 100, 20);
		frame.getContentPane().add(Mesa);
		Mesa.addMouseListener(new MouseListener() {
			public void mouseClicked1(MouseEvent e) {
				String nomb_producto = textNombreProd.getText();
				String nomb_categoria =  (String) Categoria.getSelectedItem();
				if(nomb_producto != "" || nomb_categoria != "") {
					if(nomb_categoria.equals("Todas las Categorias")) {
						AñadirProductoProdCateg.setModel(Prueba.AñadirProd());

					}else {
						AñadirProductoProdCateg.setModel(Prueba.BuscarProdCateAñadProdSlect(nomb_categoria));
					}
									
			
		
			}
				}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Apéndice de método generado automáticamente
				
			}
		});
		
		
		JLabel lblNumeroDeMesa = new JLabel("Numero de Mesa");
		lblNumeroDeMesa.setBounds(10, 18, 100, 14);
		frame.getContentPane().add(lblNumeroDeMesa);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomb_producto = textNombreProd.getText();
				String nomb_categoria =  (String) Categoria.getSelectedItem();
				if(nomb_producto != "" || nomb_categoria != "") {
					if(nomb_categoria.equals("Todas las Categorias")) {
						AñadirProductoProdCateg.setModel(Prueba.AñadirProd());

					}else {
						AñadirProductoProdCateg.setModel(Prueba.BuscarProdCateAñadProd(nomb_producto, nomb_categoria));
					}
									
			
		
			}
				}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBuscar.setBounds(503, 141, 65, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\DAW1\\Documents\\DAW1\\Programacion\\Marte\\Proyecto BBDD - Restaurante\\src\\Inicio\\fondo8.jpg"));
		lblFondo.setBounds(-40, 0, 618, 506);
		frame.getContentPane().add(lblFondo);
	}
}
