package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class EliminacaoNegacaoDupla extends Equivalencia {
    
    /**
     * Construtor.
     */
    public EliminacaoNegacaoDupla() {
	nome = "Eliminação da negação dupla";
	
//	padrao = "¬[(]¬([A-Z])[)]";
//	padrao2 = "¬¬([A-Z])";
//	substituicao = "$1";
	
	padraoPosfixa = "([A-Z]|t|f)¬¬";
	substituicaoPosfixa = "$1";
	
	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
    }
    
}
