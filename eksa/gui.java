import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MinesweeperView {
    private MinesweeperController kontroll;
    private int rader, kolonner;

    private JFrame vindu;
    private JPanel panelRutenett;
    private JPanel panelInfo;
    private JLabel tekstPoeng;

    public MinesweeperView(MinesweeperController kontroll, int antRader, int antKolonner){
        this.kontroll = kontroll;
        rader = antRader;
        kolonner = antKolonner;

        try { // valgfritt å ha med
           UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { System.exit(1); }

        vindu = new JFrame("Minesweeper (Plenum)");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setLayout(new BorderLayout());
        //vindu.setSize(800, 600);

        leggTilInfo();
        leggTilKnapper();

        vindu.pack();
        vindu.setVisible(true);
    }

    public void oppdaterPoeng() {
        tekstPoeng.setText("Poeng: "+ kontroll.hentAntallPoeng());
    }

    public void leggTilInfo(){
        panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(1, 4));

        JLabel tekstBomber = new JLabel("Bomber: " + kontroll.antallBomber());
        tekstBomber.setFont(new Font("Arial", Font.BOLD, 25));
        panelInfo.add(tekstBomber);

    


        tekstPoeng = new JLabel("Poeng: " + kontroll.hentAntallPoeng());
        tekstPoeng.setFont(new Font("Arial", Font.BOLD, 25));
        panelInfo.add(tekstPoeng);

        vindu.add(panelInfo, BorderLayout.NORTH);
    }

    public void leggTilKnapper(){
        panelRutenett = new JPanel();
        panelRutenett.setLayout(new GridLayout(rader, kolonner));

        int[][] rutenett = kontroll.hentRutenett();

        class MinesweeperKnapp extends JButton {
            private int verdi;

            public MinesweeperKnapp(int verdi) {
                super("?"); // fra JButton
                this.verdi = verdi;

                super.addActionListener(new KnappBehandler());
            }

            class KnappBehandler implements ActionListener {
                @Override
                public void actionPerformed(ActionEvent e){
                    if (kontroll.erFerdig) return;

                    // ellers: håndter trykk på knapp
                    setText(""+verdi);
                    kontroll.leggTilPoeng(verdi);
                    
                    if (verdi == 0){
                        setBackground(Color.RED);
                        kontroll.erFerdig = true; // "avslutter spillet"
                    } else {
                        setBackground(Color.GREEN);
                    }
                }
            }
        }

        for (int rad = 0; rad < rader; rad++){
            for (int kol = 0; kol < kolonner; kol++){
                int verdi = rutenett[rad][kol];
                MinesweeperKnapp rutenettKnapp = new MinesweeperKnapp(verdi);
                panelRutenett.add(rutenettKnapp);
            }
        }
        vindu.add(panelRutenett, BorderLayout.CENTER);
    }
}

import java.util.Random;

public class MinesweeperModel {
    private int rader, kolonner;
    private int[][] rutenett;
    private int antallBomber = 0;

    public MinesweeperModel(int antRader, int antKolonner){
        rader = antRader;
        kolonner = antKolonner;

        rutenett = new int[rader][kolonner];
    }

    public int[][] hentRutenett(){
        return rutenett;
    }

    public int antallBomber(){
        return antallBomber;
    }

    public void lagRutenett(){
        Random rand = new Random();
        for (int rad = 0; rad < rader; rad++){
            for (int kol = 0; kol < kolonner; kol++){
                int verdi = rand.nextInt(9);
                rutenett[rad][kol] = verdi;
                
                if (verdi == 0) antallBomber++;
            }
        }
    }
}

public class MinesweeperController {
    private MinesweeperModel model;
    private MinesweeperView view;

    private int antallPoeng = 0;
    public boolean erFerdig = false;

    public MinesweeperController(int antRader, int antKolonner){
        model = new MinesweeperModel(antRader, antKolonner); // håndterer data
        model.lagRutenett();
        
        view = new MinesweeperView(this, antRader, antKolonner); // GUI, det visuelle
    }

    public int hentAntallPoeng(){
        return antallPoeng;
    }

    public void leggTilPoeng(int poeng){
        antallPoeng += poeng;
        view.oppdaterPoeng();
    }

    public int antallBomber(){
        return model.antallBomber();
    }

    public int[][] hentRutenett(){
        return model.hentRutenett();
    }


}

