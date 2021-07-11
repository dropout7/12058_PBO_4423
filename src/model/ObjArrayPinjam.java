package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ObjArrayPinjam {
	public Integer id;
	public String judul;
	public LocalDate tanggalPinjam;
	public LocalDate tanggalHarusKembali;
	public LocalDate tanggalKembali;
	public Integer denda;
	public Integer hargaPinjam;
	DateTimeFormatter tanggalan = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public Object[] toRow() {
		Object[] data = {
			this.id.toString(), 
			this.judul,
			this.tanggalPinjam != null ? this.tanggalPinjam.format(tanggalan) : null,
			this.tanggalHarusKembali != null ? this.tanggalHarusKembali.format(tanggalan) : null,
			this.tanggalKembali != null ? this.tanggalKembali.format(tanggalan) : null,
			this.denda.toString(),
			this.hargaPinjam.toString()
		};
		return data;
	}
}
