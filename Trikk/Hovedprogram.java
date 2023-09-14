import java.util.ArrayList;

public class Hovedprogram {
    public static void main(String[] args) {
        Holdeplass bislett = new Holdeplass("Bislett");

        System.out.println(bislett);

        Trikkelinje linje18 = new Trikkelinje("linje_18.txt");
        Holdeplass forste = linje18.hentForste();
        System.out.println(forste);

        Holdeplass forskningsparken = new Holdeplass("Forskningsparken");
        System.out.println(forskningsparken);

        String rute = linje18.skrivUtRute("Bislett", "Forskningsparken");
        System.out.println(rute);

        int antallStopp = linje18.antallStoppFra(linje18.hentForste(), forskningsparken, 0);
        System.out.println(antallStopp);

        ArrayList<Thread> traader = new ArrayList<>();
        Thread trad = new Thread(new NyTrikk(1,linje18));
        Thread trad2 = new Thread(new GammelTrikk(2,linje18));

        trad.start();
        trad2.start();

        //join() på traader;

        try{
            trad.join();
            trad2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
