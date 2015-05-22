package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class Contraposicao extends Equivalencia {

    public Contraposicao() {
	nome = "Contraposição";
	
	padrao = "([A-Z])>([A-Z])";
	substituicao = "$1^(¬$2>¬$1)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)>";
	substituicaoPosfixa = "$1$2¬$1¬>^";
    }
    
}
