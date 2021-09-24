/**
 * Classe implementant la classe abstraite Operateur pour représenter l'opérateur (
 * @author Nicolas Deronsart
*/

package calculette.operateurs;

import calculette.Pile;

import java.math.BigDecimal;


public class OperateurPO extends Operateur {

    /**
     * Constructeur de la classe OperateurPO.
    */
    public OperateurPO(){
        super("(", 0);
    }


    /**
     * Méthode lançant une exception car une opérateur parenthèse ouvrante n'a pas d'évaluation.
    */
    public void evaluer(Pile<BigDecimal> lesOperandes){
        throw new UnsupportedOperationException();
    }
    
}
