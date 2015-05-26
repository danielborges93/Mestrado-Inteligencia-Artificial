package model.equivalencia;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.questao1.No;

/**
 *
 * @author danielborges93
 */
public abstract class Equivalencia {

    /**
     * Regex do padrão a ser encontrado no formato posfixo.
     */
    protected String padraoPosfixa;

    /**
     * Valor a ser substituído no formato posfixo.
     */
    protected String substituicaoPosfixa;

    /**
     * Map com os padrões no formato posfixos como chave e a sua substituição
     * como valor.
     */
    protected Map<String, String> padroesPosfixos;

    /**
     * Nome da equivalência.
     */
    protected String nome;

    /**
     * Detecta se há equivaliencias no nó especificado.
     *
     * @param no Nó a ser verificado.
     * @return Retorna uma <code>String</code> com a expressão alterada.
     */
    public String matches(No no) {
	
	// Construtor para gerar a string final
	StringBuilder result = new StringBuilder();
	
	// Percorrer o map e realizar as substituições
	for (String padrao : this.padroesPosfixos.keySet()) {
	    String substituicao = this.padroesPosfixos.get(padrao);
	    
	    // Detectar o padrão
	    Pattern pattern = Pattern.compile(padrao);
	    Matcher matcher = pattern.matcher(no.getExpressao());
	    
	    // Se encontrar ocorrências...
	    if (matcher.find()) {
		// ..realiza todas as substituições
		String replaceAll = matcher.replaceAll(substituicao);
		
		// Adiciona na string final
		result.append(replaceAll);
		result.append(";");
	    }
	}

	return result.toString();
    }

    /**
     * Recupera o nome da equivalência.
     *
     * @return Retorna uma <code>String</code> com o nome da equivalência.
     */
    public String getNome() {
	return nome;
    }

}
