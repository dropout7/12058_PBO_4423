package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import model.ObjArrayPinjam;
import exec.ExecDb;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiPinjam {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JLabel lblTitle;
	private JLabel dlblTanggal;
	private JLabel lblTanggal2;
	private JLabel lblJam;
	private JLabel lblJam2;
	private JLabel lblBiaya;
	private JLabel lblRp;
	private JLabel lblHarga;
	private JTextField txtJudulBuku;
	private JButton btnSimpan;
	private JButton btnBatalEdit;
	private JButton btnKembalikan;
	private JButton btnEdit;
	private JButton btnHapus;
	private JTable table;
	private DefaultTableModel tableModel;
	private String currId = null;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPinjam window = new GuiPinjam();
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
	public GuiPinjam() {
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

		lblTitle = new JLabel("Persewaan Buku Satria");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblTitle.setBounds(329, 11, 323, 32);
		frame.getContentPane().add(lblTitle);

		dlblTanggal = new JLabel("Tanggal : ");
		dlblTanggal.setFont(new Font("Tahoma", Font.BOLD, 14));
		dlblTanggal.setBounds(667, 64, 72, 25);
		frame.getContentPane().add(dlblTanggal);

		lblJam = new JLabel("Jam :");
		lblJam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJam.setBounds(694, 44, 45, 25);
		frame.getContentPane().add(lblJam);

		lblTanggal2 = new JLabel("");
		lblTanggal2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTanggal2.setBounds(745, 64, 147, 25);
		frame.getContentPane().add(lblTanggal2);
		String currentDate = LocalDate.now().format(dateFormat);
		lblTanggal2.setText(currentDate);

		lblJam2 = new JLabel("");
		lblJam2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJam2.setBounds(745, 44, 147, 25);
		frame.getContentPane().add(lblJam2);
		String currentTime = LocalTime.now().format(timeFormat);
		lblJam2.setText(currentTime);

		lblBiaya = new JLabel("Biaya : ");
		lblBiaya.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBiaya.setBounds(527, 105, 72, 21);
		frame.getContentPane().add(lblBiaya);

		lblRp = new JLabel("Rp. ");
		lblRp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRp.setBounds(527, 135, 27, 21);
		frame.getContentPane().add(lblRp);

		lblHarga = new JLabel("");
		lblHarga.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHarga.setBounds(564, 137, 88, 21);
		frame.getContentPane().add(lblHarga);

		JLabel lblJudul = new JLabel("Judul Buku");
		lblJudul.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJudul.setBounds(48, 76, 125, 25);
		frame.getContentPane().add(lblJudul);

		txtJudulBuku = new JTextField();
		txtJudulBuku.setBounds(48, 104, 286, 32);
		frame.getContentPane().add(txtJudulBuku);
		txtJudulBuku.setColumns(10);

		this.tombolComps();
		this.tabelPinjam();
	}

	public void tombolComps() {
		btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSimpan.setBackground(Color.GREEN);
		btnSimpan.setForeground(Color.BLACK);
		btnSimpan.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				klikSimpan(e);
			}
		});
		btnSimpan.setBounds(112, 196, 147, 32);
		frame.getContentPane().add(btnSimpan);

		btnBatalEdit = new JButton("Batal Edit");
		btnBatalEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBatalEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				klikBatal();
			}
		});
		btnBatalEdit.setBounds(269, 196, 115, 32);
		frame.getContentPane().add(btnBatalEdit);

		btnKembalikan = new JButton("Kembalikan Buku");
		btnKembalikan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKembalikan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				klikKembalikan(e);
			}
		});
		btnKembalikan.setBounds(417, 196, 147, 32);
		frame.getContentPane().add(btnKembalikan);

		btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				klikEdit(e);
			}
		});
		btnEdit.setBounds(574, 196, 115, 32);
		frame.getContentPane().add(btnEdit);

		btnHapus = new JButton("Hapus");
		btnHapus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				klikHapus(e);
			}
		});
		btnHapus.setBounds(699, 196, 115, 32);
		frame.getContentPane().add(btnHapus);
	}

	@SuppressWarnings("serial")
	public void tabelPinjam() {
		tableModel = new DefaultTableModel(null, new String[] { "ID", "Judul Buku", "Tanggal Pinjam",
				"Tanggal Harus Kembali", "Tanggal Kembali", "Denda", "Biaya Sewa" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 258, 928, 225);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				klikBarisTabel();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		this.fetchData();
	}

	public void fetchData() {
		ArrayList<ObjArrayPinjam> daftarPinjam = ExecDb.fetchRents();
		for (ObjArrayPinjam pinjam : daftarPinjam) {
			tableModel.addRow(pinjam.toRow());
		}
	}

	public void klikBarisTabel() {
		int row = table.getSelectedRow();
		String hargaPinjam = (String) this.tableModel.getValueAt(row, 6);
		this.lblHarga.setText(hargaPinjam);
	}

	public void klikSimpan(MouseEvent e) {
		int simpanPinjaman = 0;
		if (this.currId == null) {
			simpanPinjaman = ExecDb.tambahPinjam(txtJudulBuku.getText());
		} else {
			simpanPinjaman = ExecDb.editJudul(this.currId, this.txtJudulBuku.getText());
		}
		if (simpanPinjaman == 1) {
			JOptionPane.showMessageDialog(null, "Berhasil disimpan");
			System.out.print("Berhasil");
			this.txtJudulBuku.setText("");
			this.btnBatalEdit.setVisible(false);
			this.btnSimpan.setText("Simpan");
			this.currId = null;
			this.tableModel.setRowCount(0);
			this.fetchData();
		} else {
			JOptionPane.showMessageDialog(null, "Gagal disimpan");
		}
	}

	public void klikHapus(MouseEvent e) {
		int row = this.table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Pilih salah satu untuk dihapus");
			return;
		}
		String idPinjam = this.tableModel.getValueAt(row, 0).toString();
		int hapusPinjam = ExecDb.hapusPinjam(idPinjam);
		if (hapusPinjam == 1) {
			JOptionPane.showMessageDialog(null, "Berhasil dihapus");
			this.tableModel.setRowCount(0);
			this.fetchData();
		} else {
			JOptionPane.showMessageDialog(null, "Gagal dihapus");
		}
	}

	public void klikKembalikan(MouseEvent e) {
		int row = this.table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, " salah satu untuk dikembalikan");
			return;
		}
		String tanggalKembali = (String) this.tableModel.getValueAt(row, 4);
		if (tanggalKembali != null) {
			JOptionPane.showMessageDialog(null, " sudah pernah dikembalikan");
			return;
		}
		String idPinjam = this.tableModel.getValueAt(row, 0).toString();
		LocalDate tanggalHarusKembali = LocalDate.parse(tableModel.getValueAt(row, 3).toString(), this.dateFormat);
		int kembalikanPinjam = ExecDb.kembalikanPinjam(idPinjam, tanggalHarusKembali);
		if (kembalikanPinjam == 1) {
			JOptionPane.showMessageDialog(null, " Berhasil dikembalikan");
			tableModel.setRowCount(0);
			this.fetchData();
		} else {
			JOptionPane.showMessageDialog(null, " gagal dikembalikan");
		}
	}

	public void klikEdit(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Pilih salah satu untuk diedit");
			return;
		}
		String idPinjam = (String) this.tableModel.getValueAt(row, 0);
		String judul = (String) this.tableModel.getValueAt(row, 1);
		String tanggalPinjam = (String) this.tableModel.getValueAt(row, 2);
		String tanggalHarusKembali = (String) this.tableModel.getValueAt(row, 3);
		String tanggalKembali = (String) this.tableModel.getValueAt(row, 4);
		String denda = (String) this.tableModel.getValueAt(row, 5);
		String hargaPinjam = (String) this.tableModel.getValueAt(row, 6);
		if (idPinjam != null && judul != null && tanggalPinjam != null && tanggalHarusKembali != null
				&& tanggalKembali != null && denda != null && hargaPinjam != null) {
			JOptionPane.showMessageDialog(null, "Data lengkap, tdk bisa Diedit");
			return;
		}
		this.txtJudulBuku.setText(judul);
		this.currId = idPinjam;
		this.btnSimpan.setText("Simpan Perubahan");
		this.btnBatalEdit.setVisible(true);
	}

	public void klikBatal() {
		this.btnBatalEdit.setVisible(false);
		this.currId = null;
		this.btnSimpan.setText("Simpan");
		this.txtJudulBuku.setText("");
	}
}