
public class Vanedannende extends Legemiddel {
    int styrke;

    public Vanedannende(String navn,int pris,double virkestoff,int styrke){
        super(navn,pris,virkestoff);
        this.styrke=styrke;

    }

    @Override
    public String toString(){

        //return "Navn "  + this.navn + "Pris: " + this.pris + "Virkestoff: " + this.virkestoff + "Styrke: " + this.styrke + "ID: " + this.ID;
        
        return super.toString() + ", Styrke: " + this.styrke;
    }
    
    
}
