package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class EliminacaoNegacaoDupla extends Equivalencia {
    
    private final String padrao2;

    public EliminacaoNegacaoDupla() {
	padrao = "¬[(]¬([A-Z])[)]";
	padrao2 = "¬¬([A-Z])";
	substituicao = "$1";
    }
    
}
