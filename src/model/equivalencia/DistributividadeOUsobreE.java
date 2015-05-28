package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class DistributividadeOUsobreE extends Equivalencia {

    /**
     * Há duas maneiras de representar: Av(B^C) ou (B^C)vA
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    /**
     * Se for di jeito: (B^C)vAvZ
     */
    private final String padraoPosfixa3;
    private final String substituicaoPosfixa3;
    
    /**
     * Com todas as partes com duas variáveis.
     */
    private final String padraoPosfixa4;
    private final String substituicaoPosfixa4;
    
    /**
     * Com todas as partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa5;
    private final String substituicaoPosfixa5;
    
    /**
     * Com a primeira e segunda partes com duas variáveis.
     */
    private final String padraoPosfixa6;
    private final String substituicaoPosfixa6;
    
    /**
     * Com a primeira e segunda partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa7;
    private final String substituicaoPosfixa7;
    
    /**
     * Com a segunda e terceira partes com duas variáveis.
     */
    private final String padraoPosfixa8;
    private final String substituicaoPosfixa8;
    
    /**
     * Com a segunda e terceira partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa9;
    private final String substituicaoPosfixa9;
    
    /**
     * Com a primeira e terceira partes com duas variáveis.
     */
    private final String padraoPosfixa10;
    private final String substituicaoPosfixa10;
    
    /**
     * Com a primeira e terceira partes com duas variáveis ao contrário.
     */
    private final String padraoPosfixa11;
    private final String substituicaoPosfixa11;
    
    /**
     * Com a primeira parte com duas variáveis.
     */
    private final String padraoPosfixa12;
    private final String substituicaoPosfixa12;
    
    /**
     * Com a primeira parte com duas variáveis ao contrário.
     */
    private final String padraoPosfixa13;
    private final String substituicaoPosfixa13;
    
    /**
     * Com a segunda parte com duas variáveis.
     */
    private final String padraoPosfixa14;
    private final String substituicaoPosfixa14;
    
    /**
     * Com a segunda parte com duas variáveis ao contrário.
     */
    private final String padraoPosfixa15;
    private final String substituicaoPosfixa15;
    
    /**
     * Com a terceira parte com duas variáveis.
     */
    private final String padraoPosfixa16;
    private final String substituicaoPosfixa16;
    
    /**
     * Com a terceira parte com duas variáveis ao contrário.
     */
    private final String padraoPosfixa17;
    private final String substituicaoPosfixa17;

    public DistributividadeOUsobreE() {
	nome = "Distributividade de v sobre ^";
	
//	padrao = "([A-Z])v[(]([A-Z])\\^([A-Z])[)]";
//	substituicao = "($1v$2)^($1v$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^v";
	substituicaoPosfixa = "$1$2v$1$3v^";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^(t|f|[A-Z]¬?)v";
	substituicaoPosfixa2 = "$3$1v$3$2v^";
	
	padraoPosfixa3 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)vv";
	substituicaoPosfixa3 = "$3$1v$3$2v^$4v";
	
	padraoPosfixa4 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^v";
	substituicaoPosfixa4 = "$1$2$3$4$5$6v$1$2$3$7$8$9v^";
	
	padraoPosfixa5 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa5 = "$1$2$3$7$8$9v$4$5$6$7$8$9v^";
	
	padraoPosfixa6 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)\\^v";
	substituicaoPosfixa6 = "$1$2$3$4$5$6v$1$2$3$7v^";
	
	padraoPosfixa7 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^"
		+ "([tfA-Z]¬?)v";
	substituicaoPosfixa7 = "$1$2$3$7v$4$5$6$7v^";
	
	padraoPosfixa8 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^v";
	substituicaoPosfixa8 = "$1$2$3$4v$1$5$6$7v^";
	
	padraoPosfixa9 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa9 = "$1$5$6$7v$2$3$4$5$6$7v^";
	
	padraoPosfixa10 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^v";
	substituicaoPosfixa10 = "$1$2$3$4v$1$2$3$5$6$7v^";
	
	padraoPosfixa11 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)\\^"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa11 = "$1$2$3$5$6$7v$4$5$6$7v^";
	
	padraoPosfixa12 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)\\^v";
	substituicaoPosfixa12 = "$1$2$3$4v$1$2$3$5v^";
	
	padraoPosfixa13 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)\\^"
		+ "([tfA-Z]¬?)v";
	substituicaoPosfixa13 = "$1$2$3$5v$4$5v^";
	
	padraoPosfixa14 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)\\^v";
	substituicaoPosfixa14 = "$1$2$3$4v$1$5v^";
	
	padraoPosfixa15 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^"
		+ "([tfA-Z]¬?)v";
	substituicaoPosfixa15 = "$1$5v$2$3$4$5v^";
	
	padraoPosfixa16 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^v";
	substituicaoPosfixa16 = "$1$2v$1$3$4$5v^";
	
	padraoPosfixa17 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)\\^"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa17 = "$1$3$4$5v$2$3$4$5v^";
	
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
	this.padroesPosfixos.put(padraoPosfixa15, substituicaoPosfixa15);
    }
    
}
