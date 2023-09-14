

public class Lege implements Comparable <Lege> {
    
    String legeNavn;
    public Lege(String legeNavn){
        this.legeNavn=legeNavn;
        IndeksertListe<Resepter> utskrevneResepter = new IndeksertListe<Resepter>();
    }

    public String hentLegeNavn(){
        return this.legeNavn;
    }

    @Override
    public String toString(){
        return " Lege: "+this.legeNavn;
    }


    @Override
    public int compareTo(Lege lege){
        if(legeNavn > lege.legeNavn){
            return 1;}
        if(legeNavn < lege.legeNavn){
            return -1;}
        return 0;



    }
}