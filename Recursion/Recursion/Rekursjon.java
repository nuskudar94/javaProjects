

public class Rekursjon {

    public static void main(String[] args) {
      siHei(5);  
    }

    public static void siHei(int antall){
        if(antall== 0) {
            return;
        }
        
        //basis tilfelle

        
        siHei(antall-1);
        System.out.println(antall);
    }
}
