/** 
 * Classe qui implémente une pile d'éléments de type T
 * @author Nicolas Deronsart
*/

package calculette;

import java.util.*;


public class Pile<T> {

    private List<T> pile = new ArrayList<T>();

    
    /**
     * Ajoute un élément au sommet de la pile.
     * @param element l'élément à ajouter.
    */
    public void empiler(T element){
        pile.add(0, element);
    }

    /** 
     * Enlève et retourne l'élément au sommet de la pile.
     * @return l'ancien sommet de la pile.
    */
    public T depiler(){
        return pile.remove(0);
    }

    /** 
     * Retourne l'élément au sommet de la pile.
     * @return le sommet de la pile.
    */
    public T sommet(){
        return pile.get(0);
    }

    /** 
     * Indique si la pile est vide.
     * @return true si la pile est vide, false sinon.
    */
    public boolean pileVide(){
        return pile.isEmpty();
    }

    /** 
     * Réinitialise la pile en la vidant.
    */
    public void reinit(){
        pile.clear();
    }

}
