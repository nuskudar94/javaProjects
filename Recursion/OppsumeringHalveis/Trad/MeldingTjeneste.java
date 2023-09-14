package OppsumeringHalveis.Trad;

import java.util.ArrayList;

public class MeldingsTjeneste {
    ArrayList<String> meldinger = new ArrayList<>();

    public void leggTilMelding(String s){
        meldinger.add(s);
    }

    public String hentMelding(){
        return meldinger.remove(0);
    }

    public int hentAntMeldinger(){
        return meldinger.size();
    }

}
