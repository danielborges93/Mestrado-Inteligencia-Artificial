package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class AssociatividadeE extends Equivalencia {

    public AssociatividadeE() {
	padrao = "[(]([A-Z])\\^([A-Z])[)]\\^([A-Z])";
	substituicao = "$1^($2^$3)";
    }
    
}
