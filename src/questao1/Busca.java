package questao1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;
import model.TipoBusca;
import model.questao1.No;
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
     * Nós que já foram gerados. 
     *
     * Utilizado para impedir que entre em <i>loop</i> e gere nós
     * desnecessários.
     */
    private final Set<No> nosGerados;

    /**
     * Construtor.
     *
     * @param raizStr Expressão raiz.
     */
    public Busca(String raizStr) {
	this.posfixasGeradas = new HashSet<>();
	this.nosGerados = new HashSet<>();

	Expressao expressaoRaiz = new Expressao(raizStr, null);

	this.raiz = new No(expressaoRaiz.getPosfixa());
	this.posfixasGeradas.add(this.raiz.getExpressao());
    }

    /**
     * Inicia a busca.
     *
     * @return Nó que deu certo.
     */
    public No buscar(TipoBusca tipoBusca) {
	if (tipoBusca == TipoBusca.PROFUNDIDADE) {
	    // Execução com busca em profundidade
	    return recursaoProfundidade(this.raiz);
	}
	else {
	    // Execução com busca em largura
	    Set<No> fronteira = new HashSet();
	    fronteira.add(this.raiz);

	    nosGerados.add(this.raiz);

	    return recursaoLargura(fronteira);
	}
    }

    /**
     * Recursão da busca em profundidade.
     *
     * @param no <code>No</code> a ser verificado.
     * @return
     */
    private No recursaoProfundidade(No no) {

	this.posfixasGeradas.add(no.getExpressao());

	System.out.println("verificar " + no);
//	System.out.println("gerados   " + posfixasGeradas);
	// Verificar se o nó é válido
	boolean valido = no.valido();

	// Se o nó não for inválido...
	if (!valido) {
//	    System.out.println("não é válido...");

	    // Gera os nós filhos
	    List<No> filhos = no.geraFilhos();

	    // Eliminar os filhos que já foram gerados antes
	    List<No> filhosRealmenteGerados = new ArrayList<>();
	    for (No filho : filhos) {
		// Se a expressão do filho não foi gerada...
		if (!this.posfixasGeradas.contains(filho.getExpressao())) {
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

		result = recursaoProfundidade(filho);

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

    private No recursaoLargura(Set<No> fronteira) {
	
//	System.out.println("fronteira = " + fronteira.size());
//	Leitor.lerLinha();

	Set<No> novaFronteira = new HashSet<>();

	// Percorrer os elementos da fronteira
	for (No no : fronteira) {

	    // Verificar se o nó é válido
	    boolean valido = no.valido();

	    // Se o nó não for inválido...
	    if (!valido) {

		// Gera os nós filhos
		List<No> filhos = no.geraFilhos();
		
		// Remover os nós que já foram gerados
		filhos.removeAll(nosGerados);

		// Verificar se algum filho é válido
		for (No filho : filhos) {
		    if (filho.valido()) {
			return filho;
		    }
		}

		// Adicionar os filhos gerados na fronteira
		novaFronteira.addAll(filhos);

	    } else { // Se o nó for válido...
		// Retorna o nó
		return no;
	    }

	}
	
	// Adicionar os elementos da nova fronteira à lista dos nós gerados
	nosGerados.addAll(novaFronteira);

	// Se a nova fronteira for igual à anterior...
	if (novaFronteira.equals(fronteira)) {
	    // ...retorna null, pq não conseguiu chegar em uma conclusão
	    return null;
	} // Caso contrário...
	else {
	    // ...chama recursivamente com a nova fronteira
	    return recursaoLargura(novaFronteira);
	}

    }

    /**
     * Usado para testes...
     *
     * @param args
     */
    public static void main(String[] args) {
	Set<No> nos = new HashSet<>();
	Set<No> nos2 = new HashSet<>();

	Expressao expressao1 = new Expressao("¬A", null);
	Expressao expressao2 = new Expressao("¬B", null);
	Expressao expressao3 = new Expressao("¬C", null);
	Expressao expressao4 = new Expressao("¬D", null);

	No no1 = new No(expressao1.getPosfixa());
	No no2 = new No(expressao2.getPosfixa());
	No no3 = new No(expressao3.getPosfixa());
	No no4 = new No(expressao4.getPosfixa());

	nos.add(no1);
//	nos.add(no2);

	nos2.add(no1);
	nos2.add(no2);
	nos2.add(no3);
	nos2.add(no4);
	
	nos2.removeAll(nos);

	System.out.println("nos = " + nos);
	System.out.println("nos2 = " + nos2);

	System.out.println("equals = " + nos.equals(nos2));
	
	System.out.println("contains = " + nos2.contains(no2));
    }

}
