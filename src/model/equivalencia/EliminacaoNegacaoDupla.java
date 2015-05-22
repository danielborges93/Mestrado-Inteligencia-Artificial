package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class EliminacaoNegacaoDupla extends Equivalencia {
    
    /**
     * Existem dois padrões para a negação dupla.
     */
    private final String padrao2;

    /**
     * Construtor.
     */
    public EliminacaoNegacaoDupla() {
	nome = "Eliminação da negação dupla";
	
	padrao = "¬[(]¬([A-Z])[)]";
	padrao2 = "¬¬([A-Z])";
	substituicao = "$1";
	
	padraoPosfixa = "([A-Z]|t|f)¬¬";
	substituicaoPosfixa = "$1";
    }
    
}
