

public class TestResepter {

    public static void main(String[] args){
        
        //Opretter Legemidler
        Narkotisk nar1= new Narkotisk("Drug",20,5.20,2);
        Vanlig vanlig1 = new Vanlig("Vanlig1",30,4.20);
        Vanedannende vane1= new Vanedannende("Vane1",25,2.5,5);
        Narkotisk nar2= new Narkotisk("Drug2",20,5.20,2);
        
        
        //Opretter leger og Spesialister
        Lege lege1= new Lege("Dexter");
        Spesialister spes1 = new Spesialister("Dr.Numan","3456");


        //Opretter Resept Typer
        MilResept resept1 = new MilResept(nar1,lege1,34);
        BlaResepter bla1= new BlaResepter(vanlig1,lege1,2,4);
        pResept pResept1= new pResept(vane1,spes1,35,5);
        Resepter res1 = new BlaResepter(vane1,spes1,45,6);


        
        
        
        
        //Test 
        System.out.println(resept1.toString());
        System.out.println(bla1.toString());

        System.out.println("Res1 har antall reit: "+res1.hentReit());
        System.out.println("pResept1 har antall reit "+pResept1.hentReit());
        res1.bruk();
        System.out.println("res1 har antall reit: " + res1.hentReit());



    }
    
}
