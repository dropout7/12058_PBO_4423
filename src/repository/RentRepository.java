package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Rent;

public class RentRepository {
	public static Statement st;
    public static ResultSet rs;
	public static  ArrayList<Rent> fetchRents() {
		Connection cn = database.RentDatabase.Koneksi();
		ArrayList<Rent> rentList = new ArrayList<Rent>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM sewabuku");
			 while (rs.next()) {
				 Rent rentData = new Rent();
				 rentData.id = rs.getInt("id");
				 rentData.judul = rs.getString("judul");
				 rentData.tanggalPinjam = rs.getDate("tanggal_harus_kembali") != null ? rs.getDate("tanggal_pinjam").toLocalDate() : null;
				 rentData.tanggalHarusKembali = rs.getDate("tanggal_harus_kembali") != null ? rs.getDate("tanggal_harus_kembali").toLocalDate() : null;
				 rentData.tanggalKembali = rs.getDate("tanggal_kembali") != null ? rs.getDate("tanggal_kembali").toLocalDate() : null;
				 rentData.biayaSewa = rs.getInt("biaya_sewa");
				 rentData.denda = rs.getInt("denda");
			     rentList.add(rentData);
			    }
		} catch(Exception e) {
		    e.printStackTrace();
		}
		
		return rentList;
		
	}
}
