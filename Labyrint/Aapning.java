//import java.util.ArrayList;

public class Aapning extends HvitRute {
    int radNummer,kolonneNummer;
    //Labyrint labyrint;
    /*
    Rute nord;
    Rute syd;
    Rute vest;
    Rute oest;
    //private boolean besokt = false;
    */
    public Aapning(int radNum,int kolNummer,Labyrint labyrint){
        super(radNum, kolNummer, labyrint);
        
    }
    /* 
    @Override
    protected boolean erSortRute() {
        return false;
    }
    */
    @Override
    public void finn(Rute fra){
        //System.out.println(this.tilTegn() + this.toString());
        this.labyrint.path.add(this);
        return;
        /* 
        //ArrayList<Aapning> path = new ArrayList<>();
        if (this.besokt || erSortRute()) {
            return;
        }

        this.besokt = true;

        // Check if this Aapning is reached
        if (this == fra) {
            // We have found a path to this Aapning, so add it to the list of paths
            // (You need to create the appropriate list or data structure to store the paths)
            
            labyrint.path.add(this); // Assuming paths is a List<Aapning> or similar
        } else {
            // Check each neighbor Rute, except the one we came from
            for (Rute nabo : hentNaboer()) {
                if (nabo != fra) {
                    nabo.finn(this);
                }
            }
        }
        */ 
    }

    @Override
    public char tilTegn(){
        return '.';
    }
}
