package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.No;

/**
 *
 * @author danielborges93
 */
public abstract class Equivalencia {
    
    /**
     * Regex do padrão a ser encontrado.
     */
    protected String padrao;
    
    /**
     * Regex do padrão a ser encontrado no formato posfixo.
     */
    protected String padraoPosfixa;
    
    /**
     * Valor a ser substituído.
     */
    protected String substituicao;
    
    /**
     * Valor a ser substituído no formato posfixo.
     */
    protected String substituicaoPosfixa;
    
    /**
     * Detecta se há equivaliencias no nó especificado.
     * @param no Nó a ser verificado.
     * @return Retorna uma <code>String</code> com a expressão alterada.
     */
    public String matches(No no) {
	
	// Detectar o padrão na expressão
	Pattern pattern = Pattern.compile(this.padraoPosfixa);
	Matcher matcher = pattern.matcher(no.getExpressao());
	
	// Resultado da substituições
	String result = "";
	
	// Verificar se há ocorrências do padrão
	if(matcher.find()) {
	    // Realizar todas as substituições
	    result += matcher.replaceAll(this.substituicaoPosfixa);
	    System.out.println("realizou alterações em " + getClass());
	}
	
	return result;
    }

}
