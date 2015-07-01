package questao3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;
import model.TipoBusca;
import model.questao3.No;

/**
 *
 * @author danielborges93
 */
public class Questao3 {

    /**
     * Lista de proposições.
     */
    private final List<Expressao> proposicoes;

    /**
     * Construtor.
     */
    public Questao3() {
	this.proposicoes = new ArrayList<>();
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
	
	for (String proposicao : proposicoesArr) {
	    // Cria a expressão
	    Expressao expressao = new Expressao(proposicao, null);
	    this.proposicoes.add(expressao);
	}
	
	// Iniciar a busca
	Busca busca = new Busca(this.proposicoes, consequenciaStr);
	No no = busca.buscar(TipoBusca.LARGURA);
	
	// Imprimir o caminho percorrido
	System.out.println("Utilizando regras de inferência:");
	imprimirCaminho(no);

    }
    
    private void imprimirCaminho(No result) {
	// Se o nó não for nulo (não é a raiz), chama recursivamente com o pai
	// como parámetro
	if (result != null) {
	    imprimirCaminho(result.getPai());
	    System.out.println(result);
	    System.out.println();
	}
	  
    }

}
