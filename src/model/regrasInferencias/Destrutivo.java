package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Expressao;

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
    public boolean usar(List<Expressao> proposicoes) {

	// Grupos encontrados pela expressão regular
	String[] groups = new String[4];
	
	// Encontrar as possíveis entradas
	// Percorrer as proposições à procura da entrada 1
	for (Expressao proposicao : proposicoes) {

	    // Detectar o padrão
	    Pattern pattern = Pattern.compile("^[(](¬?[A-Z])>(¬?[A-Z])[)]\\^[(](¬?[A-Z])>(¬?[A-Z])[)]$");
	    Matcher matcher = pattern.matcher(proposicao.getInfixa());

	    // Se encontrar
	    if (matcher.find()) {
		// Recupera os grupos
		groups[0] = matcher.group(1);
		groups[1] = matcher.group(2);
		groups[2] = matcher.group(3);
		groups[3] = matcher.group(4);

		this.entrada1 = proposicao;

		// Parar o 'for'
		break;
	    }
	}

	// Tentar encontrar a segunda entrada
	String entrada2Str = "¬" + groups[1] + "v¬" + groups[3];
	this.entrada2 = new Expressao(entrada2Str, null);
	int i = proposicoes.indexOf(this.entrada2);

	// Se existe...
	if (i != -1) {
	    
	    // Cria a saída
	    String saidaStr = "¬" + groups[0] + "v¬" + groups[2];
	    this.saida = new Expressao(saidaStr, null);

	    // Remove as duas entradas
	    proposicoes.remove(this.entrada1);
	    proposicoes.remove(this.entrada2);

	    // Adciona a saída
	    proposicoes.add(this.saida);

	    return true;
	}

	return false;
    }

}
