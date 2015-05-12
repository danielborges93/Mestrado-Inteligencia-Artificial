package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class Contraposicao extends Equivalencia {

    public Contraposicao() {
	padrao = "([A-Z])>([A-Z])";
	substituicao = "$1^(¬$2>¬$1)";
	
	padraoPosfixa = "([A-Z]|t|f)([A-Z]|t|f)>";
	substituicaoPosfixa = "$1$2¬$1¬>^";
    }
    
}
