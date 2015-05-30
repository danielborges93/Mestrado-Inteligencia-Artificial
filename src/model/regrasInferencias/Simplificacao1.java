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
//        this.entrada1 = "^(¬?[A-Z])v(¬?[A-Z])$";
	this.nome = "Simplificação";
    }
    
    @Override
    public boolean usar(List<Expressao> proposicoes) {
	
//        String proposicaoValida = null;
//        String novaProposicao = null;
//        
//        // Percorrer as proposições para encontrar o padrão
//        for(String proposicao : proposicoes) {
//            // Encontrar o padrão
//            Pattern pattern = Pattern.compile(this.entrada1);
//            Matcher matcher = pattern.matcher(proposicao);
//            
//            // Se encontrar o padrão...
//            if(matcher.find()) {
//                // ...guarda a proposição
//                proposicaoValida = proposicao;
//                novaProposicao = matcher.group(1);
//                
//                break;
//            }
//        }
//        
//        // Verifica se achou as proposições
//        if(proposicaoValida != null && novaProposicao != null) {
//            // Se encontrou, remove a proposição antiga e adiciona a nova
//            proposicoes.remove(proposicaoValida);
//            proposicoes.add(novaProposicao);
//            
//            return true;
//        }
        
        return false;
    }
    
}
