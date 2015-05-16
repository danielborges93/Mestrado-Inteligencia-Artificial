package model.regrasInferencias;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author danielborges93
 */
public class SilogismoHipotetico extends Regra {

    public SilogismoHipotetico() {
	this.entrada1 = "^([A-Z])>([A-Z])$";
	this.nome = "Silogismo Hipotético";
    }

    @Override
    public boolean usar(List<String> proposicoes) {

	// Declarar as entradas
	String[] input = {null, null};

	// Lista de todas as proposições que possuem o formato das entradas
	List<String> entradasPossiveis = new ArrayList<>();

	// Percorrer todas as proposições
	for (String proposicao : proposicoes) {
	    // Tentar encontrar o padrão
	    Pattern pattern = Pattern.compile(this.entrada1);
	    Matcher matcher = pattern.matcher(proposicao);

	    // Se encontrar...
	    if (matcher.find()) {
		// Guarda a proposição na lista
		entradasPossiveis.add(proposicao);
	    }
	}

	// Para cada possível entrada, vai tentar encontrar a segunda entrada
	forPrincipal:
	for (String proposicao1 : entradasPossiveis) {
	    // Pegar o padrão
	    Pattern pattern = Pattern.compile(this.entrada1);
	    Matcher matcher = pattern.matcher(proposicao1);
	    matcher.find();

	    // Criar a segunda entrada e tentar encontrar
	    this.entrada2 = "^" + matcher.group(2) + ">([A-Z])$";

	    // Ver se existe alguma entrada compatível
	    for (String proposicao2 : entradasPossiveis) {
		// Só faz algo se as proposições forem diferentes
		if (!proposicao1.equals(proposicao2)) {
		    // Pegar o padrão
		    Pattern pattern2 = Pattern.compile(this.entrada2);
		    Matcher matcher2 = pattern2.matcher(proposicao2);

		    // Se encontrar...
		    if (matcher2.find()) {
			// Recupera as duas proposições para a entrada
			input[0] = proposicao1;
			input[1] = proposicao2;

			// Cria a saída
			this.saida = matcher.group(1) + ">" + matcher2.group(1);

			// Sai do for
			break forPrincipal;
		    }
		}
	    }
	}

	// Se existem as duas entradas...
	if (input[0] != null && input[1] != null) {

	    // Remove as duas entradas
	    proposicoes.remove(input[0]);
	    proposicoes.remove(input[1]);

	    // Adiciona a nova entrada
	    proposicoes.add(this.saida);

	    return true;
	}

	return false;
    }

}
