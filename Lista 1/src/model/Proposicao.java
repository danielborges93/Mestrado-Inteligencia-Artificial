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
	this.posfixa = this.converter();
    }

    /**
     * Converte da forma infixa para a posfixa.
     *
     * @return Retorna uma <code>String</code> no formato posfixo.
     */
    private String converter() {

	StringBuilder pos = new StringBuilder();
	Pilha pilha = new Pilha();

	for (char c : this.infixa.toCharArray()) {
	    switch (c) {
		case '(':
		    pilha.empilha(c);
		    break;
		case ')':
		    char topo = pilha.desempilha();
		    while (topo != '(') {
			pos.append(topo);
			topo = pilha.desempilha();
		    }
		    break;
		case '¬':
		    pilha.empilha(c);
		    break;
		case '^':
		    while (!pilha.vazia() && pilha.topo() == '¬') {
			char op = pilha.desempilha();
			pos.append(op);
		    }
		    pilha.empilha(c);
		    break;
		case 'v':
		    while (!pilha.vazia() && (pilha.topo() == '¬' || pilha.topo() == '^')) {
			char op = pilha.desempilha();
			pos.append(op);
		    }
		    pilha.empilha(c);
		    break;
		case '>':
		    while (!pilha.vazia() && (pilha.topo() == '¬' || pilha.topo() == '^' || pilha.topo() == 'v')) {
			char op = pilha.desempilha();
			pos.append(op);
		    }
		    pilha.empilha(c);
		    break;
		default:
		    pos.append(c);
		    break;
	    }
	    System.out.println("char c = " + c);
	    System.out.println("posfix = " + pos);
	    System.out.println("pilha  = " + pilha);
	    System.out.println("");
	}

	while (!pilha.vazia()) {
	    char c = pilha.desempilha();
	    pos.append(c);
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

    /**
     * Utilizado para testar...
     *
     * @param args
     */
    public static void main(String[] args) {
	String in = "A^B^(AvC)";

	Proposicao p = new Proposicao(in);

	String pos = p.converter();

	System.out.println(pos);
    }

}
