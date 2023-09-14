public class Recursion {
    public static void main(String[] args) {
        skrivTall(5);
    }

    public static void skrivTall(int tall){
        if(tall < 0) return; //basistilfelle
        
        System.out.println(tall);
        skrivTall(tall-1);
    }
}
