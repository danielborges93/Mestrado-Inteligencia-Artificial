package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author danielborges93
 */
public class Destrutivo extends Construtivo {

    public Destrutivo() {
	super();
	this.nome = "Dilema Destrutivo";
    }

    @Override
    public boolean usar(List<String> proposicoes) {

	String[] groups = new String[4];
	String input1 = null;

	// Encontrar as possíveis entradas
	// Percorrer as proposições à procura da entrada 1
	for (String proposicao : proposicoes) {

	    // Detectar o padrão
	    Pattern pattern = Pattern.compile(this.entrada1);
	    Matcher matcher = pattern.matcher(proposicao);

	    // Se encontrar
	    if (matcher.find()) {
		// Recupera os grupos
		groups[0] = matcher.group(1);
		groups[1] = matcher.group(2);
		groups[2] = matcher.group(3);
		groups[3] = matcher.group(4);

		input1 = proposicao;

		// Parar o 'for'
		break;
	    }
	}

	// Tentar encontrar a segunda entrada
	String input2 = "¬" + groups[1] + "v¬" + groups[3];
	int i = proposicoes.indexOf(input2);

	// Se existe...
	if (i != -1) {
	    
	    // Cria a saída
	    this.saida = "¬" + groups[0] + "v¬" + groups[2];

	    // Remove as duas entradas
	    proposicoes.remove(input1);
	    proposicoes.remove(input2);

	    // Adciona a saída
	    proposicoes.add(this.saida);

	    return true;
	}

	return false;
    }

}
