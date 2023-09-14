
public class TestLegemiddel {
    
    

    public static void main(String[] args){

        Narkotisk nar1= new Narkotisk("Drug",20,5.20,2);
        Vanlig vanlig1 = new Vanlig("Vanlig1",30,4.20);
        Vanedannende vane1= new Vanedannende("Vane1",25,2.5,5);
        Narkotisk nar2= new Narkotisk("Drug2",20,5.20,2);


        System.out.println("Vane1 ID er : " + vane1.ID + ", Forventet ID er 2"); //Forventet ID er 2
        System.out.println("Vanlig1 ID er : " +vanlig1.ID+ ", Forventet ID er 1"); //Forventet ID er 1
        System.out.println("Nar1 ID er : " +nar1.ID+ ", Forventet ID er 0");  //Forventet ID er 0, opprettet først
        System.out.println("Nar1 ID er : " +nar2.ID+ ", Forventet ID er 3"); //Forventet ID er 3



    } 
    

    

}
