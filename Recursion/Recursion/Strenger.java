public class Strenger {

    public static String Reverser(String s){

        if(s.length() == 1){
            return s;
        }else{
            return s.charAt(s.length()-1) + Reverser(s.substring(0, s.length() - 1)); //last index "r" + "Reverse" 
        }

    }

    public static void main(String[] args) {
        String s = Reverser("Reverser");
        System.out.println(s);
    }   
}
