package questao1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utils.input.Leitor;
import model.Expressao;

/**
 * Resolução da questão 1:<br/>
 * a) Converter todas as proposições para a notação posfixa e criar a tabela
 * verdade.
 *
 * @author danielborges93
 */
public class Questao1 {

    /**
     * Executa a questão.
     */
    public void exec() {
	comTabelaVerdade();
    }

    /**
     * Executa a atividade com a tabela verdade.
     */
    private void comTabelaVerdade() {

	// Ler todas as proposições
	System.out.println("Digite as proposições: ");
	String proposicoesString = Leitor.lerLinha();

	// Ler a consequência
	System.out.println("Digite a consequência: ");
	String consequenciaStr = Leitor.lerLinha();

	// Guardar as proposições em um array
	String[] proposicoesArray = proposicoesString.split(", ");

//	Converter as proposições para o formato posfixo e salvar em uma lista
//	Aproveitar o 'for' para guardar os operandos
	List<Expressao> proposicoesList = new ArrayList<>();
	Set<Character> operandosSet = new HashSet<>();

	for (String proposicao : proposicoesArray) {
	    // Converter
	    Expressao expressao = new Expressao(proposicao);
	    proposicoesList.add(expressao);

	    // Recuperar os operandos
	    for (char c : proposicao.toCharArray()) {
		/*
		 * Verificar se o caractere está no intervalo [A-Z] e
		 * é diferente de 'v'
		 */
		if (Character.isAlphabetic(c) && c != 'v') {
		    operandosSet.add(c);
		}
	    }
	}

	// Fazer o mesmo com a consequência
	for (char c : consequenciaStr.toCharArray()) {
	    /*
	     * Verificar se o caractere está no intervalo [A-Z] e
	     * é diferente de 'v'
	     */
	    if (Character.isAlphabetic(c) && c != 'v') {
		operandosSet.add(c);
	    }
	}

	// Converter de Set para List
	List<Character> operandosList = new ArrayList<>(operandosSet);

	// Criar a tabela verdade
	int quantOperandos = operandosList.size();
	int quantProposicoes = proposicoesArray.length;

	int quantLinhas = (int) Math.pow(2, quantOperandos);
	int quantColunas = quantOperandos + quantProposicoes + 5;

	/*
	 Formato geral da tabela:
	
	 | operador1 | operador2 | ... | propo1 | propo2 | ... | conjunção | consequência1 | teorema1 | consequência2 | teorema2 |
	 */
	boolean[][] tabelaVerdade = new boolean[quantLinhas][quantColunas];
	preencherTabelaVerdade(tabelaVerdade, quantOperandos);

//	imprimirTabelaVerdade(tabelaVerdade);
//	System.exit(0);
	// Completar o resto da tabela verdade linha por linha
	for (boolean[] linha : tabelaVerdade) {
	    // Map com os valores dos operandos
	    Map<Character, Boolean> valores = new HashMap<>();
	    for (int i = 0; i < quantOperandos; i++) {
		char operando = operandosList.get(i);
		boolean valor = linha[i];
		valores.put(operando, valor);
	    }

	    // Resolver as proposições
	    // Aproveitar o for para formar a expressão da conjunção
	    StringBuilder conjuncaoStr = new StringBuilder();

	    int colunaAtual = quantOperandos;

	    for (; colunaAtual < quantOperandos + quantProposicoes; colunaAtual++) {
		Expressao proposicao = proposicoesList.get(colunaAtual - quantOperandos);
		boolean res = proposicao.resolver(valores);
		linha[colunaAtual] = res;

		char c = res ? 't' : 'f';
		conjuncaoStr.append(c);

		if (colunaAtual < quantOperandos + quantProposicoes - 1) {
		    conjuncaoStr.append("^");
		}
	    }
	    
	    // Resolver a conjunção
	    Expressao conjuncao = new Expressao(conjuncaoStr.toString());
	    linha[colunaAtual++] = conjuncao.resolver(valores);

	    // Resolver a consequência do teorema 1
	    Expressao consequencia = new Expressao(consequenciaStr);
	    linha[colunaAtual++] = consequencia.resolver(valores);

	    // Resolver o implica do teorema 1
	    String teorema1Str = ""
		    + (linha[colunaAtual - 2] ? 't' : 'f')
		    + ">"
		    + (linha[colunaAtual - 1] ? 't' : 'f');
	    Expressao teorema1 = new Expressao(teorema1Str);
	    linha[colunaAtual++] = teorema1.resolver(valores);

	    // Resolver a consequência do teorema 2
	    String consequencia2Str = "¬(" + consequenciaStr + ")";
	    Expressao consequencia2 = new Expressao(consequencia2Str);
	    linha[colunaAtual++] = consequencia2.resolver(valores);
	    
	    // Resolver o implica do teorema 1
	    String teorema2Str = ""
		    + (linha[colunaAtual - 4] ? 't' : 'f')
		    + "^"
		    + (linha[colunaAtual - 1] ? 't' : 'f');
	    Expressao teorema2 = new Expressao(teorema2Str);
	    linha[colunaAtual++] = teorema2.resolver(valores);

	}

	// Imprimir a tabela verdade
	imprimirTabelaVerdade(tabelaVerdade, operandosList, proposicoesList, consequenciaStr, ("¬(" + consequenciaStr + ")"));

    }

    /**
     * Preenche os valores da tabela verdade.
     *
     * @param tabelaVerdade Tabela verdade.
     * @param quantOperandos Quantidade de operandos.
     */
    private void preencherTabelaVerdade(boolean[][] tabelaVerdade, int quantOperandos) {
	int qtd = quantOperandos;
	int qtdNumeros = (int) Math.pow(2, qtd);

	for (int j = 0; j < qtd; j++) {
	    int passo = (int) Math.pow(2, j);
	    boolean zero = false;

	    for (int i = 0; i < qtdNumeros; i++) {
		if (i % passo == 0) {
		    zero = !zero;
		}

		tabelaVerdade[i][j] = !zero;
	    }
	}

//	for (boolean[] linha : tabelaVerdade) {
//	    for (int i = 0; i < linha.length / 2; i++) {
//		boolean temp = linha[i];
//		linha[i] = linha[linha.length - i - 1];
//		linha[linha.length - i - 1] = temp;
//	    }
//	}
    }

    /**
     * Imprime a tabela verdade.
     *
     * @param tabelaVerdade Tabela verdade.
     */
    private void imprimirTabelaVerdade(boolean[][] tabelaVerdade, List<Character> operandosList, List<Expressao> proposicoes, String consequencia1, String consequencia2) {

	for (int i=0; i<tabelaVerdade[0].length; i++) {
	    System.out.print("++++++++");
	}
	System.out.println("|");
	for (char c : operandosList) {
	    System.out.print("|");
	    System.out.print(c);
	    System.out.print("\t");
	}
	for (Expressao expressao : proposicoes) {
	    System.out.print("|");
	    System.out.print(expressao.getInfixa());
	    System.out.print("\t");
	}
	System.out.print("|conj.\t");
	System.out.print("|"+consequencia1 + "\t");
	System.out.print("|teo. 1\t");
	System.out.print("|"+consequencia2 + "\t");
	System.out.print("|teo. 2\t");
	System.out.println("|");
	System.out.print("+");
	for (int i=0; i<tabelaVerdade[0].length; i++) {
	    System.out.print("++++++++");
	}
	System.out.println();
	for (boolean[] linha : tabelaVerdade) {
	    for (boolean coluna : linha) {
		System.out.print("|");
		System.out.print(coluna);
		System.out.print("\t");
	    }
	    System.out.println("|");
	}
	System.out.print("+");
	for (int i=0; i<tabelaVerdade[0].length; i++) {
	    System.out.print("++++++++");
	}
	System.out.println();
    }

}
