/**
 * Classe implementant la classe Exception pour signaler la racine carrée de 0 ou d'un nombre négatif
 * @author Nicolas Deronsart
*/

package calculette.exceptions;


public class Sqrt0NegException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Sqrt0NegException() {
        super("Attention racine de 0 ou d'un nombre négatif !");
    }
    
}
