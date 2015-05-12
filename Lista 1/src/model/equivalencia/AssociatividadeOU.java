package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class AssociatividadeOU extends Equivalencia {

    public AssociatividadeOU() {
	padrao = "[(]([A-Z])v([A-Z])[)]v([A-Z])";
	substituicao = "$1v($2v$3)";
	
	padraoPosfixa = "([A-Z]|t|f)([A-Z]|t|f)v([A-Z]|t|f)v";
	substituicaoPosfixa = "$1$2$3vv";
    }
    
}
