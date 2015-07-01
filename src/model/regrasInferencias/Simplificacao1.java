package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public class Simplificacao1 extends Regra {

    /**
     * Construtor...
     */
    public Simplificacao1() {
	this.nome = "Simplificação";
    }
    
    @Override
    public boolean usar(List<Expressao> proposicoes) {
	
        // Percorrer as proposições para encontrar o padrão
        for(Expressao proposicao : proposicoes) {
            // Encontrar o padrão
            Pattern pattern = Pattern.compile("^(¬?[A-Z])v(¬?[A-Z])$");
            Matcher matcher = pattern.matcher(proposicao.getInfixa());
            
            // Se encontrar o padrão...
            if(matcher.find()) {
                // Salva a entrada
                this.entrada1 = proposicao;
		
		// Salva a saída
                this.saida = new Expressao(matcher.group(1), null);
                
                break;
            }
        }
        
        // Verifica se achou as proposições
        if(this.entrada1 != null && this.saida != null) {
            // Se encontrou, remove a proposição antiga e adiciona a nova
            proposicoes.remove(this.entrada1);
            proposicoes.add(this.saida);
            
            return true;
        }
        
        return false;
    }
    
}
