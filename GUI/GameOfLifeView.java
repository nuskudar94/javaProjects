import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOfLifeView {
    private JFrame vindu;
    private JPanel hovedPanel;
    private JPanel indikatorPanel;
    private JPanel cellPanel;
    private JLabel antallLevende;
    private JTextField tekstOmradet;
    private JButton start;
    private JButton avslutt;
    private JButton cellButton;
    private GameOfLifeKontroll kontroll;
    private JButton[][] cellButtons;
    private Timer timer;

    public GameOfLifeView(GameOfLifeKontroll kontroll) {
        this.kontroll = kontroll;
        vindu = new JFrame("Game Of Life");
        vindu.setSize(600, 400);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hovedPanel = new JPanel();
        vindu.add(hovedPanel);
        indikatorPanel = new JPanel();

        hovedPanel.setLayout(new BorderLayout());
        hovedPanel.add(indikatorPanel, BorderLayout.NORTH);

        Font tekstFont = new Font("Arial", Font.PLAIN, 12);
        antallLevende = new JLabel("Antall Levende: ");

        antallLevende.setFont(tekstFont);
        indikatorPanel.add(antallLevende);

        tekstOmradet = new JTextField(null);
        cellButtons = new JButton[20][5];
        tekstOmradet.setPreferredSize(new Dimension(50, 20));
        tekstOmradet.setFont(tekstFont);
        indikatorPanel.add(tekstOmradet);
        start = new JButton("Start");
        start.setFont(tekstFont);

        timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                oppdatering();
            }
        });

        //timer.start();

        class startTrykk implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start.getText().equals("Start")) {
                    start.setText("Stop");
                    kontroll.antallLevde();
                    timer.start();

                    for (int teller = 0; teller < cellButtons.length; teller++) {
                        for (int teller1 = 0; teller1 < cellButtons[teller].length; teller1++) {
                            String verdi = String.valueOf(kontroll.hentStatus(teller, teller1));
                            cellButtons[teller][teller1].setText(verdi);
                        }
                    }
                } else if (start.getText().equals("Stop")) {

                    start.setText("Start");
                    oppdatering();
                    kontroll.antallLevde();
                    timer.stop();
                }
            }
        }

        start.addActionListener(new startTrykk());
        indikatorPanel.add(start);
        avslutt = new JButton("Avslutt");
        avslutt.setFont(tekstFont);

        class avslutt implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                tekstOmradet.setText("0");
                for (int i = 0; i < cellButtons.length; i++) {
                    for (int j = 0; j < cellButtons[i].length; j++) {
                        cellButtons[i][j].setText("");
                    }
                }

            timer.stop();
            }
        }
        avslutt.addActionListener(new avslutt());
        indikatorPanel.add(avslutt);
        cellPanel = new JPanel();
        hovedPanel.add(cellPanel, BorderLayout.CENTER);
        int rader = 20;
        int kol = 5;
        cellPanel.setLayout(new GridLayout(rader, kol));

        for (int teller = 0; teller < rader; teller++) {
            for (int teller2 = 0; teller2 < kol; teller2++) {
                if (String.valueOf(kontroll.hentStatus(teller, teller2)) != null) {
                    String a = String.valueOf(kontroll.hentStatus(teller, teller2));
                    cellButton = new JButton(a);
                } else {
                    cellButton = new JButton();
                }
                cellButtons[teller][teller2] = cellButton;
                cellPanel.add(cellButton);
            }
        }
        vindu.pack();
        vindu.setVisible(true);
    }

    public void hentAntallLevende(int antall) {
        String antallVerdi = String.valueOf(antall);
        tekstOmradet.setText(antallVerdi);
    }

    /*
     * public void oppdatering() {
     * kontroll.oppdatering(20, 5);
     * 
     * }
     */
    public void oppdatering() {
        kontroll.oppdatering(20, 5);
        for (int teller = 0; teller < cellButtons.length; teller++) {
            for (int teller1 = 0; teller1 < cellButtons[teller].length; teller1++) {
                String verdi = String.valueOf(kontroll.hentStatus(teller, teller1));
                cellButtons[teller][teller1].setText(verdi);
            }
        }
        kontroll.antallLevde();
    }

}