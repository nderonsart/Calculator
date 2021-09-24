/**
 * Classe implementant la classe Exception pour signaler le logarithme népérien de 0 ou d'un nombre négatif
 * @author Nicolas Deronsart
*/

package calculette.exceptions;


public class Ln0NegException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Ln0NegException() {
        super("Attention logarithme népérien de 0 ou d'un nombre négatif !");
    }
    
}
