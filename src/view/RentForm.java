package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import model.Rent;
import repository.RentRepository;

public class RentForm {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void openRentForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentForm window = new RentForm();
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
	public RentForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 964, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Persewaan Buku Mawar");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(368, 11, 238, 25);
		frame.getContentPane().add(titleLabel);
		
		this.buildRentTable();
	}
	public void buildRentTable() {
		DefaultTableModel tableModel = new DefaultTableModel(null, new String[] {
			"ID", 
			"Judul", 
			"Tanggal Pinjam", 
			"Tanggal Harus Kembali",
			"Tanggal Kembali",
			"Denda",
			"Biaya Sewa"
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 928, 233);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		ArrayList<Rent> rentList = RentRepository.fetchRents();
		for(Rent rent : rentList) {
			tableModel.addRow(rent.toRow());
		}

	}
}
