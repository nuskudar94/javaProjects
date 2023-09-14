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
