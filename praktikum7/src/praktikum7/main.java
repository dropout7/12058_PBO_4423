package praktikum7;

import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        classQueue barang=new classQueue();
        Scanner mengisiQueue=new Scanner(System.in);
        System.out.print("-- Sebelum Operasi --\n");
        System.out.println("Queue saat ini = " +barang.queueBarang);
        System.out.println("Cek Queue penuh? = "+barang.cekPenuh());
        System.out.println("Cek Queue kosong? = "+barang.cekKosong());
        System.out.println();
        // counter
        System.out.print("-- Operasi --\n");
        System.out.print("Input counter? = ");
        int lagi =mengisiQueue.nextInt();
        for (int i=0; i<lagi; i++){
            barang.enqueue();
        }
        
        System.out.println("Queue saat ini ="+barang.queueBarang);
        barang.searchQueue();
        System.out.println();

        //
        barang.dequeue();
        System.out.println();

        System.out.print("-- Setelah Operasi --\n");
        System.out.println("Queue saat setelah operasi = " +barang.queueBarang);
        System.out.println("Cek Queue penuh? = "+barang.cekPenuh());
        System.out.println("Cek Queue kosong? = "+barang.cekKosong());


    }



}