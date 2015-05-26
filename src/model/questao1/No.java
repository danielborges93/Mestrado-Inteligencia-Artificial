package model.questao1;

import baseDeDados.EquivalenciasLogicas;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.equivalencia.Equivalencia;

/**
 *
 * @author danielborges93
 */
public class No {

    /**
     * Expressão na qual a expressão atual herdou.
     */
    private No pai;

    /**
     * <code>String</code> da expressão atual.
     */
    private final String expressao;

    /**
     * Lista de filhos gerados.
     */
    private List<No> filhos;

    /**
     * Equivalência utilizada para gerar o nó.
     */
    private String equivalenciaUtilizada;

    /**
     * Construtor.
     *
     * @param expressaoStr
     */
    public No(String expressaoStr) {
	this.expressao = expressaoStr;
    }

    /**
     * Gera os nós filhos.
     *
     * @return Retorna uma lista de <code>No</code> derivados do nó atual.
     */
    public List<No> geraFilhos() {

	// Recuperar todas as equivalências lógicas
	EquivalenciasLogicas equivalencias = EquivalenciasLogicas.getInstance();

	// Lista de filhos
	List<No> filhosTemp = new ArrayList<>();

	// Percorrer as equivalências para gerar os nós filhos
	for (Equivalencia equivalencia : equivalencias) {
	    // Recupera a string alterada
	    String match = equivalencia.matches(this);

	    // Se houve alteração...
	    if (!match.equals("")) {

		// Recupera as possibilidades
		String matches[] = match.split(";");

		// Cria os nós filhos
		for (String m : matches) {
		    // Às vezes vem vazio, se vier, pula...
		    if (m.equals("")) {
			continue;
		    }

		    No filho = new No(m);
		    filho.pai = this;
		    filho.equivalenciaUtilizada = equivalencia.getNome();

		    // Adiciona à lista de filhos
		    filhosTemp.add(filho);
		}

	    }
	}

	// Guardar a lista de filhos
	this.filhos = filhosTemp;

	return filhosTemp;
    }

    public boolean valido() {
	// Verificar existem valores inválidos, ou seja, caracteres diferentes
	// de '(', ')', '¬', '^', 'v', '>', 't' ou 'f'
	Pattern pattern = Pattern.compile("([A-Z])");
	Matcher matcher = pattern.matcher(this.expressao);
	return !matcher.find();
    }

    /**
     * Recupera a expressão do nó.
     *
     * @return Retorna a expressão do nó.
     */
    public String getExpressao() {
	return expressao;
    }

    /**
     * Recupera o pai do nó.
     *
     * @return Retorna o nó pai.
     */
    public No getPai() {
	return pai;
    }

    /**
     * Recupera a equivalência utilizada para gerar o nó.
     *
     * @return Retorna uma <code>String</code> que diz qual equivalência foi
     * utilizada pra gerar o nó.
     */
    public String getEquivalenciaUtilizada() {
	return equivalenciaUtilizada;
    }

    @Override
    public String toString() {
//	return Expressao.posfixaParaInfixa(expressao);
	return expressao + " (" + equivalenciaUtilizada + ")";
    }

}
