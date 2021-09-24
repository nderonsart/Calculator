/** 
 * Classe qui prend en charge la construction de la chaîne qui sera affichée dans la zone de texte, et crée le BigDecimal du nombre en cours d'écriture.
 * @author Nicolas Deronsart
*/

package calculette;

import java.math.BigDecimal;


public class Afficheur {

    StringBuffer representation;
    BigDecimal valeur;

    boolean vide;

    boolean point;
    int nbChiffreApresPoint;

    boolean resAff;

    boolean signePremierNombreAff;


    /**
     * Constructeur de la classe Afficheur qui initialise toutes les valeurs.
    */
    public Afficheur(){
        this.reinit();
    }

    /**
     * Reinitialise les valeurs de l'afficheur.
    */
    public void reinit(){
        this.valeur = new BigDecimal(0);

        this.representation = new StringBuffer(100);
        this.representation.append("0");
        
        this.vide = true;

        this.point = false;
        this.nbChiffreApresPoint = 0;
        
        resAff = false;

        signePremierNombreAff = false;
    }


    /**
     * Ajoute un chiffre à la valeur contenue par l'afficheur.
     * Compte le nombre de chiffres après le point si un point a été entré.
     * @param c le chiffre à ajouter.
    */
    public void ajouteChiffre(int c){
        if (!resAff){
            if (vide) representation.deleteCharAt(0);
            representation.append(c);
            
            if (vide){
                valeur=valeur.add(BigDecimal.valueOf(c));
                vide=false;
            }
            else{
                valeur=valeur.multiply(BigDecimal.TEN);
                valeur=valeur.add(BigDecimal.valueOf(c));
            }
    
            if (point) nbChiffreApresPoint++;
        }
    }
    
    /**
     * Ajoute un opérateur à la chaîne de caractère contenue dans l'afficheur et met la valeur en cours d'écriture à 0.
     * @param c le chiffre à ajouter.
    */
    public void ajouteOperateur(String opNom){
        if (!resAff){
            if (vide) representation.deleteCharAt(0);
            representation.append(opNom);
    
            valeur=BigDecimal.ZERO;
    
            point=false;
            nbChiffreApresPoint=0;
    
            vide=false;
        }
    }
    
    /**
     * Ajoute un = et le resultat du calcul à la chaîne de caractère contenue dans l'afficheur.
     * @param res le résultat du calcul.
    */
    public void ajouteEgal(BigDecimal res){
        if (!resAff){
            representation.append("="+res);
            valeur=res;
    
            resAff=true;
            signePremierNombreAff=false;
        }
    }

    /**
     * Indique à l'afficheur qu'un point a été saisi.
    */
    public void ajoutePoint(){
        if (!resAff){
            if (!point) representation.append(".");
            point=true;
        }
    }


    /**
     * Accesseur pour la valeur numérique contenue dans l'afficheur.
     * @return la valeur contenue dans l'afficheur.
    */
    public BigDecimal getValeur(){
        if (point) return valeur.divide(BigDecimal.TEN.pow(nbChiffreApresPoint));
        return valeur;
    }

    /**
     * Retourne sous forme de chaîne de caractère la formule entrée par l'utilisateur jusqu'à présent.
     * @return la chaîne de caractère représentant la formule entrée dans l'afficheur.
    */
    public String toString(){
        return representation.toString();
    }


    /**
     * Indique à l'afficheur un message d'erreur à afficher.
     * @param message le message à afficher.
    */
    public void indiqueErreur(String message){
        representation.delete(0, representation.length());
        representation.append(message);

        resAff=true;
    }


    /**
     * Enlève le dernier chiffre ajouté à la chaîne de caractère ainsi qu'à la valeur actuellement en construction.
    */
    public void enleverChiffre(){
        if (!resAff){
            Character dernierCar=representation.charAt(representation.length()-1);
    
            if (Character.isDigit(dernierCar)){
                BigDecimal dernierChiffre=new BigDecimal(String.valueOf(dernierCar));
        
                representation.deleteCharAt(representation.length()-1);
            
                valeur=valeur.subtract(dernierChiffre);
                valeur=valeur.divide(BigDecimal.TEN);
            }
        }
    }

    /**
     * Change le signe de la valeur actuellement tapée ainsi que l'affichage de la formule calculée.
    */
    public void changerSigne(){
        if (!resAff){
            int tailleNombreActuel=0;
            BigDecimal copie=valeur.abs();
            while (copie.compareTo(BigDecimal.ONE)>=0){
                copie=copie.divide(BigDecimal.TEN);
                tailleNombreActuel++;
            }
    
            valeur=valeur.negate();
    
            if (representation.length()-1-tailleNombreActuel>=0){
                if (Character.toString(representation.charAt(representation.length()-1-tailleNombreActuel)).equals("+")) 
                    representation.replace(representation.length()-1-tailleNombreActuel, representation.length()-tailleNombreActuel, "-");
                else if (Character.toString(representation.charAt(representation.length()-1-tailleNombreActuel)).equals("-"))
                    representation.replace(representation.length()-1-tailleNombreActuel, representation.length()-tailleNombreActuel, "+");
                else{
                    if (valeur.compareTo(BigDecimal.ZERO)<0) representation.insert(representation.length()-tailleNombreActuel, "-");
                    else representation.insert(representation.length()-tailleNombreActuel, "+");
                }
            }
            else{
                if (!signePremierNombreAff){
                    if (valeur.compareTo(BigDecimal.ZERO)<0) representation.insert(0, "-");
                    else representation.insert(0, "+");
                    signePremierNombreAff=true;
                }
                else{
                    if (valeur.compareTo(BigDecimal.ZERO)<0) representation.replace(0, 1, "-");
                    else representation.replace(0, 1, "+");
                }
            }

        }
    }

}
