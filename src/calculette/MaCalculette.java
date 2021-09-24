/** 
 * Classe qui implémente une calculatrice.
 * @author Nicolas Deronsart
*/

package calculette;

import calculette.operateurs.*;
import calculette.exceptions.*;

import java.math.BigDecimal;


public class MaCalculette implements ICalculette {

    Afficheur aff = new Afficheur();

    Pile<BigDecimal> pileValeurs = new Pile<>();
    Pile<Operateur> pileOperateurs = new Pile<Operateur>();

    OperateurPlus opPlus = new OperateurPlus();
    OperateurMoins opMoins = new OperateurMoins();
    OperateurMult opMult = new OperateurMult();
    OperateurDiv opDiv = new OperateurDiv();
    OperateurMod opMod = new OperateurMod();
    OperateurPO opPO = new OperateurPO();
    OperateurPF opPF = new OperateurPF();
    OperateurSqrt opSqrt = new OperateurSqrt();
    OperateurLn opLn = new OperateurLn();

    boolean dernierElementChiffre=false;
    boolean dernierElementPF=false;
    boolean dernierElementSqrtLn=false;

    BigDecimal valeurMemoire=new BigDecimal(0);

    String erreurDiv0="Attention division par 0 !";


    @Override
    public String valeur(){
        return aff.toString();
    }
    


    @Override
    public void enfoncerChiffre(int c){
        boolean erreur=false;

        if (dernierElementPF){
            if (!pileOperateurs.pileVide()) pileOperateurs.depiler();
            if (!opMult.executer(pileValeurs, pileOperateurs)){
                aff.indiqueErreur(erreurDiv0);
                erreur=true;
            } 
            pileOperateurs.empiler(opMult);
        }

        if (!erreur) aff.ajouteChiffre(c);

        dernierElementChiffre=true;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerPoint(){
        aff.ajoutePoint();

        dernierElementChiffre=true;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerPO(){
        if (dernierElementChiffre){
            pileValeurs.empiler(aff.getValeur());
            
            if (!opMult.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
            else aff.ajouteOperateur(opPO.getNom());
            pileOperateurs.empiler(opMult);
        }
        else if (dernierElementPF){            
            if (!opMult.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
            else aff.ajouteOperateur(opPO.getNom());
            pileOperateurs.empiler(opMult);
        }
        else aff.ajouteOperateur(opPO.getNom());

        pileOperateurs.empiler(opPO);

        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerPF(){
        boolean erreur=false;

        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());
        
        while (!pileOperateurs.pileVide() && pileOperateurs.sommet().getPriorite()!=0){
            if (!pileOperateurs.sommet().executer(pileValeurs, pileOperateurs)){
                aff.indiqueErreur(erreurDiv0);
                erreur=true;
            } 
        } 

        if (!pileOperateurs.pileVide()) pileOperateurs.depiler();

        if (!erreur) aff.ajouteOperateur(opPF.getNom());

        dernierElementChiffre=false;
        dernierElementPF=true;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerPlus(){
        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());

        if (!opPlus.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
        else aff.ajouteOperateur(opPlus.getNom());

        pileOperateurs.empiler(opPlus);

        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerMoins(){
        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());
        
        if (!opMoins.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
        else aff.ajouteOperateur(opMoins.getNom());
        pileOperateurs.empiler(opMoins);

        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerMult(){
        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());
        
        if (!opMult.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
        else aff.ajouteOperateur(opMult.getNom());
        pileOperateurs.empiler(opMult);

        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerDiv(){
        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());
        
        if (!opDiv.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
        else aff.ajouteOperateur(opDiv.getNom());
        pileOperateurs.empiler(opDiv);

        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerMod(){
        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());
        
        if (!opMod.executer(pileValeurs, pileOperateurs)) aff.indiqueErreur(erreurDiv0);
        else aff.ajouteOperateur(opMod.getNom());
        pileOperateurs.empiler(opMod);

        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerSqrt(){
        if (!dernierElementPF || dernierElementSqrtLn) this.enfoncerPF();
        try{
            opSqrt.evaluer(pileValeurs);
            aff.ajouteOperateur(opSqrt.getNom());
        }
        catch (Sqrt0NegException e){
            aff.indiqueErreur("Attention sqrt(0) ou sqrt(-x) impossible !");
        }

        dernierElementChiffre=false;
        dernierElementPF=true;
        dernierElementSqrtLn=true;
    }
    

    @Override
    public void enfoncerLn(){
        if (!dernierElementPF || dernierElementSqrtLn) this.enfoncerPF();
        try{
            opLn.evaluer(pileValeurs);
            aff.ajouteOperateur(opLn.getNom());
        }
        catch (Ln0NegException e){
            aff.indiqueErreur("Attention ln(0) ou ln(-x) impossible !");
        }

        dernierElementChiffre=false;
        dernierElementPF=true;
        dernierElementSqrtLn=true;
    }
    


    @Override
    public void enfoncerCorr(){
        aff.enleverChiffre();
    }
    

    @Override
    public void enfoncerRaz(){
        this.aff.reinit();

        pileValeurs.reinit();
        pileOperateurs.reinit();
        
        dernierElementChiffre=false;
        dernierElementPF=false;
        dernierElementSqrtLn=false;
    }
    

    @Override
    public void enfoncerEgal(){
        boolean erreur=false;

        if (!dernierElementPF) pileValeurs.empiler(aff.getValeur());
        
        while (!pileOperateurs.pileVide()){
            if (pileOperateurs.sommet().getPriorite()==0) pileOperateurs.depiler();
            if (!pileOperateurs.pileVide() && !pileOperateurs.sommet().executer(pileValeurs, pileOperateurs)){
                aff.indiqueErreur(erreurDiv0);
                erreur=true;
            }
        }

        if (!erreur) aff.ajouteEgal(pileValeurs.depiler());
    }
    

    @Override
    public void enfoncerPlusMoins(){
        if (dernierElementChiffre) aff.changerSigne();
    }
    


    @Override
    public void enfoncerMPlus(){
        valeurMemoire=valeurMemoire.add(aff.getValeur());
    }
    

    @Override
    public void enfoncerMRecup(){
        String representationMemoire=valeurMemoire.toPlainString();

        for (int i=0; i<representationMemoire.length(); i++){
            if (String.valueOf(representationMemoire.charAt(i)).equals(".")) this.enfoncerPoint();
            else this.enfoncerChiffre(Character.getNumericValue(representationMemoire.charAt(i)));
        }
    }
    
    
    @Override
    public void enfoncerMZero(){
        valeurMemoire=BigDecimal.valueOf(0);
    }

}
