

public class HviteResepter extends Resepter {
    
    public HviteResepter(Legemiddel legemiddel,Lege utskrivendeLege,int pasientId,int reit){
        super(legemiddel,utskrivendeLege,pasientId,reit);


    }

    public String farge(){
        return "Hvit";
    }

    public int prisAaBetale(){
        return 0;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
