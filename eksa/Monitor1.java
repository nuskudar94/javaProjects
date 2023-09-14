import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {
    private Lock laas = new ReentrantLock();
    private Condition ikkeTomt = laas.newCondition();
    public SubsekvensRegister register;
    private boolean fortsette;

    public Monitor1(SubsekvensRegister register) {
        this.register = register;
        fortsette = false;
    }

    public void leggTil(HashMap<String, Subsekvens> Subsekvens) throws InterruptedException {
        laas.lock();
        try {
            while (fortsette) {
                ikkeTomt.await();
                
            }
            fortsette = true;
            register.leggTilSubsekvensMap(Subsekvens);
            fortsette = false;
            ikkeTomt.signal();
        } finally {
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> taUt() throws InterruptedException {
        laas.lock();
        try {
            HashMap<String, Subsekvens> subsekvens = register.taUtVilkårligSubsekvensMap();
            ikkeTomt.signalAll();
            return subsekvens;
        } finally {
            laas.unlock();
        }
    }

    public void leggTilSubsekvensMap(HashMap<String, Subsekvens> subsekvensMap) {
        laas.lock();
        try {
            register.leggTilSubsekvensMap(subsekvensMap);
        } finally {
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> taUtVilkårligSubsekvensMap() {
        laas.lock();
        try {
            return register.taUtVilkårligSubsekvensMap();
        } finally {
            laas.unlock();
        }
    }

    public int getAntallSubsekvensMaps() {
        laas.lock();
        try {
            return register.getAntallSubsekvensMaps();
        } finally {
            laas.unlock();
        }
    }

    public static HashMap<String, Subsekvens> lesImmunrepertoarFraFil(String filnavn) {

        try {
            return SubsekvensRegister.lesImmunrepertoarFraFil(filnavn);

        } finally {

        }
    }

    public static HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> map1,
            HashMap<String, Subsekvens> map2) {

        try {
            return SubsekvensRegister.flett(map1, map2);
        } finally {

        }
    }
}