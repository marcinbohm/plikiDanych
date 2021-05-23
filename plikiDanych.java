import java.io.*;
import java.util.Scanner;

public class plikiDanych {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wprowadź plik, z którego chcesz korzystać //np. towar.bin");
        //towar.bin
        String plik = sc.nextLine();

        dataOutput RunO = new dataOutput(plik);
        RunO.outputRun(plik);

        dataInput RunI = new dataInput(plik);
        RunI.showProvidedItems(plik);
        System.out.println("Wprowadź produkt z listy, o którym chcesz uzyskać informację");
        String produkt = sc.nextLine();
        RunI.inputRun(plik, produkt);
    }
}