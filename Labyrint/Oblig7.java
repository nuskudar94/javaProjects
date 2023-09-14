import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args) {
         
        if (args.length != 1) {
            System.out.println("Usage: java Main <filename>");
            return;
        }
        
        String fileName = args[0];
        Labyrint labyrint = new Labyrint(fileName);
        System.out.println(labyrint);
        //labyrint.finnUtveiFra(1 ,1);

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        boolean bool=true;
        
        while(bool){
            System.out.println("Skriv inn nye koordinater ('-1' for aa avslutte)");

           String input = sc.nextLine();

           String[] coordinates = input.split(" ");

           int raw = Integer.parseInt(coordinates[0]);
            
           int col = Integer.parseInt(coordinates[1]);

           if(raw == -1){
            bool = false;
           }

           labyrint.finnUtveiFra(raw, col);

        }

        
        
    }
}
