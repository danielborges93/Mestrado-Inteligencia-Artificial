package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author danielborges93
 */
public class ModusPonens extends Regra {

    public ModusPonens() {
	this.entrada1 = "^(¬?[A-Z])>(¬?[A-Z])$";
	this.nome = "Modus Ponens";
    }

    @Override
    public boolean usar(List<String> proposicoes) {

	// Declarar as duas entradas
	String[] input = new String[2];

	// Boolean que diz se encontrou ou não
	boolean[] encontrou = {false, false};

	// Percorrer as proposições
	for (String proposicao : proposicoes) {
	    // Tentar encontrar o padrão
	    Pattern pattern = Pattern.compile(this.entrada1);
	    Matcher matcher = pattern.matcher(proposicao);
	    
	    // Se encontrar
	    if (matcher.find()) {
		// Salvar as entradas
		input[0] = proposicao;
		input[1] = matcher.group(1);
		this.saida = matcher.group(2);

		encontrou[0] = true;

		// Para o 'for'
		break;
	    }

	}

	// Tenta achar a segunda entrada
	encontrou[1] = proposicoes.contains(input[1]);

	// Se encontrou as duas entradas
	if (encontrou[0] && encontrou[1]) {
	    
	    // Remove as entradas da lista
	    proposicoes.remove(input[0]);
	    proposicoes.remove(input[1]);

	    // Salva a saída
	    proposicoes.add(this.saida);

	    return true;
	}

	return false;
    }

}
