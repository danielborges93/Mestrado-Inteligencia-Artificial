package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.No;

/**
 *
 * @author danielborges93
 */
public class DistributividadeEsobreOU extends Equivalencia {
    
    /**
     * Há duas maneiras de representar: A^(BvC) ou (BvC)^A
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    public DistributividadeEsobreOU() {
	padrao = "([A-Z])\\^[(]([A-Z])v([A-Z])[)]";
	substituicao = "($1^$2)v($1^$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v\\^";
	substituicaoPosfixa = "$1$2^$1$3^v";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)\\^";
	substituicaoPosfixa2 = "$1$3^$2$3^v";
    }
    
    @Override
    public String matches(No no) {
	
	// Declarações
	Pattern pattern;
	Matcher matcher;
	String result = "";
	
	// Encontrar os padrões A^(BvC)
	pattern = Pattern.compile(padraoPosfixa);
	matcher = pattern.matcher(no.getExpressao());
	
	// Se houver ocorrências...
	if(matcher.find()) {
	    // Substitui todas as ocorrências
	    result += matcher.replaceAll(substituicaoPosfixa);
//	    System.out.println("realizou alterações em " + getClass());
	}
	
	// Encontrar os padrões (BvC)^A
	pattern = Pattern.compile(padraoPosfixa2);
	matcher = pattern.matcher(no.getExpressao());
	
	// Se houver ocorrências...
	if(matcher.find()) {
	    result += ";" + matcher.replaceAll(substituicaoPosfixa2);
//	    System.out.println("realizou alterações em " + getClass());
	}
	
	return result;
    }
    
}
