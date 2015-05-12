package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danielborges93
 */
public class No {

    /**
     * Expressão na qual a expressão atual herdou.
     */
    private Expressao pai;

    /**
     * <code>String</code> da expressão atual.
     */
    private final Expressao expressao;

    /**
     * Diz se o nó foi visitado ou não.
     */
    private boolean visitado;

    /**
     * Lista de filhos gerados.
     */
    private List<No> filhos;

    /**
     * Construtor.
     *
     * @param expressaoStr
     */
    public No(String expressaoStr) {
	this.expressao = new Expressao(expressaoStr);
	this.visitado = false;
    }

    /**
     * Gera os nós filhos.
     *
     * @return Retorna uma lista de <code>No</code> derivados do nó atual.
     */
    public List<No> geraFilhos() {
	List<No> list = new ArrayList<>();

	return list;
    }

    /**
     * Recupera a expressão do nó.
     *
     * @return Retorna a expressão do nó.
     */
    public Expressao getExpressao() {
	return expressao;
    }

}
