import java.util.Scanner;
import java.io.File;

public class Trikkelinje {
    int linjeNummer;
    String endeHoldeplass;
    Holdeplass forste;
    Holdeplass siste;

    public Trikkelinje(String filNavn){
        lesFraFil(filNavn);

    }

    public void lesFraFil(String filNavn){
        Scanner sc = null;

        try{
            sc = new Scanner(new File(filNavn)); 
        }catch(Exception e){
            //return;
            System.out.println("Kunne ikke lese fra fil");
            System.exit(1);
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

            if(temp != null){
                temp.neste = ny;
                ny.forrige = temp;
            }

            temp = ny;

        }
        siste = temp ;
    }

    public String skrivUtRute(String fra,String til){
        Holdeplass peker = forste; 
        String rute = "";
        //Finne fra objektet
        while(peker != null){
            if(peker.hentNavn().equals(fra)){
                // Finne til objektet
                while(peker !=null){
                    if(peker.hentNavn().equals(til)){
                        return "Fra " + fra + " Til " + rute;
                    }
                    peker =peker.neste;
                    rute += " -> " + peker.hentNavn();

                }
                peker = peker.neste;
            }
        }
        return "Fant ikke";
    }

    public Holdeplass hentForste(){
        return forste;
    }

    public Holdeplass hentSiste(){
        return siste;
    }

    @Override
    public String toString(){
        return "Linjenummer : " + linjeNummer + "Endeholdeplass: " + endeHoldeplass;
    }
    
}
