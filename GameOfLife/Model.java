public class Model {

    private int rader, kolonner;
    private Rutenett rutenett;
    private Verden verden;

    public Model(int antRader,int antKolonner){
        rader = antRader;
        kolonner = antKolonner;

        verden = new Verden(antRader, antKolonner);
        rutenett =new Rutenett(antRader, antKolonner);
    }

    public void lagRutenett(){

        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();

        
    }
    public char hentStatus(int rad,int kol){
        return rutenett.rutene[rad][kol].hentStatusTegn();
    }
    public Rutenett hentRutenett(){
        return rutenett;
    }

    public int antallLevendeiModel(){
        return verden.rutenett.antallLevende();
    }

    public void oppdatering(int rad, int kol) {
        for (int raderTell = 0; raderTell < rad; raderTell++) {
            for (int kolonTell = 0; kolonTell < kol; kolonTell++) {
                rutenett.hentCelle(raderTell, kolonTell).tellLevendeNaboer();
            }
        }
        for (int raderTell = 0; raderTell < rad; raderTell++) {
            for (int kolonTell = 0; kolonTell < kol; kolonTell++) {
                rutenett.hentCelle(raderTell, kolonTell).oppdaterStatus();
            }
        }
    }
    //package oblig1;

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


class Celle {
    public boolean levende;
    public Celle[] naboer;
    public int antLevendeNaboer;
    public int antNaboer;


    public Celle(){
       levende=false;
       naboer= new Celle[8];
       antLevendeNaboer=0;
       antNaboer=0;

    }
    public void settDoed(){
        levende= false;
    }
    public void settLevende(){
        levende= true;
    }

    public boolean erLevende(){
        return levende;
    }

    public char hentStatusTegn(){
        if(levende){
            return 'O';
        }
        else{
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo){
        
       naboer[antNaboer++]=nabo;

        }
    public void tellLevendeNaboer(){
         antLevendeNaboer=0;
        for(int i=0; i<antNaboer; i++){
            if(naboer[i].erLevende()){
                antLevendeNaboer++;
                
            }
            
            
        }}
    

    public void oppdaterStatus(){
        
        if(levende==false){
            if(antLevendeNaboer==3){
               settLevende();
            }
         }
        else{ 
            if ( antLevendeNaboer < 2 || antLevendeNaboer >3){
                settDoed();
        }
            
        }

    }
   


}


    


    //package oblig1;

class Rutenett {
    Celle[][] rutene;
    int antRader;
    int antKolonner;
    //Rutenett konstruktør
    public Rutenett(int antRader, int antKolonner){
        this.antRader=antRader;
        this.antKolonner=antKolonner;

        rutene=new Celle[antRader][antKolonner];

    }
    //LAger celler for rutenett og setter inn
    public void lagCelle(int rader, int koloner){
        if(rutene[rader][koloner]==null){
            rutene[rader][koloner]=new Celle();
            if(Math.random()<=0.3333){
                rutene[rader][koloner].settLevende();
            }
        }
    }
    //Setter celler inn i rutenett tilfeldig 
    public void fyllMedTilfeldigeCeller(){
        for(int radTeller=0; radTeller < antRader;radTeller++ ){
            for (int kolTeller=0; kolTeller<antKolonner; kolTeller++){
                lagCelle(radTeller, kolTeller);
            } 
        }
    }

    //Henter celler
    public Celle hentCelle(int rad, int kolonne){
        if((rad>=0 && rad< antRader)&&(kolonne>=0 && kolonne< antKolonner)){
        return rutene[rad][kolonne];
        }else{
            return null;
        }
    }
    //Tegner rutenett med tegninger
    public void tegnRutenett(){
        System.out.print("+");
        for (int radlinjer=0; radlinjer< antKolonner; radlinjer++){
            System.out.print("---+");
        }System.out.println(" ");
        for (int radTeller1=0; radTeller1<antRader; radTeller1++){
          System.out.print("|");
          for (int kolTeller1=0; kolTeller1<antKolonner; kolTeller1++){
            
            System.out.print(" "+ rutene[radTeller1][kolTeller1].hentStatusTegn()+" |");

          }System.out.println("");
          System.out.print("+");
        for (int radlinjer=0; radlinjer< antKolonner; radlinjer++){
            System.out.print("---+");
        }System.out.println(" ");
        }

    }
    //setter Naboer til rutenett
    public void settNaboer(int rad, int kolonne) {
        Celle celle2=hentCelle(rad,kolonne);
        if (hentCelle(rad-1, kolonne-1)!=null){
            celle2.leggTilNabo(hentCelle(rad-1, kolonne-1));
        }
        if(hentCelle(rad-1, kolonne)!=null){
        celle2.leggTilNabo(hentCelle(rad-1, kolonne));
        }
        if(hentCelle(rad-1, kolonne+1)!=null){
            celle2.leggTilNabo(hentCelle(rad-1, kolonne+1));
        }
        if(hentCelle(rad, kolonne+1)!=null){
            celle2.leggTilNabo(hentCelle(rad, kolonne+1));
        }
        if(hentCelle(rad+1, kolonne+1)!=null){
            celle2.leggTilNabo(hentCelle(rad+1, kolonne+1));
        }
        if(hentCelle(rad+1, kolonne)!=null){
            celle2.leggTilNabo(hentCelle(rad+1, kolonne));
        }
        if(hentCelle(rad+1, kolonne-1)!=null){
            celle2.leggTilNabo(hentCelle(rad+1, kolonne-1));
        }
        if(hentCelle(rad, kolonne-1)!=null){
            celle2.leggTilNabo(hentCelle(rad, kolonne-1));
        }


    }
    //kobler alle celler med settNaboer
    public void kobleAlleCeller(){
        for(int radTeller2=0; radTeller2<antRader; radTeller2++){
            for (int kolTeller2=0; kolTeller2<antKolonner; kolTeller2++){
                 settNaboer(radTeller2, kolTeller2);
            }

        }
    }
    //teller antall levende 
    public int antallLevende(){
        int antallLevende=0;
        for (int rad1=0; rad1<antRader; rad1++){
            for (int kol1=0; kol1<antKolonner;kol1++){
                Celle celle3=hentCelle(rad1,kol1);
                if(celle3 !=null &&celle3.erLevende()){
                    antallLevende++;
                }
            }

        }return antallLevende;

    }
  

    
}

}
