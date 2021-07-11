package praktikum11;

public class MainBangunan {
    public static void main(String[] args) {
        Kotak kotak = new Kotak(4, 4, 5);
        System.out.println("Luas Kotak = " + kotak.getLuas());
        System.out.println("Keliling Kotak = " + kotak.getKeliling());
        kotak.resize(2);
        System.out.println("Luas Kotak (setelah resize) = " + kotak.getLuas());
        System.out.println("Keliling Kotak (setelah resize) = " + kotak.getKeliling());
        Segitiga segitiga = new Segitiga(3, 5,6);
    }
}