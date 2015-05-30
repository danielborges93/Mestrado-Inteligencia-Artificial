package model.regrasInferencias;

import java.util.List;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class Conjuncao extends Regra {

    public Conjuncao() {
//	this.entrada1 = "^([A-Z])$";
	this.nome = "Conjunção";
    }

    @Override
    public boolean usar(List<Expressao> proposicoes) {

//	// Contador
//	int count = 0;
//
//	// Armazenar as duas entradas nesse array
//	String[] entradas = new String[2];
//
//	// Percorrer as proposições
//	for (String proposicao : proposicoes) {
//
//	    // Verificar se já foram encontradas as duas entradas
//	    if (count > 1) {
//		break; // Para tudo!
//	    }
//
//	    // Se a proposição tiver tamanho 1...
//	    if (proposicao.length() == 1) {
//		// ...guardo ela
//		entradas[count++] = proposicao;
//	    }
//	}
//
//	// Se tiverem as duas entradas
//	if (count == 2) {
//
//	    // Remover as duas proposições da lista
//	    proposicoes.remove(entradas[0]);
//	    proposicoes.remove(entradas[1]);
//
//	    // Cria a nova proposição
//	    String novaProposicao = entradas[0] + "^" + entradas[1];
//
//	    // Adiciona na lista de proposições
//	    proposicoes.add(novaProposicao);
//
//	    return true;
//	}

	return false;
    }

}
