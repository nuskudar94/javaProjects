package Labyrint;

import java.util.ArrayList;

public class HvitRute extends Rute {
    int radNummer,kolonneNummer;
    //Labyrint labyrint;
    /* 
    Rute nord;
    Rute syd;
    Rute vest;
    Rute oest;
    */
    //String hviteRute;
    public  static ArrayList<Rute> besokt;
    public HvitRute(int radNum,int kolNummer,Labyrint labyrint){
        super(radNum, kolNummer, labyrint);
        besokt=new ArrayList<Rute>();
    }
    @Override
    public char tilTegn(){
        return '.';
    }
    /* 
    @Override
    protected boolean erSortRute() {
        return false;
    }
    
    @Override
    protected Rute[] hentNaboer() {
        // Return an array of all neighboring Rute objects
        return new Rute[] { this.nord, this.syd, this.vest, this.oest };
    }
    */
    public void finn(){
        this.finn(this);
    }

    @Override
    public void finn(Rute fra){
        if (!besokt.contains(this)) {
            besokt.add(this);
        
        }else{
            return;
        }

  
        
        /* 
        // Check each neighbor Rute, except the one we came from
        for (Rute nabo : hentNaboer()) {
            if (nabo != fra) {
                nabo.finn(this);
            }
        }
        */
        if(getNord() != null){
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
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + '.' ;
    }
}
