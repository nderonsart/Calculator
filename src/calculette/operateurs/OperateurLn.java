/**
 * Classe implementant la classe abstraite Operateur pour représenter l'opérateur logarithme népérien
 * @author Nicolas Deronsart
*/

package calculette.operateurs;

import calculette.Pile;
import calculette.exceptions.Ln0NegException;

import java.math.BigDecimal;


public class OperateurLn extends Operateur {

    /**
     * Constructeur de la classe OperateurLn.
    */
    public OperateurLn(){
        super("Ln", 3);
    }


    /**
     * Calcule une opération logarithme népérien sur la premier opérande de la pile.
    */
    public void evaluer(Pile<BigDecimal> lesOperandes){
        if (!lesOperandes.pileVide()){
            if (lesOperandes.sommet().compareTo(BigDecimal.ZERO) <= 0) throw new Ln0NegException();
            lesOperandes.empiler(BigDecimal.valueOf(Math.log(lesOperandes.depiler().doubleValue())));
        }
    }
    
}
