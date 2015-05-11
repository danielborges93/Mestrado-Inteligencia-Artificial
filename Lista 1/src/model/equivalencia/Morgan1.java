package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class Morgan1 extends Equivalencia {

    public Morgan1() {
	padrao = "¬[(]([A-Z])\\^([A-Z])[)]";
	substituicao = "(¬$1^¬$2)";
    }
    
}
