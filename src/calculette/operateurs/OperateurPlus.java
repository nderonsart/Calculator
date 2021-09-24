/**
 * Classe implementant la classe abstraite Operateur pour représenter l'opérateur +
 * @author Nicolas Deronsart
*/

package calculette.operateurs;

import calculette.Pile;

import java.math.BigDecimal;


public class OperateurPlus extends Operateur {

    /**
     * Constructeur de la classe OperateurPlus.
    */
    public OperateurPlus(){
        super("+", 1);
    }


    /**
     * Calcule une opération + entre les deux premiers opérandes de la pile.
    */
    public void evaluer(Pile<BigDecimal> lesOperandes){
        if (!lesOperandes.pileVide()){
            BigDecimal res=lesOperandes.depiler();
    
            if (!lesOperandes.pileVide()) res=res.add(lesOperandes.depiler());
    
            lesOperandes.empiler(res);
        }
    }
    
}
