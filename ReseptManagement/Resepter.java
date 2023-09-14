
public abstract class Resepter {

Legemiddel legemiddel;
Lege utskrivendeLege;
Pasient pasientID;
int reit;


    public Resepter(Legemiddel legemiddel,Lege utskrivendeLege,Pasient pasientID,int reit){

        this.legemiddel=legemiddel;
        this.utskrivendeLege=utskrivendeLege;
        this.pasientID=pasientID;
        this.reit=reit;


    }

    public int hentId(){
        return this.legemiddel.ID;
    }

    public Legemiddel hentLegemiddel(){
        return this.legemiddel;
    }
    
    public Lege hentLege(){
        return this.utskrivendeLege;
    }

    public Pasient hentPasientId(){
        return this.pasientID;
    }

    public int hentReit(){
        return this.reit;
    }


    
    public boolean bruk(){
        boolean bruk = true;
        if (this.reit > 0){
            this.reit--;
            bruk=true;
        }
        else{
          bruk=false;
        }
    
        return bruk;
    }

    abstract public String farge();
    abstract public int prisAaBetale();

    @Override
    public String toString(){
        return  this.legemiddel + ", Lege: " + this.utskrivendeLege + ", Pasient ID: " + this.pasientID + ", Reit: " + this.reit;
    }
}


