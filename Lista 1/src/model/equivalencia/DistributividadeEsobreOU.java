package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class DistributividadeEsobreOU extends Equivalencia {

    public DistributividadeEsobreOU() {
	padrao = "([A-Z])\\^[(]([A-Z])v([A-Z])[)]";
	substituicao = "($1^$2)v($1^$3)";
	
	padraoPosfixa = "([A-Z])([A-Z])([A-Z])v\\^";
	substituicaoPosfixa = "$1$2^$1$3^v";
    }
    
}
