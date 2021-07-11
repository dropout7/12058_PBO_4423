package praktikum11;

public class MainKendaraan extends Kendaraan {
    private int kondisiAwal;


    public static void main(String[] args) {
        MainKendaraan panggil=new MainKendaraan();

        //
        Sepeda ambilSepeda=new Sepeda();
        System.out.print("Tipe sepeda kita adalah ");
        ambilSepeda.jenis();
        System.out.println();
    }
}