package model.regrasInferencias;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class ModusPonens extends Regra {

    public ModusPonens() {
	this.nome = "Modus Ponens";
    }

    @Override
    public boolean usar(List<Expressao> proposicoes) {
	
	// Boolean que diz se encontrou ou não
	boolean[] encontrou = {false, false};

	// Percorrer as proposições
	for (Expressao proposicao : proposicoes) {
	    // Tentar encontrar o padrão
	    Pattern pattern = Pattern.compile("^(¬?.+)>(¬?.+)$");
	    Matcher matcher = pattern.matcher(proposicao.getInfixa());
	    
	    // Se encontrar
	    if (matcher.find()) {
		// Salvar as entradas
		this.entrada1 = proposicao;
		this.entrada2 = new Expressao(matcher.group(1), null);
		
		// Salvar a saída
		this.saida = new Expressao(matcher.group(2), null);

		encontrou[0] = true;

		// Para o 'for'
		break;
	    }

	}

	// Tenta achar a segunda entrada
	encontrou[1] = proposicoes.contains(this.entrada2);

	// Se encontrou as duas entradas
	if (encontrou[0] && encontrou[1]) {
	    
	    // Remove as entradas da lista
	    proposicoes.remove(this.entrada1);
	    proposicoes.remove(this.entrada2);

	    // Salva a saída
	    proposicoes.add(this.saida);

	    return true;
	}

	return false;
    }

}
