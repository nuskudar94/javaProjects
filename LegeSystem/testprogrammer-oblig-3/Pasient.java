import java.util.ArrayList;
public class Pasient {
    String navn;
    String foedselsNummer;
    public final int ID;
    private static int counter=0; 
    
    public Pasient(String n,String fN){
        //super(legemiddel, utskrivendeLege, pasientId, reit);
        this.navn=n;
        this.foedselsNummer=fN;
        this.ID=counter;
        counter++;
        Stabel<Resepter> pasientResepterList = new Stabel<Resepter>();
        //ArrayList<Resepter> resepterList = new ArrayList<Resepter>();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
