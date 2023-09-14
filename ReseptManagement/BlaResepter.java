

public class BlaResepter extends Resepter {

    public BlaResepter(Legemiddel legemiddel,Lege utskrivendeLege,int pasientId,int reit){
        super(legemiddel,utskrivendeLege,pasientId,reit);
        

    }

    public String farge(){
        return "Blaa";
    }

    public int prisAaBetale(){
        return Math.round(legemiddel.pris/4);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
