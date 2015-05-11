package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class EliminacaoImplicacao extends Equivalencia {

    public EliminacaoImplicacao() {
	padrao = "([A-Z])>([A-Z])";
	substituicao = "¬$1v$2";
    }
    
}
