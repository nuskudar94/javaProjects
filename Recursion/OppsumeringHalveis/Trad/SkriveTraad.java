package OppsumeringHalveis.Trad;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class SkriveTraad implements Runnable{
    ArrayList<String> meldinger;
    Monitor monitor;
    CountDownLatch cdl;

    public SkriveTraad(ArrayList<String> meldinger, Monitor m, CountDownLatch cdl){
        this.meldinger = meldinger;
        monitor = m;
        this.cdl = cdl;
    }


    @Override
    public void run(){
        while (meldinger.size() > 0){
            monitor.leggTilMelding(meldinger.remove(0));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e){
                System.out.println("Interrupted");
                return;
            }
        }
        cdl.countDown();
        System.out.println("skrive ferdig");
    }
}
