/** 
 * Interface à implémenter pour créer la calculatrice.
 * @author Nicolas Deronsart
*/

package calculette;


public interface ICalculette {

    /**
     * Retourne la chaîne de caractère représentant l'expression contenue dans l'afficheur de la calculatrice.
     * @return la chaîne de caractère représentant l'expression actuelle.
    */
    public String valeur();
    
    /**
     * Ajoute un chiffre à l'afficheur de la calculatrice.
     * @param c le chiffre à ajouter à l'afficheur.
    */
    public void enfoncerChiffre(int c);
    
    /**
     * Indique à l'afficheur de la calculatrice qu'il faut ajouter un point.
    */
    public void enfoncerPoint();
    
    /**
     * Indique à la calculatrice qu'une parenthèse ouverte a été sélectionnée.
    */
    public void enfoncerPO();
    
    /**
     * Indique à la calculatrice qu'une parenthèse fermée a été sélectionnée.
    */
    public void enfoncerPF();
    
    /**
     * Indique à la calculatrice qu'un plus a été sélectionné.
    */
    public void enfoncerPlus();
    
    /**
     * Indique à la calculatrice qu'un moins a été sélectionné.
    */
    public void enfoncerMoins();

    /**
     * Indique à la calculatrice qu'un fois a été sélectionné.
    */
    public void enfoncerMult();
    
    /**
     * Indique à la calculatrice qu'une division a été sélectionnée.
    */
    public void enfoncerDiv();
    
    /**
     * Indique à la calculatrice qu'un modulo a été sélectionné.
    */
    public void enfoncerMod();
    
    /**
     * Indique à la calculatrice qu'une racine a été sélectionnée.
    */
    public void enfoncerSqrt();
    
    /**
     * Indique à la calculatrice qu'un Logarithme népérien a été sélectionné.
    */
    public void enfoncerLn();
    
    /**
     * Efface le dernier chiffre saisi par l'utilisateur.
    */
    public void enfoncerCorr();
    
    /**
     * Remet à 0 l'afficheur de la calculatrice.
    */
    public void enfoncerRaz();
    
    /**
     * Indique à la calculatrice qu'un égal a été sélectionné.
    */
    public void enfoncerEgal();
    
    /**
     * Change le signe du nombre actuellement tapé.
    */
    public void enfoncerPlusMoins();
    
    /**
     * Additionne le nombre tapé actuellement à celui de la mémoire, et le stocke en mémoire.
    */
    public void enfoncerMPlus();
    
    /**
     * Récupère le nombre dans la mémoire pour l'afficher à l'écran et l'ajouter à la formule.
    */
    public void enfoncerMRecup();
    
    /**
     * Met la valeur mémoire à 0.
    */
    public void enfoncerMZero();
}