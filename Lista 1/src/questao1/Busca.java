package questao1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private Set<No> nosGerados;

    /**
     * Construtor.
     *
     * @param raizStr Expressão raiz.
     */
    public Busca(String raizStr) {
	this.nosGerados = new HashSet<>();
	this.raiz = new No(raizStr);
	this.nosGerados.add(this.raiz);
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

	// Verificar existem valores inválidos, ou seja, caracteres diferentes
	// de '(', ')', '¬', '^', 'v', '>', 't' ou 'f'
	Pattern pattern = Pattern.compile("([A-Z])");
	Matcher matcher = pattern.matcher(no.getExpressao().getInfixa());
	boolean invalido = matcher.find();

	// Se o nó for inválido...
	if (invalido) {
	    // Gera os nós filhos
	    List<No> filhos = no.geraFilhos();

	    // Resultado da busca
	    No result = null;

	    // Chama recursivamente com todos os nós filhos
	    for (No filho : filhos) {
		result = recursao(filho);

		// Se o resultado não for nulo (acho um nó válido), para o loop
		if (result != null) {
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
	String str = "(t^fvt^¬f>A)";

	Pattern pattern = Pattern.compile("([A-Z])");
	Matcher matcher = pattern.matcher(str);

	System.out.println(matcher.find());
    }

}
