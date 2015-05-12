package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class Morgan2 extends Equivalencia {

    public Morgan2() {
	padrao = "¬[(]([A-Z])v([A-Z])[)]";
	substituicao = "(¬$1v¬$2)";
	
	padraoPosfixa = "([A-Z]|t|f)([A-Z]|t|f)v¬";
	substituicaoPosfixa = "$1¬$2¬^";
    }
    
}
