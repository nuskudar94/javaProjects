import java.util.ArrayList;

public abstract class Rute {
    int radNummer;
    int kolonneNummer;

    
    Rute[][] ruter;
    Labyrint labyrint;
    Rute nord;
    Rute syd;
    Rute vest;
    Rute oest;
   // private boolean besokt = false;
    private ArrayList<Rute> besokt=new ArrayList<Rute>();;

    
    public Rute(int radNum,int kolNummer,Labyrint labyrint){
        

        this.radNummer=radNum;
        this.kolonneNummer=kolNummer;
        this.labyrint=labyrint;
        
        
    }

    public void finn(){
        this.finn(this);
    }
    public void finn(Rute fra){
        // Base case: If the current Rute has already been visited or is a SortRute, return
        if (!besokt.contains(this)) {
            besokt.add(this);
        
        }else{
            return;
        }

        if(fra.getNord() != null && fra.getNord().tilTegn() == '.'){
            getNord().finn(this);
        }
        if(getVest() != null){
            getVest().finn(this);
        }
        if(getSyd() != null){
            getSyd().finn(this);
        }
        if(getOest() != null){
            getOest().finn(this);
        }
        // Mark the current Rute as visited
        //this.besokt = true;

        // Check each neighbor Rute, except the one we came from
        /* 
        for (Rute nabo : hentNaboer()) {
            if (nabo != fra) {
                nabo.finn(this);
            }
        }
        */
    }
    //protected abstract boolean erSortRute();

    //protected abstract Rute[] hentNaboer();

    public abstract char tilTegn();

    public Rute getNord() {
        return this.nord;
    }

    public void setNord(Rute nord) {
        this.nord = nord;
    }

    public Rute getSyd() {
        return this.syd;
    }

    public void setSyd(Rute syd) {
        this.syd = syd;
    }

    public Rute getVest() {
        return this.vest;
    }

    public void setVest(Rute vest) {
        this.vest = vest;
    }

    public Rute getOest() {
        return this.oest;
    }

    public void setOest(Rute oest) {
        this.oest = oest;
    }

    public int getRadNummer() {
        return this.radNummer;
    }

    public void setRadNummer(int radNummer) {
        this.radNummer = radNummer;
    }

    public int getKolonneNummer() {
        return this.kolonneNummer;
    }

    public void setKolonneNummer(int kolonneNummer) {
        this.kolonneNummer = kolonneNummer;
    }
   
    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder();
        for (int i = 0; i < radNummer; i++) {
            for (int j = 0; j < kolonneNummer; j++) {
                sb.append(ruter[i][j].tilTegn());
            }
            sb.append("\n");
        }
        return sb.toString();
        */
        return String.valueOf(radNummer) + " " + String.valueOf(kolonneNummer);
    }
    
}
