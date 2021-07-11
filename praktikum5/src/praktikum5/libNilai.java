package praktikum5;

public class libNilai {
    private static char predikat;
    static char hitung(int nilai){
        if(nilai >= 85){
            predikat = 'A';
        }else if((nilai>=70) && (nilai<85)){
            predikat = 'B';
        }else if((nilai>=60) && (nilai<70)){
            predikat = 'C';
        }else if((nilai>=50) && (nilai<60)){
            predikat = 'D';
        }else if(nilai<50){
            predikat = 'E';
        }
        return predikat;
    }

    static void daftarNilai(int[] nilai, int tot){
        System.out.println();
        System.out.println("Daftar Nilai");
        for(int j = 0; j < tot; j++){
            System.out.printf("Nilai %d, nilai hurufnya adalah %s", nilai[j], hitung(nilai[j]));
            System.out.println();
        }
    }
}