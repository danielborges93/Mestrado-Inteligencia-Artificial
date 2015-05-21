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
     * Nome da regra.
     */
    protected String nome;

    /**
     * Usa a proposição.
     *
     * @param proposicoes Lista de proposições.
     * @return Retorna <code>true</code> se a regra foi utilizada. Caso
     * contrário, <code>false</code>.
     */
    public abstract boolean usar(List<String> proposicoes);

    /**
     * Recupera o nome da regra.
     * @return Retorna o nome da regra.
     */
    public String getNome() {
	return nome;
    }

    /**
     * Testar...
     *
     * @param args
     */
    public static void main(String[] args) {

	Pattern pattern = Pattern.compile("[a]");
	Matcher matcher = pattern.matcher("asd");

	System.out.println(matcher.find());
    }

}
