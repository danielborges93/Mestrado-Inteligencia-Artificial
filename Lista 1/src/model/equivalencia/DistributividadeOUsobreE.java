package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class DistributividadeOUsobreE extends Equivalencia {

    public DistributividadeOUsobreE() {
	padrao = "([A-Z])v[(]([A-Z])\\^([A-Z])[)]";
	substituicao = "($1v$2)^($1v$3)";
	
	padraoPosfixa = "([A-Z]|t|f)([A-Z]|t|f)([A-Z]|t|f)\\^v";
	substituicaoPosfixa = "$1$2v$1$3v^";
    }
    
}
