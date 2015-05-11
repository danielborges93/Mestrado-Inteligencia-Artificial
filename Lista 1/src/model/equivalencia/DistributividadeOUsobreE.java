package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class DistributividadeOUsobreE extends Equivalencia {

    public DistributividadeOUsobreE() {
	padrao = "([A-Z])v[(]([A-Z])\\^([A-Z])[)]";
	substituicao = "($1v$2)^($1v$3)";
    }
    
}
