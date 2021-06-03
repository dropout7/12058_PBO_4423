package praktikum11;

public class Sepeda extends Kendaraan{
    private boolean isAuto;

    //
    void jenis(){
        if (isAuto){
            System.out.println("Sepeda otomatis");
        }else {
            System.out.println("Sepeda kayuh");
        }
    }
}