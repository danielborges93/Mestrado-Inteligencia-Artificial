package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class EliminacaoImplicacao extends Equivalencia {

    public EliminacaoImplicacao() {
	nome = "Eliminação da implicação";
	
//	padrao = "([A-Z])>([A-Z])";
//	substituicao = "¬$1v$2";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)>";
	substituicaoPosfixa = "$1¬$2v";
	
	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
    }
    
}
