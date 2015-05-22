package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.questao1.No;

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
    
    /**
     * Se for algo assim: (CvD)^A^B
     */
    private final String padraoPosfixa3;
    private final String substituicaoPosfixa3;

    public DistributividadeEsobreOU() {
	nome = "Distributividade de ^ sobre v";
	
	padrao = "([A-Z])\\^[(]([A-Z])v([A-Z])[)]";
	substituicao = "($1^$2)v($1^$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v\\^";
	substituicaoPosfixa = "$1$2^$1$3^v";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)\\^";
	substituicaoPosfixa2 = "$1$3^$2$3^v";
	
	padraoPosfixa3 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^\\^";
	substituicaoPosfixa3 = "$3$1^$3$2^v$4^";
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
	
	// Encontrar os padrões (BvC)^A^Z
	pattern = Pattern.compile(padraoPosfixa3);
	matcher = pattern.matcher(no.getExpressao());
	
	// Se houver ocorrências...
	if(matcher.find()) {
	    result += ";" + matcher.replaceAll(substituicaoPosfixa3);
//	    System.out.println("realizou alterações em " + getClass());
	}
	
	return result;
    }
    
}
