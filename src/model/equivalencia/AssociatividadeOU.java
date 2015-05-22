package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.questao1.No;

/**
 *
 * @author danielborges93
 */
public class AssociatividadeOU extends Equivalencia {

    /**
     * O contrário da associatividade.
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    public AssociatividadeOU() {
	nome = "Associatividade de v";
	
	padrao = "[(]([A-Z])v([A-Z])[)]v([A-Z])";
	substituicao = "$1v($2v$3)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v(t|f|[A-Z]¬?)v";
	substituicaoPosfixa = "$1$2$3vv";
	
	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)vv";
	substituicaoPosfixa2 = "$1$2v$3v";
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
