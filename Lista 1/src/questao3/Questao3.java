package questao3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.questao3.No;
import model.regrasInferencias.Regra;
import utils.Leitor;
import utils.Pilha;

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
	this.proposicoes.addAll(Arrays.asList(proposicoesArr));
	
	// Iniciar a busca
	Busca busca = new Busca(this.proposicoes, consequenciaStr);
	No no = busca.buscar();
	
	// Imprimir o caminho percorrido
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
