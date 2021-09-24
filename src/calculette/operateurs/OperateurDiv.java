/**
 * Classe implementant la classe abstraite Operateur pour représenter l'opérateur /
 * @author Nicolas Deronsart
*/

package calculette.operateurs;

import calculette.Pile;
import calculette.exceptions.Div0Exception;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class OperateurDiv extends Operateur {

    /**
     * Constructeur de la classe OperateurDiv.
    */
    public OperateurDiv(){
        super("/", 2);
    }


    /**
     * Calcule une opération / entre les deux premiers opérandes de la pile.
    */
    public void evaluer(Pile<BigDecimal> lesOperandes){
        if (!lesOperandes.pileVide()){
            BigDecimal res=lesOperandes.depiler();
    
            if (!lesOperandes.pileVide()){
                if (res.compareTo(BigDecimal.ZERO)==0) throw new Div0Exception();
                res=lesOperandes.depiler().divide(res, 15, RoundingMode.HALF_UP);
            }
            else res=BigDecimal.ZERO;
    
            lesOperandes.empiler(res);
        }
    }
    
}
