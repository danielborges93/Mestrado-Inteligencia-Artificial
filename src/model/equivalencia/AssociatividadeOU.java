package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class AssociatividadeOU extends Equivalencia {

    /**
     * As três partes com duas variáveis.
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    /**
     * A segunda e a terceira partes com duas variáveis.
     */
    private final String padraoPosfixa3;
    private final String substituicaoPosfixa3;

    /**
     * A primeira e a terceira partes com duas variáveis.
     */
    private final String padraoPosfixa4;
    private final String substituicaoPosfixa4;

    /**
     * A primeira e a segunda partes com duas variáveis.
     */
    private final String padraoPosfixa5;
    private final String substituicaoPosfixa5;

    /**
     * A terceira parte com duas variáveis.
     */
    private final String padraoPosfixa6;
    private final String substituicaoPosfixa6;
    
    /**
     * A primeira parte com duas variáveis.
     */
    private final String padraoPosfixa7;
    private final String substituicaoPosfixa7;

    /**
     * O contrário da associatividade (contrário da padraoPosfixa).
     */
    private final String padraoPosfixa8;
    private final String substituicaoPosfixa8;

    /**
     * As três partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa9;
    private final String substituicaoPosfixa9;

    /**
     * A segunda e a terceira partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa10;
    private final String substituicaoPosfixa10;

    /**
     * A primeira e a terceira partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa11;
    private final String substituicaoPosfixa11;

    /**
     * A primeira e a segunda partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa12;
    private final String substituicaoPosfixa12;

    /**
     * A terceira parte com duas variáveis ao contrário.
     */
    private final String padraoPosfixa13;
    private final String substituicaoPosfixa13;
    
    /**
     * A primeira parte com duas variáveis ao contrário.
     */
    private final String padraoPosfixa14;
    private final String substituicaoPosfixa14;

    public AssociatividadeOU() {
	nome = "Associatividade de v";
	
//	padrao = "[(]([A-Z])v([A-Z])[)]v([A-Z])";
//	substituicao = "$1v($2v$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)v";
	substituicaoPosfixa = "$1$2$3vv";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa2 = "$1$2$3$4$5$6$7$8$9vv";

	padraoPosfixa3 = "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa3 = "$1$2$3$4$5$6$7vv";

	padraoPosfixa4 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)v"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa4 = "$1$2$3$4$5$6$7vv";

	padraoPosfixa5 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v"
		+ "(t|f|[A-Z]¬?)v";
	substituicaoPosfixa5 = "$1$2$3$4$5$6$7vv";

	padraoPosfixa6 = "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)v"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa6 = "$1$2$3$4$5vv";

	padraoPosfixa7 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)";
	substituicaoPosfixa7 = "$1$2$3$4$5vv";

	padraoPosfixa8 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)vv";
	substituicaoPosfixa8 = "$1$2v$3v";
	
	padraoPosfixa9 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])";
	substituicaoPosfixa9 = "$1$2$3$4$5$6v$7$8$9v";
	
	padraoPosfixa10 = "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])vv";
	substituicaoPosfixa10 = "$1$2$3$4v$5$6$7v";
	
	padraoPosfixa11 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])vv";
	substituicaoPosfixa11 = "$1$2$3$4v$5$6$7v";
	
	padraoPosfixa12 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)vv";
	substituicaoPosfixa12 = "$1$2$3$4$5$6v$7v";
	
	padraoPosfixa13 = "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])vv";
	substituicaoPosfixa13 = "$1$2v$3$4$5v";
	
	padraoPosfixa14 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])"
		+ "(t|f|[A-Z]¬?)"
		+ "(t|f|[A-Z]¬?)vv";
	substituicaoPosfixa14 = "$1$2$3$4v$5v";

	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
	this.padroesPosfixos.put(padraoPosfixa2, substituicaoPosfixa2);
	this.padroesPosfixos.put(padraoPosfixa3, substituicaoPosfixa3);
	this.padroesPosfixos.put(padraoPosfixa4, substituicaoPosfixa4);
	this.padroesPosfixos.put(padraoPosfixa5, substituicaoPosfixa5);
	this.padroesPosfixos.put(padraoPosfixa6, substituicaoPosfixa6);
	this.padroesPosfixos.put(padraoPosfixa7, substituicaoPosfixa7);
	this.padroesPosfixos.put(padraoPosfixa8, substituicaoPosfixa8);
	this.padroesPosfixos.put(padraoPosfixa9, substituicaoPosfixa9);
	this.padroesPosfixos.put(padraoPosfixa10, substituicaoPosfixa10);
	this.padroesPosfixos.put(padraoPosfixa11, substituicaoPosfixa11);
	this.padroesPosfixos.put(padraoPosfixa12, substituicaoPosfixa12);
	this.padroesPosfixos.put(padraoPosfixa13, substituicaoPosfixa13);
	this.padroesPosfixos.put(padraoPosfixa14, substituicaoPosfixa14);
    }
    
}
