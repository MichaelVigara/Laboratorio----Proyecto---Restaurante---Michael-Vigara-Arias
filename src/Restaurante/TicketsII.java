package Restaurante;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ConexionBBDD.ConexionBBDD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class TicketsII {

	JFrame frame;
	private JTable TicketMesTiPagImpoTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketsII window = new TicketsII();
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
	public TicketsII() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 362, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAtras.setBounds(10, 11, 59, 23);
		frame.getContentPane().add(btnAtras);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todas las Mesas", "Mesa 01", "Mesa 02", "Mesa 03", "Mesa 04", "Mesa 05", "Mesa 06", "Mesa 07", "Mesa 08", "Mesa 09", "Mesa 10", "Mesa 11", "Mesa 12", "Mesa 13", "Mesa 14", "Mesa 15"}));
		comboBox.setBounds(154, 11, 121, 20);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 302, 266);
		frame.getContentPane().add(scrollPane);
		
		TicketMesTiPagImpoTotal = new JTable();
		TicketMesTiPagImpoTotal.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mesa", "Tipo de Pago", "Importe Total"
			}
		));
		scrollPane.setViewportView(TicketMesTiPagImpoTotal);
		
		JButton btnPagado = new JButton("Pagado");
		btnPagado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPagado.setBounds(112, 332, 121, 50);
		frame.getContentPane().add(btnPagado);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ticket");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmListar = new JMenuItem("Actualizar");
		mnNewMenu.add(mntmListar);
		ConexionBBDD Prueba = new ConexionBBDD();
		TicketMesTiPagImpoTotal.setModel(Prueba.Ticket());
		
		JButton btnBuscar = new JButton(">");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num_mesa =  (String) comboBox.getSelectedItem();
				if(num_mesa != "") {
					if(num_mesa.equals("Todas las Mesas")) {
						TicketMesTiPagImpoTotal.setModel(Prueba.Ticket());

					}else {
						TicketMesTiPagImpoTotal.setModel(Prueba.BuscarTicketMNesa(num_mesa));
					}
				}
			}
		});
		btnBuscar.setBounds(287, 9, 45, 25);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\DAW1\\Documents\\DAW1\\Programacion\\Marte\\Proyecto BBDD - Restaurante\\src\\Inicio\\fondo8.jpg"));
		lblFondo.setBounds(-26, -18, 465, 407);
		frame.getContentPane().add(lblFondo);
	}
}
