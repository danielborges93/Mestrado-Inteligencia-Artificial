package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class ComutatividadeOU extends Equivalencia {

    public ComutatividadeOU() {
	nome = "Comutatividade de v";
	
	padrao = "[(]([A-Z])v([A-Z])[)]";
	substituicao = "($2v$1)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v";
	substituicaoPosfixa = "$2$1v";
    }

}
