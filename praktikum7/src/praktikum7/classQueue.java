package praktikum7;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class classQueue {
   
	Queue<String> queueBarang;

    classQueue(){
        queueBarang=new LinkedList<>();
    }
    // input 
    Scanner inputBarang=new Scanner(System.in);

    // variabel namaBarang
    String namaBarang;
    boolean cekPenuh(){
        if(queueBarang.size() <=0){
            return false;
        }else{
            return true;
        }
    }

    //
    boolean cekKosong(){
        if(queueBarang.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    // enqueue
    void enqueue(){
		System.out.print("Masukkan nama barang (enqueue) = ");
        namaBarang= inputBarang.nextLine();
        queueBarang.add(namaBarang);
        System.out.println("["+namaBarang +"] dimasukkan dalam queue");
        System.out.println();
    }

    // dequeue
    String barangDihapus;
    void dequeue(){
        if (queueBarang.isEmpty()){
            System.out.println("Queue Kosong");
        }else {
            barangDihapus=queueBarang.remove();
            System.out.println("--> Nama Barang terhapus = "+barangDihapus);
        }

    }
    // search
    void searchQueue(){
        String searchBarang;
        System.out.print("Input nama Barang dicari = ");
        searchBarang = inputBarang.nextLine();
        if(queueBarang.contains(searchBarang)){
                System.out.println(searchBarang+" , ada dalam Queue");
        }else {
            System.out.println(searchBarang+ " tidak ada dalam Queue");
        }


    }

}