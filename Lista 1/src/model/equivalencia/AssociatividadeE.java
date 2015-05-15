package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.questao1.No;

/**
 *
 * @author danielborges93
 */
public class AssociatividadeE extends Equivalencia {
    
    /**
     * O contrário da associatividade.
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    public AssociatividadeE() {
	padrao = "[(]([A-Z])\\^([A-Z])[)]\\^([A-Z])";
	substituicao = "$1^($2^$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^(t|f|[A-Z]¬?)\\^";
	substituicaoPosfixa = "$1$2$3^^";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^\\^";
	substituicaoPosfixa2 = "$1$2^$3^";
    }
    
    @Override
    public String matches(No no) {
	
	// Declarações
	Pattern pattern;
	Matcher matcher;
	String result = "";
	
	// Encontrar os padrões A^(B^C)
	pattern = Pattern.compile(padraoPosfixa);
	matcher = pattern.matcher(no.getExpressao());
	
	// Se houver ocorrências...
	if(matcher.find()) {
	    // Substitui todas as ocorrências
	    result += matcher.replaceAll(substituicaoPosfixa);
//	    System.out.println("realizou alterações em " + getClass());
	}
	
	// Encontrar os padrões (A^B)^C
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
