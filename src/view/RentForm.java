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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RentForm {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;

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
		frame.setBounds(100, 100, 964, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Persewaan Buku Mawar");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(368, 11, 238, 25);
		frame.getContentPane().add(titleLabel);
		
		JLabel dateLabel = new JLabel("Tanggal : ");
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateLabel.setBounds(10, 44, 72, 25);
		frame.getContentPane().add(dateLabel);
		
		JLabel timeLabel = new JLabel("Jam :");
		timeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		timeLabel.setBounds(694, 44, 45, 25);
		frame.getContentPane().add(timeLabel);
		
		this.buildRentTable();
		this.buildButtonAction();
		this.buildForm();
	}
	public void buildForm() {
		JLabel bookTitleLabel = new JLabel("Judul Buku");
		bookTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookTitleLabel.setBounds(10, 102, 72, 25);
		frame.getContentPane().add(bookTitleLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 104, 176, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	public void buildButtonAction() {
		JButton saveButton = new JButton("Simpan");
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleSaveButtonClick(e);
			}
		});
		saveButton.setBounds(86, 207, 115, 32);
		frame.getContentPane().add(saveButton);
		
		JButton returnButton = new JButton("Kembalikan");
		returnButton.setBounds(300, 207, 115, 32);
		frame.getContentPane().add(returnButton);
		
		JButton editButton = new JButton("Edit");
		editButton.setBounds(519, 207, 115, 32);
		frame.getContentPane().add(editButton);
		
		JButton deleteButton = new JButton("Hapus");
		deleteButton.setBounds(736, 207, 115, 32);
		frame.getContentPane().add(deleteButton);
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
		scrollPane.setBounds(10, 250, 928, 233);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel bookTitleLabel = new JLabel("Judul Buku");
		bookTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookTitleLabel.setBounds(10, 102, 72, 25);
		frame.getContentPane().add(bookTitleLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 104, 176, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		ArrayList<Rent> rentList = RentRepository.fetchRents();
		for(Rent rent : rentList) {
			tableModel.addRow(rent.toRow());
		}
	}
	public void handleSaveButtonClick(MouseEvent e) {
		System.out.print("dsdasdas");
	}
}
