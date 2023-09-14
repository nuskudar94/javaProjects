import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Oblig5Del2A {
    public static void main(String[] args) {
        String dataDir = args[0];
        SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
        Monitor1 monitor = new Monitor1(subsekvensRegister);
        ArrayList<Thread> traader = new ArrayList<>();
        ArrayList<String> filenavnene = new ArrayList<>();
        File file1 = new File(dataDir, "/metadata.csv");

        System.out.println("\nLesing av dataene i gang!\n");
        try (Scanner scanner = new Scanner(file1)) {
            while (scanner.hasNext()) {
                String linje = scanner.nextLine();
                String[] koloner = linje.split(",");
                String navn = koloner[0].trim(); // tar hele linje
                filenavnene.add(navn);
            }
        } catch (Exception e) {
            System.out.println("Feil");
            return;
        }
        for (String filnavn : filenavnene) {
            String file2 = dataDir + "/" + filnavn;
            LeseTrad lesetrad = new LeseTrad(file2, monitor);
            traader.add(lesetrad);
            lesetrad.start();
        }
        for (Thread traa : traader) {
            try {
                traa.join(); // venter på at traader er ferdige
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (monitor.getAntallSubsekvensMaps() > 1) {
            HashMap<String, Subsekvens> map1 = monitor.taUtVilkårligSubsekvensMap();
            HashMap<String, Subsekvens> map2 = monitor.taUtVilkårligSubsekvensMap();
            monitor.leggTilSubsekvensMap(monitor.flett(map1, map2));
        }
        HashMap<String, Subsekvens> siste = subsekvensRegister.subsekvensMaps.get(0);
        int maks = 0;
        Subsekvens mostFrSubsekvens = null;
        for (Subsekvens sub : siste.values()) {
            if (sub.getAntall() > maks) {
                maks = sub.getAntall();
                mostFrSubsekvens = sub;
            }
        }
        System.out.println("Subsekvens " + mostFrSubsekvens + " " + maks + " forekomster.");
        System.out.println("\nLesing av dataene er over!\n");
    }

}
