package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class DistributividadeEsobreOU extends Equivalencia {
    
    /**
     * Há duas maneiras de representar: A^(BvC) ou (BvC)^A.
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;
    
    /**
     * Se for algo assim: (CvD)^A^B.
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

    public DistributividadeEsobreOU() {
	nome = "Distributividade de ^ sobre v";
	
//	padrao = "([A-Z])\\^[(]([A-Z])v([A-Z])[)]";
//	substituicao = "($1^$2)v($1^$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v\\^";
	substituicaoPosfixa = "$1$2^$1$3^v";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)\\^";
	substituicaoPosfixa2 = "$1$3^$2$3^v";
	
	padraoPosfixa3 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^\\^";
	substituicaoPosfixa3 = "$3$1^$3$2^v$4^";
	
	padraoPosfixa4 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v\\^";
	substituicaoPosfixa4 = "$1$2$3$4$5$6^$1$2$3$7$8$9^v";
	
	padraoPosfixa5 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^";
	substituicaoPosfixa5 = "$1$2$3$7$8$9^$4$5$6$7$8$9^v";
	
	padraoPosfixa6 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)v\\^";
	substituicaoPosfixa6 = "$1$2$3$4$5$6^$1$2$3$7^v";
	
	padraoPosfixa7 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v"
		+ "([tfA-Z]¬?)\\^";
	substituicaoPosfixa7 = "$1$2$3$7^$4$5$6$7^v";
	
	padraoPosfixa8 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v\\^";
	substituicaoPosfixa8 = "$1$2$3$4^$1$5$6$7^v";
	
	padraoPosfixa9 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^";
	substituicaoPosfixa9 = "$1$5$6$7^$2$3$4$5$6$7^v";
	
	padraoPosfixa10 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v\\^";
	substituicaoPosfixa10 = "$1$2$3$4^$1$2$3$5$6$7^v";
	
	padraoPosfixa11 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)v"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^";
	substituicaoPosfixa11 = "$1$2$3$5$6$7^$4$5$6$7^v";
	
	padraoPosfixa12 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)v\\^";
	substituicaoPosfixa12 = "$1$2$3$4^$1$2$3$5^v";
	
	padraoPosfixa13 = "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)v"
		+ "([tfA-Z]¬?)\\^";
	substituicaoPosfixa13 = "$1$2$3$5^$4$5^v";
	
	padraoPosfixa14 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])"
		+ "([tfA-Z]¬?)v\\^";
	substituicaoPosfixa14 = "$1$2$3$4^$1$5^v";
	
	padraoPosfixa15 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v"
		+ "([tfA-Z]¬?)\\^";
	substituicaoPosfixa15 = "$1$5^$2$3$4$5^v";
	
	padraoPosfixa16 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])v\\^";
	substituicaoPosfixa16 = "$1$2^$1$3$4$5^v";
	
	padraoPosfixa17 = "([tfA-Z]¬?)"
		+ "([tfA-Z]¬?)v"
		+ "([tfA-Z]¬?)([tfA-Z]¬?)([v|\\^|>])\\^";
	substituicaoPosfixa17 = "$1$3$4$5^$2$3$4$5^v";
	
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
    
//    @Override
//    public String matches(No no) {
//	
//	// Declarações
//	Pattern pattern;
//	Matcher matcher;
//	String result = "";
//	
//	// Encontrar os padrões A^(BvC)
//	pattern = Pattern.compile(padraoPosfixa);
//	matcher = pattern.matcher(no.getExpressao());
//	
//	// Se houver ocorrências...
//	if(matcher.find()) {
//	    // Substitui todas as ocorrências
//	    result += matcher.replaceAll(substituicaoPosfixa);
////	    System.out.println("realizou alterações em " + getClass());
//	}
//	
//	// Encontrar os padrões (BvC)^A
//	pattern = Pattern.compile(padraoPosfixa2);
//	matcher = pattern.matcher(no.getExpressao());
//	
//	// Se houver ocorrências...
//	if(matcher.find()) {
//	    result += ";" + matcher.replaceAll(substituicaoPosfixa2);
////	    System.out.println("realizou alterações em " + getClass());
//	}
//	
//	// Encontrar os padrões (BvC)^A^Z
//	pattern = Pattern.compile(padraoPosfixa3);
//	matcher = pattern.matcher(no.getExpressao());
//	
//	// Se houver ocorrências...
//	if(matcher.find()) {
//	    result += ";" + matcher.replaceAll(substituicaoPosfixa3);
////	    System.out.println("realizou alterações em " + getClass());
//	}
//	
//	return result;
//    }
    
}
