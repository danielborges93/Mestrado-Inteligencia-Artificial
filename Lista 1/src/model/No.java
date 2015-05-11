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
    private final String expressaoStr;

    /**
     * Construtor.
     *
     * @param expressaoStr
     */
    public No(String expressaoStr) {
	this.expressaoStr = expressaoStr;
    }
    
    /**
     * Gera os nós filhos.
     * @return Retorna uma lista de <code>No</code> derivados do nó atual.
     */
    public List<No> geraFilhos() {
	List<No> list = new ArrayList<>();
	
	
	
	return list;
    }

}
