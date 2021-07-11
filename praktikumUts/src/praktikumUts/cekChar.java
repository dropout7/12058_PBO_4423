package praktikumUts;

import java.util.Stack;
import java.util.Scanner;

public class cekChar {
    public static void main(String[] args) {
    	Stack<Character> charKanan =  new Stack<>();
        Stack<Character> charKiri =  new Stack<>();
		// inisialisasi var
		boolean cekTidakValid = false;
        boolean cekValid = true;
        boolean cekSamaDengan = false;
        boolean cekValidSamaDengan = true;
        boolean keKanan = false;
        Scanner inp = new Scanner(System.in);
        System.out.print("Input persamaan = ");
        String persamaan = inp.next();
        char[] inputanArray = persamaan.toCharArray();
        for (int n = 0; n < inputanArray.length; n++) {
            char karakter = inputanArray[n];
            if(karakter == ' '){
                continue; // skip karakter spasi
            }
            if(karakter != '1' && karakter != '+' && karakter != '=') {
                cekTidakValid = true;
                break;
            }
            if(karakter == '+') {
                continue; // skip karakter +
            }
            if(!keKanan) {
                charKiri.add(karakter);
            }
            if(keKanan) {
                charKanan.add(karakter);
                if(charKiri.size() == 0) {
                    cekValid = false;
                } 
                else if(charKiri.size() > 1 && n == (inputanArray.length - 1)) {
                    cekValid = false;
                } else {
                    charKiri.pop();
                }
            }
            if(karakter == '=' ) {
                if(cekSamaDengan) {
                    cekValidSamaDengan = false;
                    break;
                }
                keKanan = true;
                continue;
            }
        }
        if(cekValid) {
            System.out.println("Persamaan valid");
        } 
        else if(cekTidakValid) {
            System.out.println("Tidak valid, hanya diijinkan 1,+,=");
        }
        else {
            System.out.println("Persamaan tidak valid");
        }
    }
}