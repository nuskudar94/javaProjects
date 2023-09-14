
public class Spesialister extends Lege implements Godkjenningsfritak {
    String kontrollKode;
    public Spesialister(String legeNavn,String kontrollKode){
        super(legeNavn);
        this.kontrollKode=kontrollKode;
    }
    @Override
    public String hentKontrollkode(){
        return this.kontrollKode;
    }

    @Override
    public String toString(){
        return super.toString() + " ,Kontroll Kode: " + this.kontrollKode;
    }
}
