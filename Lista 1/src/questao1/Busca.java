package questao1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;
import model.No;
import utils.Leitor;

/**
 * Realiza a busca.
 *
 * @author danielborges93
 */
public class Busca {

    /**
     * Nó raiz.
     */
    private final No raiz;

    /**
     * Nós que já foram gerados.
     *
     * Utilizado para impedir que entre em <i>loop</i> e gere nós
     * desnecessários.
     */
    private final Set<String> posfixasGeradas;

    /**
     * Construtor.
     *
     * @param raizStr Expressão raiz.
     */
    public Busca(String raizStr) {
	this.posfixasGeradas = new HashSet<>();
	
	Expressao expressaoRaiz = new Expressao(raizStr);
	
	this.raiz = new No(expressaoRaiz.getPosfixa());
	this.posfixasGeradas.add(this.raiz.getExpressao());
    }

    /**
     * Inicia a busca.
     *
     * @return Nó que deu certo.
     */
    public No buscar() {
	return recursao(this.raiz);
    }

    /**
     * Recursão da busca em profundidade.
     *
     * @param no <code>No</code> a ser verificado.
     * @return
     */
    private No recursao(No no) {
	
	this.posfixasGeradas.add(no.getExpressao());
	
	System.out.println("verificar " + no);
//	System.out.println("gerados   " + posfixasGeradas);
	// Verificar se o nó é válido
	boolean valido = no.valido();
	
	// Se o nó não for inválido...
	if (!valido) {
	    System.out.println("não é válido...");
	    
	    // Gera os nós filhos
	    List<No> filhos = no.geraFilhos();
	    
	    // Eliminar os filhos que já foram gerados antes
	    List<No> filhosRealmenteGerados = new ArrayList<>();
	    for(No filho : filhos) {
		// Se a expressão do filho não foi gerada...
		if(!this.posfixasGeradas.contains(filho.getExpressao())) {
		    // ...adiciona
		    filhosRealmenteGerados.add(filho);
		}
	    }
	    filhos = filhosRealmenteGerados;
	    
	    System.out.println("filhos: " + filhos);
	    Leitor.lerLinha();
	    
	    // Resultado da busca
	    No result = null;

	    // Chama recursivamente com todos os nós filhos
	    for (No filho : filhos) {
		
		result = recursao(filho);

		// Se o resultado não for nulo (acho um nó válido), para o loop
		if (result != null) {
		    this.posfixasGeradas.add(filho.getExpressao());
		    break;
		}
	    }

	    return result;
	} else { // Se o nó for válido...
	    // Retorna o nó
	    return no;
	}

    }

    /**
     * Usado para testes...
     *
     * @param args
     */
    public static void main(String[] args) {
	Busca b = new Busca("A^B");
	System.out.println(b.posfixasGeradas);
    }

}
