package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class ComutatividadeOU extends Equivalencia {

    /**
     * Quando tem duas variáveis dos dois lados.
     */
    private final String padraoPosfixa2;
    private final String substituicaoPosfixa2;

    /**
     * Quando tem duas variáveis do lado esquerdo.
     */
    private final String padraoPosfixa3;
    private final String substituicaoPosfixa3;

    /**
     * Quando tem duas variáveis do lado direito.
     */
    private final String padraoPosfixa4;
    private final String substituicaoPosfixa4;

    public ComutatividadeOU() {
	nome = "Comutatividade de v";

//	padrao = "[(]([A-Z])v([A-Z])[)]";
//	substituicao = "($2v$1)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)v";
	substituicaoPosfixa = "$2$1v";

	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])v";
	substituicaoPosfixa2 = "$4$5$6$1$2$3v";

	padraoPosfixa3 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(v|\\^|>)(t|f|[A-Z]¬?)v";
	substituicaoPosfixa3 = "$4$1$2$3v";

	padraoPosfixa4 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(v|\\^|>)v";
	substituicaoPosfixa4 = "$2$3$4$1v";

	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
	this.padroesPosfixos.put(padraoPosfixa2, substituicaoPosfixa2);
	this.padroesPosfixos.put(padraoPosfixa3, substituicaoPosfixa3);
	this.padroesPosfixos.put(padraoPosfixa4, substituicaoPosfixa4);
    }

}
