import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LegeSystem1 {

    Liste<Pasient> pasientListe=new IndeksertListe<Pasient>();
    Liste<Legemiddel>legemiddel=new IndeksertListe<Legemiddel>();

    
public static void main(String[] args) {
        
       
    
}

    

    public void hentFile(){
        try{
            File myObj=new File("legedata.txt");
            Scanner myleser=new Scanner(myObj);
            String linje=myleser.nextLine();
            while(myleser.hasNextLine()){
                if(linje.contains("# Pasienter")){
                 
                }
                linje=myleser.nextLine();
            }
            myleser.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        }


}
    

