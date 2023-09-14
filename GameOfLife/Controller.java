//import javax.swing.text.View;

public class Controller {

    //Model object
    private Model model;

    //View object
    private View view; 

    //COntroller constructor
    public Controller(int antRader, int antKolonner){
        model = new Model(antRader, antKolonner);
        model.lagRutenett();

        view = new View(this);

    }

    public void hentRutenett(){
        model.lagRutenett();
    }
    
    public int antallLevende(){
        return model.antallLevendeiModel();
    }

    public void oppdatering(int rad,int kol){
        model.oppdatering(rad,kol);
    }

    public char hentStatus(int rad,int kol){
        return model.hentStatus(rad,kol);
    }
}
