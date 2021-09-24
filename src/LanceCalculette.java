/**
 * Classe qui lance l'interface graphique de la calculette.
 * @author Nicolas Deronsart
*/

import calculette.MaCalculette;
import vue.VueCalculette;

public class LanceCalculette {
    public static void main(String[] args){

        MaCalculette calculette = new MaCalculette();
        VueCalculette vue = new VueCalculette(calculette);
    }
}
