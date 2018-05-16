package Administracion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ConexionBBDD.ConexionBBDD;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AñadirCategoriaAdminII {

	JFrame frame;
	ConexionBBDD Prueba;
	private JTextField textNombCategoria;
	private JTextField textIDCate;
	private JTable IDCate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirCategoriaAdminII window = new AñadirCategoriaAdminII();
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
	public AñadirCategoriaAdminII() {
		initialize();
		Prueba = new ConexionBBDD();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 470, 238);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Categoria");
		lblNombre.setBounds(243, 62, 61, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombCategoria = new JTextField();
		textNombCategoria.setBounds(316, 59, 124, 20);
		frame.getContentPane().add(textNombCategoria);
		textNombCategoria.setColumns(10);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id_categoria = textIDCate.getText();
				String categoria = textNombCategoria.getText();
				Prueba.AñadirCat(id_categoria, categoria);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(342, 126, 98, 68);
		frame.getContentPane().add(button);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setBounds(12, 171, 67, 23);
		frame.getContentPane().add(btnAtras);
		
		JButton btnListo = new JButton("Validar");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = IDCate.getSelectedRow();
				String id_categoria=IDCate.getValueAt(row, 0).toString();
				String nomb_categoria=IDCate.getValueAt(row, 1).toString();
				textIDCate.setText(id_categoria);
				textNombCategoria.setText(nomb_categoria);
			}
		});
		btnListo.setBounds(359, 92, 81, 23);
		frame.getContentPane().add(btnListo);
		
		
		textIDCate = new JTextField();
		textIDCate.setBounds(404, 28, 36, 20);
		frame.getContentPane().add(textIDCate);
		textIDCate.setColumns(10);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\DAW1\\Documents\\DAW1\\Programacion\\Marte\\Proyecto BBDD - Restaurante\\src\\Inicio\\fondo3.jpg"));
		lblFondo.setBounds(-571, -269, 855, 455);
		frame.getContentPane().add(lblFondo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(379, 31, 61, 14);
		frame.getContentPane().add(lblId);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 209, 132);
		frame.getContentPane().add(scrollPane);
		
		IDCate = new JTable();
		IDCate.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Categoria"
			}
		));
		
		ConexionBBDD Prueba = new ConexionBBDD();
		IDCate.setModel(Prueba.IDCategoria());
		
		scrollPane.setViewportView(IDCate);
		

	}
}
