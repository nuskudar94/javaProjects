
public class Hoved {
    public static void main(String[] args){
        Narkotisk nar1= new Narkotisk("Drug",20,5.20,2);
        Vanlig vanlig1 = new Vanlig("Vanlig1",30,4.20);
        Vanedannende vane1= new Vanedannende("Vane1",25,2.5,5);
        Narkotisk nar2= new Narkotisk("Drug2",20,5.20,2);
        
        //Opretter leger og Spesialister
        Lege lege1= new Lege("Dexter");
        Spesialister spes1 = new Spesialister("Dr.Numan","3456");


        //Opretter resepter
        BlaResepter blaa1= new BlaResepter(nar1,spes1,34,1);
        MilResept  milResept1 = new MilResept(nar2,lege1,34);
        pResept pResept1 = new pResept(vane1,spes1,54,2);
        
        HviteResepter pResept2 = new pResept(vane1,lege1,45,3);// har tilgang til hviteresepter sine metoder , men ikke pResept

        System.out.println(nar1.toString());
        System.out.println(vanlig1.toString());
        System.out.println(vane1.toString());
        System.out.println(nar2.toString());
        System.out.println(lege1.toString());
        System.out.println(spes1.toString());
        System.out.println(blaa1.toString());
        System.out.println(milResept1.toString());
        System.out.println(pResept1.toString());

        

        //System.out.println(spes1.hentKontrollkode().equals("3456"));
        System.out.println(spes1.hentKontrollkode().equals("3456"));

        //assertEquals()
        
        
        
        
        
    }
}
