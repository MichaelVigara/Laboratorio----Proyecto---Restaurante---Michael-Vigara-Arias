package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;
import Inicio.Index;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminsitracionI {

	public JFrame frame;
	private JTable AdministracionProdPreCatg;
	private JLabel lblBuscar;
	private JTextField textBuscarProd;
	private JLabel lblAadir;
	private JButton btnProductos;
	private JLabel lblAadirmodificar;
	private JButton btnCategorias;
	private JButton btnListo;
	private JButton btnAtras;
	private JButton btnListar;
	ConexionBBDD Prueba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminsitracionI window = new AdminsitracionI();
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
	public AdminsitracionI() {
		Prueba = new ConexionBBDD();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 561, 364);
		frame.getContentPane().add(scrollPane);
		
		AdministracionProdPreCatg = new JTable();
		AdministracionProdPreCatg.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre del Producto", "Precio", "Categoria"
			}
		));
		scrollPane.setViewportView(AdministracionProdPreCatg);
		
		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(581, 18, 46, 14);
		frame.getContentPane().add(lblBuscar);
		
		textBuscarProd = new JTextField();
		textBuscarProd.setBounds(626, 15, 86, 20);
		frame.getContentPane().add(textBuscarProd);
		textBuscarProd.setColumns(10);
		
		lblAadir = new JLabel("A\u00F1adir");
		lblAadir.setBounds(608, 196, 46, 14);
		frame.getContentPane().add(lblAadir);
		
		btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adProductoIIAdmin a�adirprod = new A�adProductoIIAdmin();
				AdministracionProdPreCatg.setModel(Prueba.Productos());
				a�adirprod.frame.setVisible(true);
				
				
			}
		});
		btnProductos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnProductos.setBounds(626, 217, 122, 50);
		frame.getContentPane().add(btnProductos);
		
		lblAadirmodificar = new JLabel("A\u00F1adir/Modificar");
		lblAadirmodificar.setBounds(591, 300, 93, 14);
		frame.getContentPane().add(lblAadirmodificar);
		
		btnCategorias = new JButton("Categorias");
		btnCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A�adirCategoriaAdminII a�adircat = new A�adirCategoriaAdminII();
				a�adircat.frame.setVisible(true);
				
			}
		});
		btnCategorias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCategorias.setBounds(624, 325, 122, 50);
		frame.getContentPane().add(btnCategorias);
		
		btnListo = new JButton("Listo");
		btnListo.setBounds(680, 399, 89, 23);
		frame.getContentPane().add(btnListo);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras.setBounds(10, 399, 64, 23);
		frame.getContentPane().add(btnAtras);
		
		btnListar = new JButton("Actualizar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				AdministracionProdPreCatg.setModel(Prueba.Productos());
			}
		});
		
		ConexionBBDD Prueba = new ConexionBBDD();
		AdministracionProdPreCatg.setModel(Prueba.Productos());
		
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListar.setBounds(626, 101, 122, 57);
		frame.getContentPane().add(btnListar);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Prueba.EliminarProd();				
				}
			
		});
		btnEliminar.setBounds(481, 386, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Todas las Categorias", "Refrescos", "Bebidas Alcoholicas", "Casqueria", "Carnes", "Pescados", "Sopas", "Entrantes", "Pizzas", "Ensaladas", "Arroces", "Bocadillos", "Postres", "Menu Infantil", "Hamburguesas", "Pasta", "Vinos"}));
		comboBoxCategoria.setBounds(581, 43, 141, 20);
		frame.getContentPane().add(comboBoxCategoria);
		
		JButton btnBuscar = new JButton("->");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomb_producto = textBuscarProd.getText();
				Prueba.BuscarProdAdmin(nomb_producto);
				AdministracionProdPreCatg.setModel(Prueba.BuscarProdAdmin(nomb_producto));

			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBuscar.setBounds(722, 14, 47, 23);
		frame.getContentPane().add(btnBuscar);		
		
		JButton button = new JButton("->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String nomb_categoria =  (String) comboBoxCategoria.getSelectedItem();
					if(nomb_categoria != "") {
						if(nomb_categoria.equals("Todas las Categorias")) {
							AdministracionProdPreCatg.setModel(Prueba.Productos());

						}else {
							AdministracionProdPreCatg.setModel(Prueba.BuscarCatAdmin(nomb_categoria));
						}
										
				}
			}
		});
		
		
		button.setFont(new Font("Tahoma", Font.PLAIN, 9));
		button.setBounds(732, 42, 47, 23);
		frame.getContentPane().add(button);
		
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\DAW1\\Documents\\DAW1\\Programacion\\Marte\\Proyecto BBDD - Restaurante\\src\\Inicio\\fondo3.jpg"));
		lblFondo.setBounds(0, -26, 794, 459);
		frame.getContentPane().add(lblFondo);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAadirProductos = new JMenu("Administracion");
		menuBar.add(mnAadirProductos);
		
		JMenu mnProductos = new JMenu("Productos");
		mnAadirProductos.add(mnProductos);
		
		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir Producto");
		mnProductos.add(mntmAadirProducto);
		
		
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				A�adProductoIIAdmin a�adirprod = new A�adProductoIIAdmin();
				a�adirprod.frame.setVisible(true);
			}
		});
		
		JMenu mnCategorias = new JMenu("Categorias");
		mnAadirProductos.add(mnCategorias);
		
		JMenuItem mntmAadirModificar = new JMenuItem("A\u00F1adir / Modificar Categorias");
		mnCategorias.add(mntmAadirModificar);
		
		mntmAadirModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				A�adirCategoriaAdminII a�adircate = new A�adirCategoriaAdminII();
				a�adircate.frame.setVisible(true);
			}

		});
		
		JMenu mnPedidos = new JMenu("Historial");
		mnAadirProductos.add(mnPedidos);
		
		JMenuItem mntmHistorialDePedidos = new JMenuItem("Historial de Pedidos");
		mnPedidos.add(mntmHistorialDePedidos);
		
		mntmHistorialDePedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.HistorialPedidos());
			}

		});
		
		JMenuItem mntmHistorialDeTickets = new JMenuItem("Historial de Tickets");
		mnPedidos.add(mntmHistorialDeTickets);
		
		mntmHistorialDeTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.HistorialTickets());
			}

		});
		
		
		JMenu mnVista = new JMenu("Vista");
		menuBar.add(mnVista);
		
		JMenuItem mntmPredeterminado = new JMenuItem("Predeterminado");
		mnVista.add(mntmPredeterminado);
			
		mntmPredeterminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.Productos());
			}

		});
		
		JMenu mnListarProductos = new JMenu("Mostrar por");
		mnVista.add(mnListarProductos);
		
		JMenu mnProducto = new JMenu("Producto");
		mnListarProductos.add(mnProducto);
		
		JMenuItem mntmProducto = new JMenuItem("Producto");
		mnProducto.add(mntmProducto);
		
		JMenuItem mntmProductoPrecio = new JMenuItem("Producto + Precio");
		mnProducto.add(mntmProductoPrecio);
		
		JMenuItem mntmProductoCategoria = new JMenuItem("Producto + Categoria");
		mnProducto.add(mntmProductoCategoria);
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mnListarProductos.add(mntmCategoria);
		
		JMenuItem mntmVistaTotal = new JMenuItem("Vista Total");
		mnListarProductos.add(mntmVistaTotal);
	
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.VerProd());
			}
		});
		
		mntmProductoPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.VerProdPrec());
			}

		});
		
		mntmProductoCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.VerProdCateg());
			}

		});
		
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.VerCateg());
			}

		});
		
		mntmVistaTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				AdministracionProdPreCatg.setModel(Prueba.VerTotal());
			}

		});
	}

	
	public void setVisible(boolean b) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}
}
