package model.regrasInferencias;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class Adicao extends Regra {

    public Adicao() {
	this.nome = "Adição";
    }

    @Override
    public boolean usar(List<Expressao> proposicoes) {

	// Recuperar todas os enunciados
	Set<Character> enunciados = new HashSet<>();

	// Percorrer as proposições e aproveitar para selecionar uma proposição válida
	for (Expressao proposicao : proposicoes) {
	    // Recuperar os operandos
	    for (char c : proposicao.getPosfixa().toCharArray()) {
		/*
		 * Verificar se o caractere está no intervalo [A-Z] e
		 * é diferente de 'v'
		 */
		if (Character.isAlphabetic(c) && c != 'v') {
		    enunciados.add(c);
		}
	    }

	    // Verificar se a proposição é válida
	    if (proposicao.getInfixa().length() == 1) {
		this.entrada1 = proposicao;
	    }
	}

	// Se encontrou uma proposição válida...
	if (this.entrada1 != null && enunciados.size() > 1) {
	    // Remover a proposição que vai ser utilizada do Set
	    enunciados.remove(this.entrada1.getInfixa().charAt(0));

	    // Remover a proposição válida da lista de proposições e adicionar a nova
	    proposicoes.remove(this.entrada1);
	    
	    String novaString = this.entrada1 + "v" + enunciados.toArray()[0];
	    Expressao novaExpressao = new Expressao(novaString, null);
	    proposicoes.add(novaExpressao);

	    return true;
	}

	return false;
    }

}
