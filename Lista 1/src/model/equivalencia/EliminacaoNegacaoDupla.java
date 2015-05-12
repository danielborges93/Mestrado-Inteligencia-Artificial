package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.No;

/**
 *
 * @author danielborges93
 */
public class EliminacaoNegacaoDupla extends Equivalencia {
    
    /**
     * Existem dois padrões para a negação dupla.
     */
    private final String padrao2;

    /**
     * Construtor.
     */
    public EliminacaoNegacaoDupla() {
	padrao = "¬[(]¬([A-Z])[)]";
	padrao2 = "¬¬([A-Z])";
	substituicao = "$1";
	
	padraoPosfixa = "([A-Z]|t|f)¬¬";
	substituicaoPosfixa = "$1";
    }
    
    @Override
    public String matches(No no) {
	
	// Detectar o padrão na expressão
	Pattern pattern = Pattern.compile(this.padrao);
	Matcher matcher = pattern.matcher(no.getExpressao().getInfixa());
	
	// Resultado da substituições
	String result = null;
	
	// Verificar se há ocorrências do padrão
	if(matcher.find()) {
	    // Realizar todas as substituições
	    result = matcher.replaceAll(this.substituicao);
	}
	
	// Recuperar a expressão correta a ser utilizada
	String input = (result == null) ? no.getExpressao().getInfixa() : result;
	
	// Detectar o segundo padrão na expressão
	pattern = Pattern.compile(this.padrao2);
	matcher = pattern.matcher(input);
	
	// Verificar se há ocorrências do padrão
	if(matcher.find()) {
	    // Realizar todas as substituições
	    result = matcher.replaceAll(this.substituicao);
	}
	
	return result;
    }
    
}
