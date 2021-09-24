/**
 * Classe abstraite créant un opérateur
 * @author Nicolas Deronsart
*/

package calculette.operateurs;

import calculette.Pile;
import calculette.exceptions.Div0Exception;

import java.math.BigDecimal;


public abstract class Operateur {
    String nom;

    int priorite;

    /**
     * Constructeur de la classe Operateur.
     * @param nom le nom de l'operateur.
    */
    protected Operateur(String nom, int priorite){
        this.nom=nom;
        this.priorite=priorite;
    }


    public abstract void evaluer(Pile<BigDecimal> lesOperandes);


    /**
     * Indique le nom de l'opérateur.
     * @return le nom.
    */
    public String getNom(){
        return nom;
    }


    /**
     * Indique le niveau de priorité de l'opérateur.
     * @return le niveau de priorité.
    */
    public int getPriorite(){
        return priorite;
    }


    /**
     * Evalue les opérateurs présents sur la pile des opérateurs qui ont une priorité plus grande ou égale à celle de l'opérateur courant.
     * @param lesOperandes la pile des opérandes du calcul en cours.
     * @param lesOperateurs la pile des opérateurs du calcul en cours.
     * @return false si une division par 0 a provoqué une erreur, et true sinon.
    */
    public boolean executer(Pile<BigDecimal> lesOperandes, Pile<Operateur> lesOperateurs){
        while (!lesOperateurs.pileVide() && lesOperateurs.sommet().getPriorite()>=priorite){
            try{
                lesOperateurs.depiler().evaluer(lesOperandes);
            }
            catch (Div0Exception e){
                return false;
            }
        }
        return true;
    }


    
}
