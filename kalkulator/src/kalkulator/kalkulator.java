package kalkulator;
import java.util.Scanner; //class untuk mengambil input dari keyboard
public class kalkulator {
	public static void main(String[] args)
	{
		Scanner masukan = new Scanner(System.in);
		//double no1,no2;
		System.out.println("Masukkan dua angka= ");
		double no1 = masukan.nextDouble();
		double no2 = masukan.nextDouble();
		
		System.out.println("Masukkan operator (+) | (-) | (*) | (/) | (%)] ");
        char operator = masukan.next().charAt(0);
        double output = 0.0;
        switch (operator){
            case '+':
                output = no1 + no2;
                break;
            case '-':
                output = no1 - no2;
                break;
            case '*':
                output = no1 * no2;
                break;
            case '/':
                output = no1 / no2;
                break;
            case '%':
                output = no1 % no2;
                break;
            default:
                System.out.println("maaf inputan anda salah!");

        }
        System.out.println(no1+" "+operator+" "+no2+": "+output);
	}
}
