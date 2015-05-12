package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class ComutatividadeOU extends Equivalencia {

    public ComutatividadeOU() {
	padrao = "[(]([A-Z])v([A-Z])[)]";
	substituicao = "($2v$1)";
	
	padraoPosfixa = "([A-Z]|t|f)([A-Z]|t|f)v";
	substituicaoPosfixa = "$2$1v";
    }

}
