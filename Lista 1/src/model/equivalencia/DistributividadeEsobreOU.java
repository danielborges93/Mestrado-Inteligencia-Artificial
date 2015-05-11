package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class DistributividadeEsobreOU extends Equivalencia {

    public DistributividadeEsobreOU() {
	padrao = "([A-Z])\\^[(]([A-Z])v([A-Z])[)]";
	substituicao = "($1^$2)v($1^$3)";
    }
    
}
