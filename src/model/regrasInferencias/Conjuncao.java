package model.regrasInferencias;

import java.util.List;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class Conjuncao extends Regra {

    public Conjuncao() {
	this.nome = "Conjunção";
    }

    @Override
    public boolean usar(List<Expressao> proposicoes) {
	
	// Percorrer as proposições
	for (Expressao proposicao : proposicoes) {

	    // Verificar se já foram encontradas as duas entradas
	    if ((this.entrada1 != null) && (this.entrada2 != null)) {
		break; // Para tudo!
	    }

	    // Se a proposição tiver tamanho 1...
	    if (proposicao.getInfixa().length() == 1) {
		// ...guardo ela
		if (this.entrada1 == null) {
		    this.entrada1 = proposicao;
		} else {
		    this.entrada2 = proposicao;
		}
	    }
	}

	// Se tiverem as duas entradas
	if ((this.entrada1 != null) && (this.entrada2 != null)) {

	    // Remover as duas proposições da lista
	    proposicoes.remove(this.entrada1);
	    proposicoes.remove(this.entrada2);

	    // Cria a nova proposição
	    String novaProposicaoString = this.entrada1 + "^" + this.entrada2;
	    Expressao novaProposicao = new Expressao(novaProposicaoString, null);

	    // Adiciona na lista de proposições
	    proposicoes.add(novaProposicao);

	    return true;
	}

	return false;
    }

}
