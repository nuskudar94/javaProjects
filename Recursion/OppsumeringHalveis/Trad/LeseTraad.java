package OppsumeringHalveis.Trad;

public class LeseTraad implements Runnable{
    Monitor monitor;

    public LeseTraad(Monitor m) {
        monitor = m;
    }

    @Override
    public void run(){
        while (!monitor.erFerdig() || monitor.hentAntMeldinger() > 0){
            String melding = monitor.hentMelding();
            if (melding == null) return;
            System.out.println(melding);
        }
    }
    
}