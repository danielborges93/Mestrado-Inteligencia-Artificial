package questao3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;
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
     * @return Retorna o nó com a resposta.
     */
    public No buscar() {
	return recursao(this.raiz);
    }

    /**
     * Método que é chamado recursivamente.
     *
     * @param no <code>No</code> a ser avaliado
     * @return Retorna o nó com a resposta.
     */
    private No recursao(No no) {
	
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
	for(No filho : filhos) {
	    // Se as proposições não foram geradas ainda...
	    if(!this.proposicoesGeradas.contains(filho.getProposicoes())) {
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
	    result = recursao(filho);

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
