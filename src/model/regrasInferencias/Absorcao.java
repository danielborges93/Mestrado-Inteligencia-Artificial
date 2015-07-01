package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class Absorcao extends Regra {

    public Absorcao() {
	this.nome = "Absorção";
    }
    
    @Override
    public boolean usar(List<Expressao> proposicoes) {
	
	// Percorrer a lista
	for (Expressao proposicao : proposicoes) {
	    
	    // Detectar o padrão
	    Pattern pattern = Pattern.compile("^([A-Z])>([A-Z])$");
	    Matcher matcher = pattern.matcher(proposicao.getInfixa());
	    
	    // Se foi detectado o padrão...
	    if(matcher.find()) {
		// Salvar a entrada
		this.entrada1 = proposicao;
		break;
	    }
	}
	
	// Verifica se achou a entrada
	if (this.entrada1 != null) {
	    // Se sim...
	    
	    // Remove a entrada da lista
	    proposicoes.remove(this.entrada1);
	    
	    // Cria a nova proposição
	    Pattern pattern = Pattern.compile("^([A-Z])>([A-Z])$");
	    Matcher matcher = pattern.matcher(this.entrada1.getInfixa());
	    
	    // Recupera a nova expressão em String
	    String saidaString = matcher.replaceAll("$1>($1^$2)");
	    
	    // Cria a nova Expressão e adiciona na lista de proposições
	    this.saida = new Expressao(saidaString, null);
	    proposicoes.add(this.saida);
	    
	    return true;
	}
	
	return false;
    }
    
}
