package exec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.ObjArrayPinjam;

public class ExecDb {
	public static Statement st;
    public static ResultSet rs;
	public static PreparedStatement pst;
	static Connection conn = database.KoneksiDb.Koneksi();
	public static  ArrayList<ObjArrayPinjam> fetchRents() {
		ArrayList<ObjArrayPinjam> daftarPinjam = new ArrayList<ObjArrayPinjam>();
		try {
			rs = conn.createStatement().executeQuery("SELECT * FROM sewabuku");
			 while (rs.next()) {
				 ObjArrayPinjam pinjamData = new ObjArrayPinjam();
				 pinjamData.id = rs.getInt("id");
				 pinjamData.judul = rs.getString("judul");
				 pinjamData.tanggalPinjam = rs.getDate("tanggal_harus_kembali") != null ? rs.getDate("tanggal_pinjam").toLocalDate() : null;
				 pinjamData.tanggalHarusKembali = rs.getDate("tanggal_harus_kembali") != null ? rs.getDate("tanggal_harus_kembali").toLocalDate() : null;
				 pinjamData.tanggalKembali = rs.getDate("tanggal_kembali") != null ? rs.getDate("tanggal_kembali").toLocalDate() : null;
				 pinjamData.hargaPinjam = rs.getInt("biaya_sewa");
				 pinjamData.denda = rs.getInt("denda");
			     daftarPinjam.add(pinjamData);
			    }
		} catch(Exception e) {
		    e.printStackTrace();
		}
		
		return daftarPinjam;
		
	}
	
	
	
	public static int tambahPinjam(String title) {
		LocalDate tanggalPinjam = LocalDate.now();
		LocalDate tanggalHarusKembali = LocalDate.now().plusDays(7);
		try {
			pst = conn.prepareStatement("INSERT INTO sewabuku (judul, tanggal_pinjam, tanggal_harus_kembali) VALUES ('" + title + "', '" + tanggalPinjam +"', '" + tanggalHarusKembali+ "');");
			pst.execute();
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
		    return 0;
		}
	}
	
	public static int editJudul(String idPinjam, String judulBuku) {
		try {
			pst = conn.prepareStatement("UPDATE sewabuku SET judul = '" + judulBuku + "' WHERE id = " + idPinjam + ";");
			pst.execute();
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	public static int hapusPinjam(String idPinjam) {
		try {
			pst = conn.prepareStatement("DELETE FROM sewabuku WHERE id="+ idPinjam +";");
			pst.execute();
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
		    return 0;
		}
	}
	
	public static int kembalikanPinjam(String idPinjam, LocalDate tanggalHarusKembali) {
		LocalDate tanggalKembali = LocalDate.now();
		int keterlambatan = tanggalKembali.compareTo(tanggalHarusKembali);
		int denda = 0;
		if (keterlambatan > 0) {
			denda = 2000 * keterlambatan;
		}
		try {
			pst = conn.prepareStatement("UPDATE sewabuku SET tanggal_kembali = '" + tanggalKembali + "', denda = '" + denda + "', biaya_sewa = 5000 WHERE id = " + idPinjam + ";");
			pst.execute();
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	
}
