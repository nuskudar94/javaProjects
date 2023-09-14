package OppsumeringHalveis.Trad;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor implements MeldingsInterface {
    Lock laas = new ReentrantLock();
    MeldingsTjeneste tjeneste;
    boolean skrevetFerdig = false;
    Condition meldingKlar = laas.newCondition();

    public Monitor(MeldingsTjeneste mt){
        tjeneste = mt;
    }

    @Override
    public void leggTilMelding(String s) {
        laas.lock();
        try {
            tjeneste.leggTilMelding(s);
            meldingKlar.signal();
        } finally {
            laas.unlock();
        }

    }

    @Override
    public String hentMelding() {
        laas.lock();
        try {
            while (!erFerdig() && hentAntMeldinger() < 1) {
                meldingKlar.await();
            } if (hentAntMeldinger() < 1) {
                meldingKlar.signalAll();
                return null;
            }

            return tjeneste.hentMelding();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            return null;
        }
        
        finally {
            laas.unlock();
        }
    }

    @Override
    public int hentAntMeldinger() {
        laas.lock();

        try {
            return tjeneste.hentAntMeldinger();
        } finally {
            laas.unlock();
        }
    }

    public boolean erFerdig(){
        return skrevetFerdig;
    }

    public void ferdig() {
        skrevetFerdig = true;
    }

    public void signalDone(){
        laas.lock();
        try {
            meldingKlar.signalAll();
        }finally{
            laas.unlock();
        }

    }
    
}
