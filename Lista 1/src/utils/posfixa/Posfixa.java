package utils.posfixa;

/**
 * Classe que implementa a conversão de uma expressão infixa para uma posfixa.
 * <br/>
 * <br/>
 *
 * <b>Prioridade dos operadores:</b>
 * <br/>
 * 1. ¬ (negação)<br/>
 * 2. ˆ (e)<br/>
 * 3. ˇ (ou)<br/>
 * 4. > (implica)
 * <br/>
 * <br/>
 *
 * @author danielborges93
 */
public class Posfixa {

    /**
     * String que representa a expressão na forma infixa.
     */
    private String infixa;

    /**
     * String que representa a expressão na forma posfixa.
     */
    private String posfixa;

    /**
     * Pilha de parênteses e operadores.
     */
    private Pilha pilha;

}
