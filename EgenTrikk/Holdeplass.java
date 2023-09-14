public class Holdeplass{
    private String navn;
    public Holdeplass neste;
    public Holdeplass forrige;

    public Holdeplass(String navn){
        this.navn = navn;


    }

    public String hentNavn(){
        return navn;
    }

    @Override
    public String toString(){
        return "Holdeplass : " + navn;
    }
}