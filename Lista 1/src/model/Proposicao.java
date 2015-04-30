package model;

import utils.posfixa.Pilha;

/**
 * Classe que implementa uma proposição/expressão e faz a conversão da forma
 * infixa para a posfixa.
 * <br/>
 * <br/>
 *
 * <b>Prioridade dos operadores:</b>
 * <br/>
 * 1. ¬ (negação)<br/>
 * 2. ^ (e)<br/>
 * 3. v (ou)<br/>
 * 4. > (implica)
 * <br/>
 * <br/>
 *
 * @author danielborges93
 */
public class Proposicao {

    /**
     * String que representa a expressão na forma infixa.
     */
    private final String infixa;

    /**
     * String que representa a expressão na forma posfixa.
     */
    private final String posfixa;

    /**
     * Construtor.
     *
     * @param infixa Expressão na forma infixa.
     */
    public Proposicao(String infixa) {
	this.infixa = infixa;
	this.posfixa = this.converter(infixa);
    }

    /**
     * Converte da forma infixa para a posfixa.
     *
     * @param infixa Expressão no formato infixo.
     * @return Retorna uma <code>String</code> no formato posfixo.
     */
    private String converter(String infixa) {

	StringBuilder pos = new StringBuilder();
	Pilha pilha = new Pilha();
	
	for (char c : infixa.toCharArray()) {
	    switch (c) {
		case '(':
		    pilha.empilha(c);
		    break;
		case ')':
		    char topo;
		    do {
			topo = pilha.desempilha();
			pos.append(topo);
		    } while(topo != '(');
		    break;
		case '¬':
		    break;
		case '^':
		    break;
		case 'v':
		    break;
		case '>':
		    break;
		default:
		    pos.append(c);
		    break;
	    }
	}

	return pos.toString();
    }

    /**
     * Retorna a expressão na forma infixa.
     *
     * @return Retorna uma <code>String</code> com a expressão na forma infixa.
     */
    public String getInfixa() {
	return infixa;
    }

    /**
     * Retorna a expressão na forma posfixa.
     *
     * @return Retorna uma <code>String</code> com a expressão na forma posfixa.
     */
    public String getPosfixa() {
	return posfixa;
    }

}
