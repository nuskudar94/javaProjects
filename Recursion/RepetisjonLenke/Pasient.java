package RepetisjonLenke;

public class Pasient implements Comparable<Pasient> {
    

    private String beskrivelse;
    private int prioritet;


    public Pasient(String beskrivelse,int prioritet){
        this.beskrivelse=beskrivelse;
        this.prioritet=prioritet;
    }


    public int compareTo(Pasient annen){

        if(prioritet < annen.prioritet){
            return -1;
        }else if(prioritet == annen.prioritet){
            return 0;
        }else{
            return 1;
        }
    }


    public static void main(String[] args) {
        System.out.println();


        Pasient forste = new Pasient("Brukket bein", 3);
        Pasient andre = new Pasient("Mistanke om hjertefeil", 1);


        assert forste.compareTo(andre) < 0 : " ! < 0";
        
    }
}
