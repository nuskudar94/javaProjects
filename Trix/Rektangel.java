class Rektangel{

    double lengden;
    double bredden;
    public Rektangel (double l, double b) {
        this.lengden=l;
        this.bredden=b;
        // Konstruktør
    }
  
    public void oekLengde (int okning) { 
        this.lengden=this.lengden + okning;
        // Oek lengden som angitt
    }
  
    public void oekbredden (int okning) {  
        this.bredden=this.bredden + okning;
        // Oek breddenn som angitt
    }
  
    public double areal () {     // Beregn mitt areal
        return this.lengden*this.bredden;
 
    }
  
    public double omkrets () {   // Beregn min omkrets
        return 2*(this.lengden+this.bredden);

     }

     public void reduserbredden(int reduser){
        if (bredden - reduser < 1){
            System.out.println("breddenn kan ikke reduseres så mye");
        }
        else {
            bredden = bredden - reduser;
        }
    }
    
    public void reduserLengde(int reduser){
        if (lengden - reduser < 1){
            System.out.println("Lengden kan ikke reduseres så mye");
        }
        else {
            lengden = lengden - reduser;
        }
    }
    public static void main(String[] args){
            Rektangel rek1 = new Rektangel(3.0,5.0);
            Rektangel rek2 = new Rektangel(4.0,5.0);

            System.out.println(rek1.areal());
            System.out.println(rek2.areal());
           
           
            rek1.oekbredden(2);
            rek2.oekLengde(3);

            System.out.println(rek1.omkrets());
            System.out.println(rek2.omkrets());




    }
}