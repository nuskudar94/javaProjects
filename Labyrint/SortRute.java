public class SortRute extends Rute {
    //int radNummer,kolonneNummer;
    //Labyrint labyrint; 
    public SortRute(int radNum,int kolNummer,Labyrint labyrint){
        super(radNum, kolNummer, labyrint);
        
    }

    @Override
    public char tilTegn(){
        return '#';
    }
    @Override
    public void finn(Rute fra){
        // SortRute does not continue the path, so do nothing
        
        return;
    }
    /* 
    @Override
    protected boolean erSortRute() {
        return true;
    }

    @Override
    protected Rute[] hentNaboer() {
        // Return an empty array for SortRute (no neighbors)
        return new Rute[0];
    }
    */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + '#';
    }
    
}
