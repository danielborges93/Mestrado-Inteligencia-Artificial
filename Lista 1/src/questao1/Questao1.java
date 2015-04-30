package questao1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utils.input.Leitor;
import model.Proposicao;

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

	// Ler todas as proposições
	System.out.println("Digite as proposições: ");
	String proposicoesString = Leitor.lerLinha();

	// Ler a consequência
	System.out.println("Digite a consequência: ");
	String consequencia = Leitor.lerLinha();

	// Guardar as proposições em um array
	String[] proposicoesArray = proposicoesString.split(", ");

	/*
	 * Converter as proposições para o formato posfixo e salvar em uma lista
	 *
	 * Aproveitar o 'for' para guardar os operandos
	 */
	List<Proposicao> proposicoesList = new ArrayList<>();
	Set<Character> operandosSet = new HashSet<>();

	for (String proposicao : proposicoesArray) {
	    // Converter
	    Proposicao posfixa = new Proposicao(proposicao);
	    proposicoesList.add(posfixa);

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

	// Converter de Set para List
	List<Character> operandosList = new ArrayList<>(operandosSet);

	// Criar a tabela verdade
	int quantOperandos = operandosList.size();
	int quantProposicoes = proposicoesArray.length;

	/*
	 Formato geral da tabela:
	
	 | op1 | op2 | ... | prepo1 | prepo2 | prepo2 | ... | conjunção | implica |
	 */
	boolean[][] tabelaVerdade
		= new boolean[(int) Math.exp(quantOperandos) + 1][quantOperandos + quantProposicoes + 2];
	preencherTabelaVerdade(tabelaVerdade, quantOperandos);
	
	

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

	for (boolean[] linha : tabelaVerdade) {
	    for (int i = 0; i < linha.length / 2; i++) {
		boolean temp = linha[i];
		linha[i] = linha[linha.length - i - 1];
		linha[linha.length - i - 1] = temp;
	    }
	}
	/*
	 for (int i = 0; i < qtdNumeros; i++) {
	 for (int j=0; j<qtd; j++) {
	 System.out.print(tabelaVerdade[i][j] + "\t");
	 }
	 System.out.println("");
	 }
	 */
    }

}
