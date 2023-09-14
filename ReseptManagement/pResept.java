
public class pResept extends HviteResepter {

    public pResept(Legemiddel legemiddel,Lege utskrivendeLege,int pasientId,int reit){
        super(legemiddel,utskrivendeLege,pasientId,reit);
        // legemiddel.pris = legemiddel.pris - 108;
        // if (legemiddel.pris>= 108){
        //     legemiddel.pris = legemiddel.pris - 108;   
        // }
        // else{
        //     legemiddel.pris = 0;
        // }
    }

    public String farge(){
        return "Hvit";
    }

    public int prisAaBetale(){
        if (legemiddel.pris>= 108){
            legemiddel.pris = legemiddel.pris - 108;
            return legemiddel.pris;   
        }
        else{
            return legemiddel.pris;
        }
        
    }

    @Override
    public String toString(){
        return super.toString();
    }
    
    
}
