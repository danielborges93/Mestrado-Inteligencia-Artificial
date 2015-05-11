package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class ComutatividadeOU extends Equivalencia {

    public ComutatividadeOU() {
	padrao = "[(]([A-Z])v([A-Z])[)]";
	substituicao = "($2v$1)";
    }

}
