package questao3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;
import model.TipoBusca;
import model.questao3.No;
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
import model.regrasInferencias.Simplificacao1;
import model.regrasInferencias.Simplificacao2;
import utils.Leitor;

/**
 *
 * @author danielborges93
 */
public class Busca {

    /**
     * Nó raiz.
     */
    private final No raiz;

    /**
     * Lista de regras de inferência.
     */
    private final List<Regra> regras;

    /**
     * Set com todas as proposições que já foram geradas, para evitar o loop.
     */
    private final Set<List<Expressao>> proposicoesGeradas;

    /**
     * Consequência lógica.
     */
    private final Expressao consequencia;

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
     * @param proposicoes Lista de proposições.
     * @param consequencia Consequência lógica.
     */
    public Busca(List<Expressao> proposicoes, String consequencia) {
	this.consequencia = new Expressao(consequencia, null);
	this.raiz = new No(proposicoes, this.consequencia);
	this.regras = new ArrayList<>();
	this.proposicoesGeradas = new HashSet<>();
	this.nosGerados = new HashSet<>();

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

	regra = new Simplificacao1();
	this.regras.add(regra);

	regra = new Simplificacao2();
	this.regras.add(regra);
    }

    /**
     * Inicia a busca.
     *
     * @param tipoBusca Tipo de busca a ser realizada. Pode ser em profundidade
     * ou em largura.
     * @return Retorna o nó com a resposta.
     */
    public No buscar(TipoBusca tipoBusca) {
	if (tipoBusca == TipoBusca.PROFUNDIDADE) {
	    return recursaoProfundidade(this.raiz);
	} else {
	    // Execução com busca em largura
	    Set<No> fronteira = new HashSet();
	    fronteira.add(this.raiz);

	    nosGerados.add(this.raiz);

	    return recursaoLargura(fronteira);
	}
    }

    /**
     * Método que é chamado recursivamente para a busca em profundidade.
     *
     * @param no <code>No</code> a ser avaliado
     * @return Retorna o nó com a resposta.
     */
    private No recursaoProfundidade(No no) {

	this.proposicoesGeradas.add(no.getProposicoes());

//	System.out.println("Vai analizar:");
//	System.out.println(no);
//	System.out.println("Proposições geradas: " + this.proposicoesGeradas);
//	Leitor.lerLinha();
	
	// Verificar se já chegou na resposta
	// Se existe apenas uma proposição e ela é igual a consequência...
	if (no.getProposicoes().size() == 1 && no.getProposicoes().get(0).equals(this.consequencia)) {
	    // ...é a resposta!
	    return no;
	}
	// Caso contrário, continua a execução...

	// Gera os filhos do nó
	List<No> filhos = no.geraFilhos(this.regras);

	// Criar uma lista com os filhos que realemente foram gerados
	List<No> filhosRealmenteGerados = new ArrayList<>();
	for (No filho : filhos) {
	    // Se as proposições não foram geradas ainda...
	    if (!this.proposicoesGeradas.contains(filho.getProposicoes())) {
		// Adiciona na lista de filhos realmente gerados
		filhosRealmenteGerados.add(filho);
	    }
	}

//	System.out.println("Filhos realmente gerados: " + filhosRealmenteGerados);
//	Leitor.lerLinha();
	
	// No resultante
	No result = null;

	// Chamar recursivamente pelos filhos
	for (No filho : filhosRealmenteGerados) {
	    result = recursaoProfundidade(filho);

	    // Se obteve um resultado...
	    if (result != null) {
		// ...para o 'for'
		this.proposicoesGeradas.add(result.getProposicoes());
		break;
	    }
	}

	return result;
    }

    /**
     * Método que é chamado recursivamente para a busca em largura.
     *
     * @param fronteira
     * @return
     */
    private No recursaoLargura(Set<No> fronteira) {

//	System.out.println("fronteira = " + fronteira.size());
//	Leitor.lerLinha();
	
	Set<No> novaFronteira = new HashSet<>();

	// Percorrer os elementos da fronteira
	for (No no : fronteira) {

	    // Verificar se já chegou na resposta
	    // Se existe apenas uma proposição e ela é igual a consequência...
	    if (no.getProposicoes().size() == 1 && no.getProposicoes().get(0).equals(this.consequencia)) {
		// ...é a resposta!
		return no;
	    }
	    // Caso contrário, continua a execução...

	    // Gera os nós filhos
	    List<No> filhos = no.geraFilhos(this.regras);

	    // Remover os nós que já foram gerados
	    filhos.removeAll(nosGerados);

	    // Verificar se algum filho é válido
	    for (No filho : filhos) {
		if (filho.getProposicoes().size() == 1 && filho.getProposicoes().get(0).equals(this.consequencia)) {
		    // ...é a resposta!
		    return filho;
		}
	    }

	    // Adicionar os filhos gerados na fronteira
	    novaFronteira.addAll(filhos);

	}
	
//	System.out.println("novaFronteira = " + novaFronteira);

	// Adicionar os elementos da nova fronteira à lista dos nós gerados
	nosGerados.addAll(novaFronteira);
	
//	System.out.println("nosGerados = " + nosGerados);
//	Leitor.lerLinha();

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
     * Testar...
     *
     * @param args
     */
    public static void main(String[] args) {
	List<String> a = new ArrayList<>();
	a.add("a");
	a.add("b");
	a.add("c");

	List<String> b = new ArrayList<>();
	b.add("a");
	b.add("c");
	b.add("b");

	System.out.println(a.equals(b));

	Set<List> set = new HashSet<>();
	set.add(a);
	set.add(b);

	System.out.println(set);
    }
}
