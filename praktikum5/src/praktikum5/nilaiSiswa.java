package praktikum5;

import java.util.Scanner;

public class nilaiSiswa {

    public static void main(String[] args) {
        siswaClass aksi = new siswaClass();
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan jumlah data : ");
        int totData = inp.nextInt();

        for(int i = 0; i < totData; i++){
            System.out.print("Nim     : ");
            aksi.setNim(inp.next());
            System.out.print("Nama    : ");
            aksi.setNama(inp.next());
            System.out.print("Nilai Teori   : ");
            aksi.setTeori(inp.nextInt());
            System.out.print("Nilai Praktek : ");
            aksi.setPraktek(inp.nextInt());
            System.out.println();
        }
        
        System.out.println();
        System.out.println("\nDaftar Nilai Siswa");
        for(int j = 0; j < totData; j++){
            aksi.getNim(j);
            aksi.getNama(j);
            aksi.getTeori(j);
            aksi.getPraktek(j);
            aksi.getRata(j);
        }
    }
}