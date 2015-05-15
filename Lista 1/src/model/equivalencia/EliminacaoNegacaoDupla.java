package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.questao1.No;

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
	padrao = "¬[(]¬([A-Z])[)]";
	padrao2 = "¬¬([A-Z])";
	substituicao = "$1";
	
	padraoPosfixa = "([A-Z]|t|f)¬¬";
	substituicaoPosfixa = "$1";
    }
    
}
