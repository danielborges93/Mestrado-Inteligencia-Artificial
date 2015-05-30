package model.regrasInferencias;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class SilogismoHipotetico extends Regra {

    public SilogismoHipotetico() {
	this.nome = "Silogismo Hipotético";
    }

    @Override
    public boolean usar(List<Expressao> proposicoes) {

	// Lista de todas as proposições que possuem o formato das entradas
	List<Expressao> entradasPossiveis = new ArrayList<>();

	// Percorrer todas as proposições
	for (Expressao proposicao : proposicoes) {
	    // Tentar encontrar o padrão
	    Pattern pattern = Pattern.compile("^(¬?.+)>(¬?.+)$");
	    Matcher matcher = pattern.matcher(proposicao.getInfixa());

	    // Se encontrar...
	    if (matcher.find()) {
		// Guarda a proposição na lista
		entradasPossiveis.add(proposicao);
	    }
	}

	// Para cada possível entrada, vai tentar encontrar a segunda entrada
	forPrincipal:
	for (Expressao proposicao1 : entradasPossiveis) {
	    // Pegar o padrão
	    Pattern pattern = Pattern.compile("^(¬?.+)>(¬?.+)$");
	    Matcher matcher = pattern.matcher(proposicao1.getInfixa());
	    matcher.find();

	    // Criar a segunda entrada e tentar encontrar
	    String patternStr2 = "^" + matcher.group(2) + ">(¬?.+)$";

	    // Ver se existe alguma entrada compatível
	    for (Expressao proposicao2 : entradasPossiveis) {
		// Só faz algo se as proposições forem diferentes
		if (!proposicao1.equals(proposicao2)) {
		    // Pegar o padrão
		    Pattern pattern2 = Pattern.compile(patternStr2);
		    Matcher matcher2 = pattern2.matcher(proposicao2.getInfixa());

		    // Se encontrar...
		    if (matcher2.find()) {
			// Recupera as duas proposições para a entrada
			this.entrada1 = proposicao1;
			this.entrada2 = proposicao2;

			// Cria a saída
			this.saida = new Expressao(matcher.group(1) + ">" + matcher2.group(1), null);

			// Sai do for
			break forPrincipal;
		    }
		}
	    }
	}

	// Se existem as duas entradas...
	if (this.entrada1 != null && this.entrada2 != null) {

	    // Remove as duas entradas
	    proposicoes.remove(this.entrada1);
	    proposicoes.remove(this.entrada2);

	    // Adiciona a nova entrada
	    proposicoes.add(this.saida);

	    return true;
	}

	return false;
    }

}
