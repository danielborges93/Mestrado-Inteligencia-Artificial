package model.questao3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;
import model.regrasInferencias.Regra;

/**
 *
 * @author danielborges93
 */
public class No {

    /**
     * Pai do nó atual;
     */
    private No pai;

    /**
     * Lista de proposições.
     */
    private final List<Expressao> proposicoes;

    /**
     * Consequência lógica.
     */
    private final Expressao consequencia;

    /**
     * Regra que foi utilizada para gerar esse nó.
     */
    private String regraUtilizada;
    
    /**
     * Array com as expressões utilizadas para gerar o nó.
     */
    private Expressao[] expressoesUtilizadas;

    /**
     * Construtor.
     *
     * @param proposicoes
     * @param consequencia
     */
    public No(List<Expressao> proposicoes, Expressao consequencia) {
	this.proposicoes = proposicoes;
	this.consequencia = consequencia;
	
	// Ordenar as proposições
	Collections.sort(this.proposicoes);
    }

    /**
     * Gera todos os filhos possíveis do nó.
     *
     * @param regras Listas de regras a serem utilizadas.
     * @return Retorna uma lista de nós filhos.
     */
    public List<No> geraFilhos(List<Regra> regras) {

	// Lista a ser retornada
	List<No> filhos = new ArrayList<>();

	// Percorrer as regras
	for (Regra regra : regras) {
	    List<Expressao> proposicoesCopy = new ArrayList<>(proposicoes);

//	    System.out.println("");
//	    System.out.println("Vai tentar gerar com " + regra.getNome());
//	    System.out.println(proposicoesCopy);
//	    System.out.println("");
	    
	    // Se a regra for usada...
	    if (regra.usar(proposicoesCopy)) {
		// ...gera o nó filho
		No filho = new No(proposicoesCopy, this.consequencia);
		filho.pai = this;
		filho.regraUtilizada = regra.getNome();
		filho.expressoesUtilizadas = regra.getEntradas();

		filhos.add(filho);
	    }
	}

	return filhos;
    }

    /**
     * Recupera a lista de proposições.
     *
     * @return Retorna a lista de proposições.
     */
    public List<Expressao> getProposicoes() {
	return proposicoes;
    }

    /**
     * Recupera o nó pai.
     *
     * @return Retorna o nó pai.
     */
    public No getPai() {
	return pai;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();

	if (this.regraUtilizada != null) {
	    builder
		    .append("Regra utilizada: ")
		    .append(this.regraUtilizada)
		    .append("\n");
	}

	for (Expressao prop : this.proposicoes) {
	    builder
		    .append(prop.getInfixa()).append("\n");
	}

	builder
		.append("-------------\n")
		.append(this.consequencia);

	return builder.toString();
    }

    /**
     * Testar...
     * @param args 
     */
    public static void main(String[] args) {
	
    }
}
