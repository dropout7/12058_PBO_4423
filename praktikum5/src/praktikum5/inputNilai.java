package praktikum5;

import java.util.Scanner;

public class inputNilai {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Masukan total inputan : ");
        int tot = inp.nextInt();
        int[] nilai = new int[tot];
        for(int i = 0; i < tot; i++){
            System.out.print("Masukan nilai : ");
            nilai[i] = inp.nextInt();
        }
        libNilai tampil = new libNilai();
        tampil.daftarNilai(nilai,tot);
    }
}
