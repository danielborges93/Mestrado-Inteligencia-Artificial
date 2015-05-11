package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class ComutatividadeE extends Equivalencia {

    public ComutatividadeE() {
	padrao = "[(]([A-Z])\\^([A-Z])[)]";
	substituicao = "($2\\^$1)";
    }

}
