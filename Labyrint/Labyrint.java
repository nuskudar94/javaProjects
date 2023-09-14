import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Labyrint{

    int antallRader;
    int antallKolonner;

    public int getAntallRader() {
        return this.antallRader;
    }

    public void setAntallRader(int antallRader) {
        this.antallRader = antallRader;
    }

    public int getAntallKolonner() {
        return this.antallKolonner;
    }

    public void setAntallKolonner(int antallKolonner) {
        this.antallKolonner = antallKolonner;
    }

    static Rute[][] ruter;
    public ArrayList<Rute> path = new ArrayList<Rute>();
    
    public Labyrint(String fileName){
        
        System.out.println("Slik ser labyrinten ut: ");

        
         try{   
            File fil = new File(fileName);
            Scanner sc = new Scanner(fil);
            String[] firstLine = sc.nextLine().split(" ");
            antallRader = Integer.parseInt(firstLine[0]);
            antallKolonner = Integer.parseInt(firstLine[1]);

            ruter = new Rute[antallRader][antallKolonner];
            for(int i = 0  ; i < antallRader ; i++){
                String linje = sc.nextLine();
                for(int j = 0; j < antallKolonner ; j++ ){
                    char tegn = linje.charAt(j);
                    if(tegn == '#' ){
                        ruter[i][j] = new SortRute(i, j, this);
                    }else {
                        if(i == 0 || i == antallRader - 1 || j == 0 || j == antallKolonner - 1){
                            ruter[i][j] = new Aapning(i, j, this);
                        } else {
                            ruter[i][j] = new HvitRute(i, j, this);
                        }
                    }
                }
            }
            sc.close();
            //set the naboer av hvert rute
            for(int i = 0; i < antallRader; i++){
                for(int j = 0; j < antallKolonner; j++){
                    Rute rute = ruter[i][j];
                    if(rute != null){
                        if(i>0) {
                            rute.setNord(ruter[i-1][j]);
                        }
                        if(i < antallRader - 1){
                            rute.setSyd(ruter[i+1][j]);
                        }
                        if(j>0){
                            rute.setVest(ruter[i][j-1]);
                        }
                        if(j < antallKolonner -1){
                            rute.setOest(ruter[i][j +1]);
                        }
                    }
                }
            }
    
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }
}

public void finnUtveiFra(int rad, int kol) {

    if(rad < 0 || kol < 0 || rad >=ruter.length || kol >= ruter[0].length){
        return;
    }

    Rute startRute = ruter[rad][kol];
    HvitRute hvitRute = (HvitRute) startRute;

    hvitRute.finn();
    System.out.println("Apningene");
    for(Rute a : path){
        //System.out.println("check");
        System.out.println(a.toString());
    }

}


/*
public ArrayList skrivUtveier(ArrayList<Aapning> path) {
    /*     
    for (ArrayList<Rute> utvei : path) {
            for (Rute rute : utvei) {
                System.out.print("(" + rute.getRadNummer() + "," + rute.getKolonneNummer() + ") ");
            }
            System.out.println();
        }
        System.out.println();
    
    return path;
}
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < antallRader; i++) {
            for (int j = 0; j < antallKolonner; j++) {
                sb.append(ruter[i][j].tilTegn());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}