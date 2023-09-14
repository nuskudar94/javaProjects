
public abstract class Legemiddel {

    final String navn;
    int pris;
    final double virkestoff;
    final int ID;
    private static int counter=0;
    public Legemiddel(String navn,int pris,double virkestoff){
        this.navn=navn;
        this.pris=pris;
        this.virkestoff=virkestoff;
        this.ID=counter;
        counter++;
        
    }

    public int hentPris(){
        return this.pris;
    }

    public void settNyPris(int pris){
        this.pris=pris;
    }

    // public abstract int settID(){

    // }
    @Override
    public  String toString(){
         return " Navn: "  + this.navn + ", Pris: " + this.pris + ", Virkestoff: " + this.virkestoff + ", ID: " + this.ID;

    }

}
