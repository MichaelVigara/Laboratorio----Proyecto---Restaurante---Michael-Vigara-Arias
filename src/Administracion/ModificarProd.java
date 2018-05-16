package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModificarProd {

	private JFrame frame;
	private JTable ModProd;
	private JTextField textID;
	private JTextField textProducto;
	private JTextField textPrecio;
	private JButton btnActualizar;
	private JLabel label;
	private JButton btnValidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProd window = new ModificarProd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificarProd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 336, 302);
		frame.getContentPane().add(scrollPane);
		
		ModProd = new JTable();
		ModProd.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID Producto", "Nombre del Producto", "Precio", "Categoria"
			}
		));
		scrollPane.setViewportView(ModProd);
		
		ConexionBBDD Prueba = new ConexionBBDD();
		ModProd.setModel(Prueba.ModificarProd());
		
		JLabel lblIdProducto = new JLabel("ID Producto");
		lblIdProducto.setBounds(373, 19, 82, 16);
		frame.getContentPane().add(lblIdProducto);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(454, 16, 41, 22);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(373, 60, 82, 16);
		frame.getContentPane().add(lblProducto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(373, 102, 82, 16);
		frame.getContentPane().add(lblPrecio);
		
		textProducto = new JTextField();
		textProducto.setBounds(438, 57, 116, 22);
		frame.getContentPane().add(textProducto);
		textProducto.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(438, 99, 116, 22);
		frame.getContentPane().add(textPrecio);
		

		
		label = new JLabel("Categoria");
		label.setBounds(358, 145, 82, 16);
		frame.getContentPane().add(label);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		comboBoxCategoria.setToolTipText("Categoria");
		comboBoxCategoria.setBounds(438, 143, 141, 20);
		frame.getContentPane().add(comboBoxCategoria);

		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.setBounds(438, 288, 135, 69);
		frame.getContentPane().add(btnActualizar);
		
		btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = ModProd.getSelectedRow();
				String id_producto=ModProd.getValueAt(row, 0).toString();
				String nomb_producto=ModProd.getValueAt(row, 1).toString();
				String precio=ModProd.getValueAt(row, 2).toString();
				String nomb_categoria=ModProd.getValueAt(row, 3).toString();
				textID.setText(id_producto);
				textProducto.setText(nomb_producto);
				textPrecio.setText(precio);
				comboBoxCategoria.setSelectedItem(nomb_categoria);
			
			}
		});
		btnValidar.setBounds(482, 187, 97, 25);
		frame.getContentPane().add(btnValidar);
	}
}
