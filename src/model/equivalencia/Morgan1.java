package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class Morgan1 extends Equivalencia {

    public Morgan1() {
	nome = "De Morgan";
	
	padrao = "¬[(]([A-Z])\\^([A-Z])[)]";
	substituicao = "(¬$1^¬$2)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^¬";
	substituicaoPosfixa = "$1¬$2¬v";
    }
    
}
