/**
 * Classe implementant la classe abstraite Operateur pour représenter l'opérateur racine carrée
 * @author Nicolas Deronsart
*/

package calculette.operateurs;

import calculette.Pile;
import calculette.exceptions.Sqrt0NegException;

import java.math.BigDecimal;


public class OperateurSqrt extends Operateur {

    /**
     * Constructeur de la classe OperateurSqrt.
    */
    public OperateurSqrt(){
        super("sqrt", 3);
    }


    /**
     * Calcule une opération racine carrée sur la premier opérande de la pile.
    */
    public void evaluer(Pile<BigDecimal> lesOperandes){
        if (!lesOperandes.pileVide()){
            if (lesOperandes.sommet().compareTo(BigDecimal.ZERO) <=0) throw new Sqrt0NegException();
            lesOperandes.empiler(BigDecimal.valueOf(Math.sqrt(lesOperandes.depiler().doubleValue())));
        }
    }
    
}
