
public class MilResept extends HviteResepter {


    public MilResept(Legemiddel legemiddel,Lege utskrivendeLege,int pasientId){
        super(legemiddel,utskrivendeLege,pasientId,3);
        legemiddel.pris=0;
    
    }

    public int prisAaBetale(){
        return legemiddel.hentPris();
    }

    public String farge(){
        return "Hvit";
    }

    
    @Override
    public String toString(){
        return super.toString();
    }

}