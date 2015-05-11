package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class AssociatividadeOU extends Equivalencia {

    public AssociatividadeOU() {
	padrao = "[(]([A-Z])v([A-Z])[)]v([A-Z])";
	substituicao = "$1v($2v$3)";
    }
    
}
