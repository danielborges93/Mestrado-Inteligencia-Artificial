package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author danielborges93
 */
public abstract class Regra {

    /**
     * Entradas da regra.
     */
    protected String entrada1;
    protected String entrada2;

    /**
     * Saída da regra.
     */
    protected String saida;

    /**
     * Usa a proposição.
     *
     * @param proposicoes Lista de proposições.
     */
    public abstract void usar(List<String> proposicoes);
    
    /**
     * Testar...
     * @param args 
     */
    public static void main(String[] args) {
	
	Pattern pattern = Pattern.compile("[a]");
	Matcher matcher = pattern.matcher("asd");
	
	System.out.println(matcher.find());
    }

}
