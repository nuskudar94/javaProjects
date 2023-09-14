class Holdeplass{
    private String navn; // data i Node, 
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
        return "Holdeplass : " + navn ;
    }
}