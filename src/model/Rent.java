package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Rent {
	public Integer id;
	public String judul;
	public LocalDate tanggalPinjam;
	public LocalDate tanggalHarusKembali;
	public LocalDate tanggalKembali;
	public Integer denda;
	public Integer biayaSewa;
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public Object[] toRow() {
		Object[] data = {
			this.id.toString(), 
			this.judul,
			this.tanggalPinjam != null ? this.tanggalPinjam.format(dateFormat) : null,
			this.tanggalHarusKembali != null ? this.tanggalHarusKembali.format(dateFormat) : null,
			this.tanggalKembali != null ? this.tanggalKembali.format(dateFormat) : null,
			this.denda.toString(),
			this.biayaSewa.toString()
		};
		return data;
	}
}
