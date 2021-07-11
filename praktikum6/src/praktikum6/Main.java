package praktikum6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Stack = new Scanner(System.in);

        gudangSaya gudang = new gudangSaya();

        // counter input stack//
        int jmlBarang;

        System.out.println();
        System.out.println("Input Barang Gudang");
        System.out.print("Input Counter Barang = ");
        jmlBarang = Stack.nextInt();
        for (int i = 0; i < jmlBarang; i++) {
            gudang.inputBarang();
            gudang.pushRak();
        }
        System.out.println("Stack Barang saat ini = " + gudang.rakBarang);
        System.out.print("Cek Stack Kosong = " + gudang.cekKosong());
        System.out.println();
        gudang.popBarang();
        gudang.peekBarang();
        System.out.println("Stack Barang terkini = " + gudang.rakBarang);
        gudang.showSearch();

        Stack.close();

    }
}