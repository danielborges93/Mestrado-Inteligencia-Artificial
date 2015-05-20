package model.regrasInferencias;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author danielborges93
 */
public class Adicao extends Regra {

    @Override
    public boolean usar(List<String> proposicoes) {
	
        // Recuperar todas os enunciados
        Set<Character> enunciados = new HashSet<>();
        
        String proposicaoValida = null;
        
        // Percorrer as proposições e aproveitar para selecionar uma proposição válida
        for(String proposicao : proposicoes) {
            // Recuperar os operandos
	    for (char c : proposicao.toCharArray()) {
		/*
		 * Verificar se o caractere está no intervalo [A-Z] e
		 * é diferente de 'v'
		 */
		if (Character.isAlphabetic(c) && c != 'v') {
		    enunciados.add(c);
		}
	    }
            
            // Verificar se a proposição é válida
            if(proposicao.length() == 1) {
                proposicaoValida = proposicao;
            }
        }
        
        // Se encontrou uma proposição válida...
        if(proposicaoValida != null) {
            // Remover a proposição que vai ser utilizada do Set
            enunciados.remove(proposicaoValida.charAt(0));
            
            // Remover a proposição válida da lista de proposições e adicionar a nova
            proposicoes.remove(proposicaoValida);
            String nova = proposicaoValida + "v" + enunciados.toArray()[0];
            proposicoes.add(nova);
            
            return true;
        }
        
        return false;
    }
    
}
