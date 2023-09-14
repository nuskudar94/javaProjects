
public class Vanlig extends Legemiddel{
    
    

    public Vanlig(String navn,int pris,double virkestoff){
        super(navn,pris,virkestoff);
        

    }

    @Override
    public  String toString(){
         //return "Navn "  + this.navn + "Pris: " + this.pris + "Virkestoff: " + this.virkestoff + "ID: " + this.ID;

         return super.toString();
    }
    
}
