package Me;

public class Hoved {
    public static void main(String[] args) {
        Menneske jonas = new Menneske(30, "Jonas");

        Menneske mamma = new Menneske(62, "mamma");
        Menneske pappa = new Menneske(69, "pappa");

        Menneske farmor = new Menneske(85, "farmor");


        jonas.settMor(mamma);
        jonas.settFar(pappa);

        pappa.settMor(farmor);
        Menneske oldemor = new Menneske(89, "oldemor");
        farmor.settMor(oldemor);

        String familieTre = jonas.hentFamilieTre();
        System.out.println(familieTre);

        System.out.println("");

        pappa.finnRelasjon(farmor); //mor

        jonas.finnRelasjon(jonas);

        Menneske eldste = jonas.finnEldsteIFamilieTre();
        System.out.println(eldste);
    }
}
