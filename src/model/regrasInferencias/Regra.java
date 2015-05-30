package model.regrasInferencias;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Expressao;

/**
 *
 * @author danielborges93
 */
public abstract class Regra {

    /**
     * Entradas da regra.
     */
    protected Expressao entrada1;
    protected Expressao entrada2;

    /**
     * Saída da regra.
     */
    protected Expressao saida;

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
    public abstract boolean usar(List<Expressao> proposicoes);

    /**
     * Recupera o nome da regra.
     *
     * @return Retorna o nome da regra.
     */
    public String getNome() {
	return nome;
    }

    /**
     * Recupera as entradas utilizadas pela regra.
     *
     * @return Retorna um array de <code>Expressao</code>, onde o primeiro
     * índice é a primeia entrada e o segundo índice é a segunda entrada.
     */
    public Expressao[] getEntradas() {
	Expressao[] result = {this.entrada1, this.entrada2};
	return result;
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
