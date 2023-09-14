//package oblig1;

public class Verden {
    int antallRader, antallKolonner;
    Rutenett rutenett;
    int genNr=0;
    public Verden(int antallRader,int antallKolonner){
        // this.antallRader= antallRader;
        // this.antallKolonner=antallKolonner;
        rutenett = new Rutenett(antallRader,antallKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

    public void tegn(){
        System.out.println("Generasjonsnummer: " + genNr);
        rutenett.tegnRutenett();
        
        System.out.println("Antall levende naboer : "+rutenett.antallLevende());


    }

    

    public void oppdatering(){
        for(int i=0; i<rutenett.antRader ; i++){
            for(int j =0; j<rutenett.antKolonner; j++){
                rutenett.hentCelle(i,j).tellLevendeNaboer();
            }
        }
    
        for(int i=0; i<rutenett.antRader ; i++){
            for(int j =0; j<rutenett.antKolonner; j++){
                rutenett.hentCelle(i,j).oppdaterStatus();
            }
        }
        genNr++;


    }
    
}
