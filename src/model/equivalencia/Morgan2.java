package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class Morgan2 extends Equivalencia {

    public Morgan2() {
	nome = "De Morgan";
	
//	padrao = "¬[(]([A-Z])v([A-Z])[)]";
//	substituicao = "(¬$1v¬$2)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v¬";
	substituicaoPosfixa = "$1¬$2¬^";
	
	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
    }
    
}
