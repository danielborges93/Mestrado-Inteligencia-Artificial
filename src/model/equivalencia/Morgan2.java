package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class Morgan2 extends Equivalencia {

    /**
     * As duas partes com duas variáveis.
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    /**
     * As primeira parte com duas variáveis.
     */
    private final String padraoPosfixa3;
    private final String substituicaoPosfixa3;

    /**
     * As segunda parte com duas variáveis.
     */
    private final String padraoPosfixa4;
    private final String substituicaoPosfixa4;

    public Morgan2() {
	nome = "De Morgan";
	
//	padrao = "¬[(]([A-Z])v([A-Z])[)]";
//	substituicao = "(¬$1v¬$2)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v¬";
	substituicaoPosfixa = "$1¬$2¬^";
	
	padraoPosfixa2 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v¬";
	substituicaoPosfixa2 = "$1$2$3¬$4$5$6¬^";
	
	padraoPosfixa3 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)v¬";
	substituicaoPosfixa3 = "$1$2$3¬$4¬^";
	
	padraoPosfixa4 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v¬";
	substituicaoPosfixa4 = "$1¬$2$3$4¬^";
	
	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
	this.padroesPosfixos.put(padraoPosfixa2, substituicaoPosfixa2);
	this.padroesPosfixos.put(padraoPosfixa3, substituicaoPosfixa3);
	this.padroesPosfixos.put(padraoPosfixa4, substituicaoPosfixa4);
    }
    
}
