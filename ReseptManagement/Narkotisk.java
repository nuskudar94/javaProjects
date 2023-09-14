
public class Narkotisk extends Legemiddel{
    final int styrke;
    //int counter=0;
    public Narkotisk(String navn,int pris,double virkestoff,int styrke){
        super(navn,pris,virkestoff);
        this.styrke=styrke;
        // this.ID=counter;
        // counter++;
    }

    @Override
    public String toString(){

        //return "Navn "  + this.navn + "Pris: " + this.pris + "Virkestoff: " + this.virkestoff + "Styrke: " + this.styrke + "ID: " + this.ID;
        
        return super.toString() + ", Styrke: " + this.styrke;
    }
    
}
