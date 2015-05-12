package questao1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.No;

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
	this.raiz = new No(raizStr);
	this.posfixasGeradas.add(this.raiz.getExpressao().getPosfixa());
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
	
	// Verificar se o nó é válido
	boolean valido = no.valido();
	
	// Se o nó não for inválido...
	if (!valido) {
	    // Gera os nós filhos
	    List<No> filhos = no.geraFilhos();

	    // Resultado da busca
	    No result = null;

	    // Chama recursivamente com todos os nós filhos
	    for (No filho : filhos) {
		
		// Verificar se o filho já foi gerado
		if(this.posfixasGeradas.contains(filho.getExpressao().getPosfixa())) {
		    // Se já foi gerado, vai para o próximo filho
		    continue;
		}
		
		result = recursao(filho);

		// Se o resultado não for nulo (acho um nó válido), para o loop
		if (result != null) {
		    this.posfixasGeradas.add(filho.getExpressao().getPosfixa());
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
