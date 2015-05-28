package model;

import java.util.HashMap;
import java.util.Map;
import utils.Pilha;

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
public class Expressao {

    /**
     * String que representa a expressão na forma infixa.
     */
    private final String infixa;

    /**
     * String que representa a expressão na forma posfixa.
     */
    private String posfixa;

    /**
     * Construtor.
     *
     * @param infixa Expressão na forma infixa.
     */
    public Expressao(String infixa) {

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
	Pilha<Character> pilha = new Pilha<>();

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
	}

	while (!pilha.vazia()) {
	    char c = pilha.desempilha();
	    pos.append(c);
	}

	return pos.toString();
    }

    /**
     * Resolve a expressão com os valores dados.
     *
     * @param valores <code>Map</code> com os valores de cada operando.
     * @return Retora o valor booleano resultante da expressão.
     */
    public boolean resolver(Map<Character, Boolean> valores) {

	// Tratamento de erro caso for um Map nulo
	if (valores == null) {
	    valores = new HashMap<>();
	}

	// Criar uma cópia da expressão posfixa para trabalhar com ela
	String pos = this.posfixa;

	// Substituir na string os valores corretos
	for (Character c : valores.keySet()) {
	    char valor = valores.get(c) == true ? 't' : 'f';
	    pos = pos.replaceAll("" + c, "" + valor);
	}

	Pilha<Character> pilha = new Pilha<>();

	for (char c : pos.toCharArray()) {
	    char v1, v2, res;
	    boolean v1Bool, v2Bool, resBool;
	    switch (c) {
		case '¬':
		    v1 = pilha.desempilha();
		    res = v1 == 't' ? 'f' : 't';
		    break;

		case '^':
		    v2 = pilha.desempilha();
		    v1 = pilha.desempilha();
		    v1Bool = (v1 == 't');
		    v2Bool = (v2 == 't');
		    resBool = (v1Bool && v2Bool);
		    res = resBool ? 't' : 'f';
		    break;

		case 'v':
		    v2 = pilha.desempilha();
		    v1 = pilha.desempilha();
		    v1Bool = (v1 == 't');
		    v2Bool = (v2 == 't');
		    resBool = (v1Bool || v2Bool);
		    res = resBool ? 't' : 'f';
		    break;
		case '>':
		    v2 = pilha.desempilha();
		    v1 = pilha.desempilha();

		    if (v1 == 't' && v2 == 'f') {
			res = 'f';
		    } else {
			res = 't';
		    }
		    break;
		default:
		    res = c;
		    break;
	    }

	    pilha.empilha(res);
	}

	char topo = pilha.topo();

	return (topo == 't');
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
	// Verificar se não existe a posfixa
	if (null == this.posfixa) {
	    this.posfixa = this.converter();
	}

	// Retorna
	return posfixa;
    }

    /**
     * Função que converte uma expressão da forma posfixa para a infixa.
     *
     * @param posfixa Expressão na forma posfixa.
     * @return Retorna uma <code>String</code> que representa a expressão na
     * forma infixa.
     */
    public static String posfixaParaInfixa(String posfixa) {

	// Pilha para guardar as expressões
	Pilha<String> pilha = new Pilha<>();

	// Percorrer toda a expressão posfixa
	for (char c : posfixa.toCharArray()) {
	    // Se for uma letra de A a Z, e se for diferente de 'v'...
	    if (Character.isAlphabetic(c) && c != 'v') {
		// ...empilha o caractere
		pilha.empilha("" + c);
	    } // Se não for é porque é um operador
	    else if (c == '¬') { // Primeiro verifica se é uma negação
		// Desempilha o operando e empilha a expressão infixa
		String operando = pilha.desempilha();
		pilha.empilha("¬" + operando);
	    } else { // Entra aqui se for qualquer outro operador
		// Desempilha os dois operandos
		String operando2 = pilha.desempilha();
		String operando1 = pilha.desempilha();

		// Empilha a expressão infixa
		String infixa = "(" + operando1 + c + operando2 + ")";
		pilha.empilha(infixa);
	    }
	}

	String infixa = pilha.desempilha();

	if (infixa.length() > 1) {
	    return infixa.substring(1, infixa.length() - 1);
	} else {
	    return infixa;
	}
    }

    /**
     * Utilizado para testar...
     *
     * @param args
     */
    public static void main(String[] args) {
	String in1 = "Av(B^(C>D))";
	String in2 = "(AvB)^(Av(C>D))";

	Expressao e1 = new Expressao(in1);
	Expressao e2 = new Expressao(in2);

	String pos1 = e1.converter();
	String pos2 = e2.converter();
	
	System.out.println(pos1);
	System.out.println(pos2);
    }

}
