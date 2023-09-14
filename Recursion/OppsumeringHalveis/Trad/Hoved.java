package OppsumeringHalveis.Trad;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Hoved {
    public static void main(String[] args) {
        MeldingsTjeneste verdi = new MeldingsTjeneste();
        Monitor monitor = new Monitor(verdi);

        CountDownLatch skriveCdl = new CountDownLatch(1);
        for (int i = 0; i<1; i++) {
            ArrayList<String> meldinger = new ArrayList<>();
            meldinger.add("Hei Karl!");
            meldinger.add("Jeg sitter paa bussen");
            meldinger.add("Hvor er du?");
            meldinger.add("Rett rundt hjoernet");

            Thread skrive = new Thread(new SkriveTraad(meldinger, monitor, skriveCdl));
            skrive.start();
        }
           
        Thread lese = new Thread(new LeseTraad(monitor));
        lese.start();

        try {
            skriveCdl.await();
            monitor.ferdig();
            System.out.println(monitor.erFerdig());
            monitor.signalDone();
            lese.join();
        } catch (InterruptedException e) {
            System.out.println("Failed to join main-thread");
            System.exit(1);
        }


    }
}