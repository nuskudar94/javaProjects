import java.util.Scanner;
import java.io.File;

public class Trikkelinje {

    private int linjeNummer;
    private String endeHoldeplass;
    private Holdeplass forste;
    private Holdeplass siste;

    public Trikkelinje(String filNavn){
        lesFraFil(filNavn);
    }
    
    public void lesFraFil(String filNavn){
        Scanner sc= null ;

        try{
            sc = new Scanner(new File(filNavn));
        }catch(Exception e){
            return;
            //System.out.println("Kunne ikke lese fra fil");
            //System.exit(1); //avslutte programmet
        }

        String[] info = sc.nextLine().split(";");
        linjeNummer = Integer.parseInt(info[0]);
        endeHoldeplass = info[1];

        Holdeplass temp = null;

        while(sc.hasNextLine()){
            String navn = sc.nextLine();
            Holdeplass ny = new Holdeplass(navn);

            if(forste == null){
                forste = ny;
            }
        
            if(temp != null ){
                temp.neste = ny;
                ny.forrige = temp;
            }

            temp = ny;


        }
        siste = temp ; // etter while løkke
    }

public String skrivUtRute(String fra, String til){
    // navn fra , navn til
    String rute = "";

    Holdeplass peker = forste;
    int antall = 0;
    //finne fra Holdeplass
    while(peker != null){
        if(peker.hentNavn().equals(fra)){

            while(peker != null){
                //finne til Holdeplass
                if (peker.hentNavn().equals(til)){
                    return "Fra " + fra + "(" + antall +" stopp ): " + rute;
                }
                peker = peker.neste;
                rute += " -> " + peker.hentNavn();
                antall++;
            }
        }
        peker = peker.neste;
    }
    return "Fant ikke ";
}

    public int antallStoppFra(Holdeplass fra, Holdeplass til,int antall){
        if(fra == null){ //slutten
            return antall;
        }
        if(fra.hentNavn().equals(til.hentNavn())){
            return antall;
        }
        return antallStoppFra(fra.neste, til, antall+1);
    }

    public Holdeplass hentHoldeplass(String navn){
            Holdeplass peker = forste;  //med siste baklengs

            while(peker != null){

                if(peker.hentNavn().equals(navn)){
                    return peker; // Holdeplass objekt
                }
                peker = peker.neste; // . temp
            }

            return null; // fant ikke Holdeplass
    }



    public void settForste(Holdeplass holdeplass){
        forste = holdeplass;
    }

    public Holdeplass hentForste(){
        return forste;
    }
}
