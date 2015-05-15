package model.questao3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private final List<String> proposicoes;

    /**
     * Consequência lógica.
     */
    private final String consequencia;

    /**
     * Regra que foi utilizada para gerar esse nó.
     */
    private String regraUtilizada;

    /**
     * Construtor.
     *
     * @param proposicoes
     * @param consequencia
     */
    public No(List<String> proposicoes, String consequencia) {
	this.proposicoes = proposicoes;
	this.consequencia = consequencia;
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
	    // Criar uma cópia das proposições
	    List<String> proposicoesCopy = new ArrayList<>(this.proposicoes);

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
    public List<String> getProposicoes() {
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

	for (String prop : this.proposicoes) {
	    builder
		    .append(prop).append("\n");
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
	
	List<String> p1 = new ArrayList<>();
	p1.add("1");
	p1.add("2");
	p1.add("3");
	p1.add("4");
	
	List<String> p2 = new ArrayList<>();
	p2.add("1");
	p2.add("2");
	
	List<String> p3 = new ArrayList<>();
	p3.add("1");
	p3.add("2");
	p3.add("4");
	
	List<String> p4 = new ArrayList<>();
	p4.add("1");
	p4.add("2");
	p4.add("3");
	p4.add("4");
	
	HashSet<No> set = new HashSet<>();
	
	No pai = new No(p1, "asd");
	set.add(pai);
	
	No filho1 = new No(p2, "asd");
	filho1.pai = pai;
	set.add(filho1);
	
	No filho2 = new No(p3, "asd");
	filho2.pai = pai;
	set.add(filho2);
	
	No filho12 = new No(p1, "asd");
//	filho12.pai = ;
	
	System.out.println(set.contains(filho12));
    }
}
