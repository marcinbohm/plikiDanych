import java.io.*;
import java.util.*;

public class dataInput {
    DataInputStream dataInput;

    public dataInput(String inputFile) throws IOException {
        dataInput = new DataInputStream(new FileInputStream(inputFile));
    }

    public List<Towar> readAll() throws IOException {
        List<Towar> listaTowaru = new ArrayList<>();

        try {
            while (true) {
                String nazwaTowaru = dataInput.readUTF();
                double cena = dataInput.readDouble();
                int liczbaSztuk = dataInput.readInt();

                Towar towar = new Towar(nazwaTowaru, liczbaSztuk, cena);
                listaTowaru.add(towar);
            }
        } catch (EOFException ex) {
            // koniec pliku
        }

        dataInput.close();

        return listaTowaru;
    }

    public void showProvidedItems(String nazwaPliku) {
        try {
            dataInput reader = new dataInput(nazwaPliku);

            List<Towar> listaWyboru = reader.readAll();

            for (Towar towar : listaWyboru) {
                System.out.println(towar.getNazwaTowaru());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int przetwarzajPlik( String nazwaPliku, String nazwaTowaru) {

        int liczbaSztuk = 0;
        try {
            dataInput reader = new dataInput(nazwaPliku);

            List<Towar> listaTowaru = reader.readAll();

            for (Towar towar : listaTowaru) {
                if (towar.getNazwaTowaru().equals(nazwaTowaru)) {
                    liczbaSztuk = towar.getLiczbaSztuk();
                    System.out.println("Cena: "+towar.getCena()+",-");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return liczbaSztuk;
    }

    public void inputRun(String nazwaPliku, String nazwaTowaru) throws IOException {

        dataInput datainput = new dataInput("towar.bin");
        System.out.println("Ilość wybranego towaru: "+datainput.przetwarzajPlik(nazwaPliku, nazwaTowaru));

    }
}
