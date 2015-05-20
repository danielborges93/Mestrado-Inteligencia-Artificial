package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author danielborges93
 */
public class Simplificacao2 extends Regra {

    /**
     * Construtor...
     */
    public Simplificacao2() {
        this.entrada1 = "^(¬?[A-Z])v(¬?[A-Z])$";
    }
    
    @Override
    public boolean usar(List<String> proposicoes) {
	
        String proposicaoValida = null;
        String novaProposicao = null;
        
        // Percorrer as proposições para encontrar o padrão
        for(String proposicao : proposicoes) {
            // Encontrar o padrão
            Pattern pattern = Pattern.compile(this.entrada1);
            Matcher matcher = pattern.matcher(proposicao);
            
            // Se encontrar o padrão...
            if(matcher.find()) {
                // ...guarda a proposição
                proposicaoValida = proposicao;
                novaProposicao = matcher.group(2);
                
                break;
            }
        }
        
        // Verifica se achou as proposições
        if(proposicaoValida != null && novaProposicao != null) {
            // Se encontrou, remove a proposição antiga e adiciona a nova
            proposicoes.remove(proposicaoValida);
            proposicoes.add(novaProposicao);
            
            return true;
        }
        
        return false;
    }
    
}
