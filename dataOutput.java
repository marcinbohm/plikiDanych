import java.util.*;
import java.io.*;

public class dataOutput {
    DataOutputStream dataOutput;

    public dataOutput(String outputFile) throws IOException {
        dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
    }

    public void write(Towar towar) throws IOException {
        dataOutput.writeUTF(towar.getNazwaTowaru());
        dataOutput.writeDouble(towar.getCena());
        dataOutput.writeInt(towar.getLiczbaSztuk());
    }

    public void writeIfMoreThan100(Towar towar) throws IOException {
        dataOutput.writeUTF(towar.getNazwaTowaru());
        towar.setCena(towar.getCena()*0.9);
        dataOutput.writeDouble(towar.getCena());
        dataOutput.writeInt(towar.getLiczbaSztuk());
    }

    public void save() throws IOException {
        dataOutput.close();
    }

    public void outputRun(String nazwaPliku) {

        List<Towar> listaTowaru = new ArrayList<>();

        listaTowaru.add(new Towar("Piłki", 20, 9.99));
        listaTowaru.add(new Towar("Gumki", 100, 15.99));
        listaTowaru.add(new Towar("Kwiatki", 150, 20.99));

        try {
            dataOutput writer = new dataOutput(nazwaPliku);

            for (Towar towar : listaTowaru) {
                if(towar.getLiczbaSztuk()>100){
                    writer.writeIfMoreThan100(towar);
                } else {
                    writer.write(towar);
                }
            }

            writer.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
