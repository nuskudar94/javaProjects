import java.util.Iterator;

public class AListe<K,V> implements Iterable<K> {
    protected Node start, slutt;
    protected int storrelse = 0;

    protected class Node {
        Node forrige, neste;
        K nokkel;
        V verdi;

        public Node(K n, V v){
            nokkel = n;
            verdi = v;
        }
    }

    // Iterator klassen vår (indre klasse)
    class AListeIterator implements Iterator<K> {
        private Node peker = start;

        @Override
        public boolean hasNext(){
            return peker != null;
        }

        @Override
        public K next(){
            K verdiHoldtAv = peker.nokkel;
            peker = peker.neste;
            return verdiHoldtAv;
        }
    }

    @Override
    public Iterator<K> iterator(){
        return new AListeIterator();
    }

    public boolean harNokkel(K nokkel){
        Node peker = start;
        while (peker != null){
            if (peker.nokkel.equals(nokkel)){
                return true;
            }
            peker = peker.neste;
        }
        return false;
    }

    public int hentStr(){
        return storrelse;
    }

    public void settInn(K nokkel, V verdi){
        Node nyNode = new Node(nokkel, verdi);
        storrelse++;
        if (slutt == null){ // finnes ingen Noder fra før
            start = nyNode;
            slutt = nyNode;
            return;
        }
        slutt.neste = nyNode; // det som VAR slutt sin neste = nye noden
        nyNode.forrige = slutt; // ny node sin forrige = den som var slutt
        slutt = nyNode; // slutt = den nye node (som blir lagt til sist)
    }

    public V fjern(K nokkel){
        if (start.nokkel.equals(nokkel)){ // om lik start
            V verdi = start.verdi;
            start = start.neste;

            if (start != null){ // om det fortsatt finnes en Node
                start.forrige = null;
            } else { // Ingen flere noder igjen -> tom
                slutt = null;
            }
            storrelse--;
            return verdi;
        }

        Node peker = start;
        while(peker != null && !peker.nokkel.equals(nokkel)){
            peker = peker.neste;
        }
        
        // nokkel finnes ikke
        if (peker == null) return null;

        // Fant Node med nokkel
        V verdi = peker.verdi;
        storrelse--;
        // om Node er lik slutt
        if (peker == slutt){ 
            slutt = slutt.forrige;
            slutt.neste = null;
            return verdi;
        }
        // dersom Node verken er start eller slutt
        peker.forrige.neste = peker.neste;
        peker.neste.forrige = peker.forrige;
        return verdi;
    }

    public V hent(K nokkel){
        Node peker = start;
        while (peker != null && !peker.nokkel.equals(nokkel)){
            peker = peker.neste;
        }
        if (peker == null) return null;
        return peker.verdi;
    }

    public void sett(K nokkel, V verdi){
        Node peker = start;
        while(peker != null && !peker.nokkel.equals(nokkel)){
            peker = peker.neste;
        }
        if (peker != null){
            peker.verdi = verdi;
        }
    }

    @Override
    public String toString(){
        String tekst = "";
        Node peker = start;
        while (peker != null){
            tekst += "\n -> (NOKKEL: " + peker.nokkel 
                        + ", VERDI: " + peker.verdi + ")";
            peker = peker.neste;
        }
        return tekst;
    }
}

// Typeparameter K er nødt til aa arve fra Comparable
// Det vil si at den kan sammenlignes med et annet objekt av 
// typen K.
// Typeparameter V kan være hvilken som helst type   
public class AListeSortert<K extends Comparable<K>,V> 
            extends AListe<K,V> {
    @Override
    public void settInn(K nokkel, V verdi){
        // 1. tom liste
        if (slutt == null){
            super.settInn(nokkel, verdi);
            return;
        }

        Node nyNode = new Node(nokkel, verdi);

        // 2. skal inn i starten
        if (nokkel.compareTo(start.nokkel) < 0){
            nyNode.neste = start;
            start.forrige = nyNode;
            start = nyNode;
            return;
        }

        // 3. skal inn bakerst
        if (nokkel.compareTo(slutt.nokkel) > 0){
            super.settInn(nokkel, verdi);
            return;
        }

        // 4. eller må jobbe oss fram til riktig plass
        Node peker = start;
        while (peker.nokkel.compareTo(nokkel) < 0){
            peker = peker.neste;
        }
        peker.forrige.neste = nyNode;
        nyNode.forrige = peker.forrige;
        nyNode.neste = peker;
        peker.forrige = nyNode;
    }
}

public class Dato implements Comparable<Dato> {
    // 13.mars 2023 -> 13 03 2023
    private int dag, maaned, aar;

    public Dato(int dag, int maaned, int aar){
        this.dag = dag;
        this.maaned = maaned;
        this.aar = aar;
    }
    
    // < 0 objektet er mindre enn det andre
    // = 0 objektet er likt det andre
    // > 0 objektet er større enn det andre
    
    @Override
    public int compareTo(Dato annenDato){
        if (aar > annenDato.aar) return 1;
        if (aar < annenDato.aar) return -1;
        if (maaned > annenDato.maaned) return 1;
        if (maaned < annenDato.maaned) return -1;
        if (dag > annenDato.dag) return 1;
        if (dag < annenDato.dag) return -1;
        return 0;
    }

    @Override 
    public String toString(){
        return dag + "." + maaned + "." + aar;
    }
}

public class HarNokkel extends RuntimeException {
    
    public HarNokkel(String nokkel){
        super("Feil: " + nokkel + " - nokkel finnes allerede i lista");
    }
}

public class AListeUnik<K,V> extends AListe<K,V> {
    @Override
    public void settInn(K nokkel, V verdi) {
        if (harNokkel(nokkel)){
            throw new HarNokkel(nokkel.toString());
        }
        super.settInn(nokkel, verdi);
    }
}