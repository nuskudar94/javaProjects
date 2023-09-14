import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class Lenkeliste <E> implements Liste<E> {
    // start = null ved 0 elementer
    protected Node start = null;
    protected Node tail = null;
    int stoerrelse ;

    @Override
    public int stoerrelse(){
        Node pointer = start;
        int stoerrelse = 0;
        while( pointer != null){
            stoerrelse++;
            pointer= pointer.neste;
        }
        return stoerrelse;
    }

    public class LenkelisteIterator implements Iterator<E>{
        private Node pointer=start;

        @Override
        public boolean hasNext(){
            return pointer != null;
        }
        @Override
        public E next(){
            if(pointer==null){
                throw new NoSuchElementException();
            }
            Node temp = pointer;
            pointer = pointer.neste;

            return  temp.verdi;
        }

    }
    public Iterator<E> iterator(){

        return new LenkelisteIterator();
    }
    protected class Node{
        Node neste;
        E verdi;

        public Node(E verdi){
            this.verdi=verdi;
            this.neste= null;
        }
    }

    @Override
    public void leggTil(E x){
        Node nyNode = new Node(x);

        if (start == null){
            start= nyNode;

        }else {
            Node noden = start;
            while(noden.neste != null){
                noden = noden.neste;
            }

            noden.neste = nyNode;
        }

        stoerrelse++;
    }


    @Override
    public E hent() throws UgyldigListeindeks{
        
        if (start == null){
            
            
            throw new UgyldigListeindeks(-1);

        }

        return start.verdi ;
    }

    @Override
    public E fjern(){
        if (start == null){

            throw new UgyldigListeindeks(-1);

        }else{
            Node noden =start;
            start= start.neste;
            stoerrelse--;
            return noden.verdi;
        }
     }

     @Override
     public String toString(){
        Node pointer = start;
        String elements ="";
        while( pointer != null){
            elements += pointer.verdi + ", " ;
            pointer = pointer.neste;
        }
        
        return "List: " + elements;

     }

    }
