package questao3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.regrasInferencias.Absorcao;
import model.regrasInferencias.Adicao;
import model.regrasInferencias.Conjuncao;
import model.regrasInferencias.Construtivo;
import model.regrasInferencias.Destrutivo;
import model.regrasInferencias.ModusPonens;
import model.regrasInferencias.ModusTollens;
import model.regrasInferencias.Regra;
import model.regrasInferencias.SilogismoDisjuntivo;
import model.regrasInferencias.SilogismoHipotetico;
import model.regrasInferencias.Simplificacao;

/**
 *
 * @author danielborges93
 */
public class Questao3 {

    /**
     * Lista de proposições.
     */
    private final List<String> proposicoes;
    
    /**
     * Lista de regras de inferência.
     */
    private final List<Regra> regras;

    /**
     * Construtor.
     */
    public Questao3() {
	this.proposicoes = new ArrayList<>();
	this.regras = new ArrayList<>();
	
	Regra regra;
	
	// Adicionar as regras
	regra = new Absorcao();
	this.regras.add(regra);
	
	regra = new Adicao();
	this.regras.add(regra);
	
	regra = new Conjuncao();
	this.regras.add(regra);
	
	regra = new Construtivo();
	this.regras.add(regra);
	
	regra = new Destrutivo();
	this.regras.add(regra);
	
	regra = new ModusPonens();
	this.regras.add(regra);
	
	regra = new ModusTollens();
	this.regras.add(regra);
	
	regra = new SilogismoDisjuntivo();
	this.regras.add(regra);
	
	regra = new SilogismoHipotetico();
	this.regras.add(regra);
	
	regra = new Simplificacao();
	this.regras.add(regra);
    }

    /**
     * Executa a questão.
     *
     * @param proposicoesString <code>String</code> com todas as preposições
     * separadas por vírgula.
     * @param consequenciaStr <code>String</code> com a consequência.
     */
    public void exec(String proposicoesString, String consequenciaStr) {

	// Adicionar as proposições no arrayList
	String[] proposicoesArr = proposicoesString.split(", ");
	this.proposicoes.addAll(Arrays.asList(proposicoesArr));

	// Enquanto o tamanho da lista de proposições for maior que 1...
	while (this.proposicoes.size() > 1) {
	    
	    // Utilizar as regras
	    for(Regra regra : this.regras) {
		regra.usar(this.proposicoes);
	    }
	    
	    // Imprimir o que tem...
	    for(String prop : this.proposicoes) {
		System.out.println(prop);
	    }
	    System.out.println("-------------");
	    System.out.println(consequenciaStr);
	    System.out.println();
	    
	}

    }

}
