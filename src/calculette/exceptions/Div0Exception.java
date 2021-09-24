/**
 * Classe implementant la classe Exception pour signaler une division par 0
 * @author Nicolas Deronsart
*/

package calculette.exceptions;


public class Div0Exception extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Div0Exception() {
        super("Attention division par 0 !");
    }
    
}
