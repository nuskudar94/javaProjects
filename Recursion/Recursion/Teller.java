public class Teller {   

    public static void tellOpp(int tall,int grense){
        
        if(tall>=grense){
            System.out.println(tall+ ": basis tilfelle");;
        }else{
            System.out.println(tall + ": rekursivt kall");
            tellOpp(tall+1, grense);
        }

    }
    public static void main(String[] args) {
        tellOpp(11,10);
    }
}
