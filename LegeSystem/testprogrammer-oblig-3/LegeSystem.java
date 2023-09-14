import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LegeSystem {   

    public static void main(String[] args) {
        
        ReadVedlegg("legedata.txt");
       
    }
    
    public static void ReadVedlegg(String fileName){

        Liste<Pasient> pasienter = new IndeksertListe<Pasient>();
        Liste<Legemiddel> legemidler = new IndeksertListe<Legemiddel>();
        Liste<Lege> leger = new Prioritetskoe<Lege>();
        Liste<Resepter> resepter = new IndeksertListe<Resepter>();

        //Scanner scan = new Scanner
        //Scanner inputFra = new Scanner(System.in);
        try  {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();

            // loop through each line in the file
            while (scanner.hasNextLine()) {

                // check if the line starts with the relevant data type
                if (line.startsWith("# Pasienter")) {
                    line=scanner.nextLine();

                    while(scanner.hasNextLine() && !line.startsWith("#")){
                        String [] pasientInfo = line.split(",");
                        String navn = pasientInfo[0];
                        String fnr = pasientInfo[1];
                        Pasient pasient1 = new Pasient(navn, fnr);
                        pasienter.leggTil(pasient1);
                    }

                    //continue; // skip the header line
                } else if (line.startsWith("# Legemidler")) {
                    line=scanner.nextLine();
                    while(scanner.hasNextLine() && !line.startsWith("#")){
                        String midlerInfo=
                    }

                    continue; // skip the header line
                } else if (line.startsWith("# Leger")) {
                    continue; // skip the header line
                } else if (line.startsWith("# Resepter")) {
                    continue; // skip the header line
                } else if (line.isEmpty()) {
                    continue; // skip empty lines
                }

                // split the line into its fields
                String[] fields = line.split(",");

                // check the data type of the line and leggTil it to the relevant list
                if (fields.length == 2) {
                    pasienter.leggTil(line);
                } else if (fields.length >= 4) {
                    legemidler.leggTil(line);
                } else if (fields.length == 2 || fields.length == 3) {
                    leger.leggTil(line);
                } else if (fields.length >= 4) {
                    resepter.leggTil(line);
                }

            }

            // print out the contents of each list
            System.out.println("Pasienter:");
            for (String pasient : pasienter) {
                System.out.println(pasient);
            }

            System.out.println("\nLegemidler:");
            for (String legemiddel : legemidler) {
                System.out.println(legemiddel);
            }

            System.out.println("\nLeger:");
            for (String lege : leger) {
                System.out.println(lege);
            }

            System.out.println("\nResepter:");
            for (String resept : resepter) {
                System.out.println(resept);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
