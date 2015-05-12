package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.No;

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
    
    public DistributividadeOUsobreE() {
	padrao = "([A-Z])v[(]([A-Z])\\^([A-Z])[)]";
	substituicao = "($1v$2)^($1v$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^v";
	substituicaoPosfixa = "$1$2v$1$3v^";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^(t|f|[A-Z]¬?)v";
	substituicaoPosfixa2 = "$1$3v$2$3v^";
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
	    System.out.println("realizou alterações em " + getClass());
	}
	
	// Encontrar os padrões (BvC)^A
	pattern = Pattern.compile(padraoPosfixa2);
	matcher = pattern.matcher(no.getExpressao());
	
	// Se houver ocorrências...
	if(matcher.find()) {
	    result += ";" + matcher.replaceAll(substituicaoPosfixa2);
	    System.out.println("realizou alterações em " + getClass());
	}
	
	return result;
    }
    
}
