package RepetisjonLenke;

import java.util.Iterator;

public class Linje  implements Iterable<Linje.Stopp>{
   
    private Stopp start;

    public Linje(String navn){
        start = new Stopp(navn);

    }

   

    public void leggTilStopp(String navn){

        Stopp sisteStopp = start;


        while(sisteStopp.nesteStopp != null){
            sisteStopp= sisteStopp.nesteStopp;

        }

        sisteStopp.nesteStopp = new Stopp(navn);
    }


    class Stopp{

    private String navn;  //verdi or value here
    private Stopp nesteStopp=null;  //neste or next 

    public Stopp(String navn){
        this.navn=navn;
    }

    public String toString(){
        return navn;
    }
    }

    public Iterator<Stopp> iterator(){

        return new LinjeIterator();
    }

    class LinjeIterator implements Iterator<Stopp>{

        private Stopp peker = start;

        public boolean hasNext(){
            return peker != null;
        }


        public Stopp next(){

            Stopp temp  = peker;
            peker = peker.nesteStopp;

            return temp;
        }
    }


    public static void main(String[] args) {
        Linje linje1 = new Linje("Frognerseteren");

        String [] stoppNavn = {
            "",
            "","","",""
        };


        for (String navn : stoppNavn) {
            
            linje1.leggTilStopp(navn);

        }

        for (Stopp stopp : linje1) {
            
            System.out.println(stopp);
        }
    }
}

