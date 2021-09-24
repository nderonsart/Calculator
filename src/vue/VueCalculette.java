/**
 * Classe qui crée l'interface graphique de la calculette
 * @author Nicolas Deronsart
*/

package vue;

import calculette.ICalculette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class VueCalculette {

    private ICalculette calculette;

    public VueCalculette(ICalculette calculette){

        int nbLig=7;
        int nbCol=4;

        this.calculette=calculette;


        // Creation de la fenetre du jeu
        JFrame fenetre=new JFrame("Ma Calculatrice");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setBounds(0, 0, 500, 500);

        Container cont = fenetre.getContentPane();


        // BorderLayout principal de fenetre
        BorderLayout border = new BorderLayout();
        cont.setLayout(border);


        // Creation de la zone de texte
        JLabel zoneTexte=new JLabel("0");
        zoneTexte.setFont(new Font("Arial", Font.PLAIN, 30));
        cont.add(zoneTexte, border.NORTH);


        // Creation de la grille de boutons
        JPanel panelGrille = new JPanel();
        panelGrille.setLayout(new GridLayout(nbLig, nbCol));


        String [] tabNoms = {"RAZ", "%", "/", "*", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "=", ".", "0", "(", ")", "Corr", "Sqrt", "Ln", "+/-", "Quit", "M+", "MR", "MZ"};
        
        for (int i=0; i<28; i++){
            JButton bouton =new JButton(tabNoms[i]);

            final int copie=i;
            bouton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        switch (copie){
                            case 0: calculette.enfoncerRaz(); break;
                            case 1: calculette.enfoncerMod(); break;
                            case 2: calculette.enfoncerDiv(); break;
                            case 3: calculette.enfoncerMult(); break;
                            case 7: calculette.enfoncerPlus(); break;
                            case 11: calculette.enfoncerMoins(); break;
                            case 15: calculette.enfoncerEgal(); break;
                            case 16: calculette.enfoncerPoint(); break;
                            case 18: calculette.enfoncerPO(); break;
                            case 19: calculette.enfoncerPF(); break;
                            case 20: calculette.enfoncerCorr(); break;
                            case 21: calculette.enfoncerSqrt(); break;
                            case 22: calculette.enfoncerLn(); break;
                            case 23: calculette.enfoncerPlusMoins(); break;
                            case 24: System.exit(0); break;
                            case 25: calculette.enfoncerMPlus(); break;
                            case 26: calculette.enfoncerMRecup(); break;
                            case 27: calculette.enfoncerMZero(); break;
                            default: calculette.enfoncerChiffre(Integer.parseInt(tabNoms[copie])); break;
                        }
                        
                        if (copie!=24) zoneTexte.setText(calculette.valeur());
                    }
                }
            );

            panelGrille.add(bouton);
        }
        
        
        cont.add(panelGrille, border.CENTER);


        fenetre.setVisible(true);
    }

}
