package model.equivalencia;

/**
 *
 * @author danielborges93
 */
public class Morgan2 extends Equivalencia {

    public Morgan2() {
	padrao = "¬[(]([A-Z])v([A-Z])[)]";
	substituicao = "(¬$1v¬$2)";
    }
    
}
