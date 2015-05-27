package model.equivalencia;

import java.util.HashMap;

/**
 *
 * @author danielborges93
 */
public class ComutatividadeE extends Equivalencia {

    /**
     * Com duas variáveis dos dois lados.
     */
    protected final String padraoPosfixa2;
    protected final String substituicaoPosfixa2;

    /**
     * Com duas variáveis do lado esquerdo.
     */
    protected final String padraoPosfixa3;
    protected final String substituicaoPosfixa3;

    /**
     * Com duas variáveis do lado direito.
     */
    protected final String padraoPosfixa4;
    protected final String substituicaoPosfixa4;

    public ComutatividadeE() {
	nome = "Comutatividade de ^";

//	padrao = "[(]([A-Z])\\^([A-Z])[)]";
//	substituicao = "($2\\^$1)";
	
	padraoPosfixa = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)\\^";
	substituicaoPosfixa = "$2$1^";

	padraoPosfixa2 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)([v|\\^|>])\\^";
	substituicaoPosfixa2 = "$4$5$6$1$2$3^";

	padraoPosfixa3 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(v|\\^|>)(t|f|[A-Z]¬?)\\^";
	substituicaoPosfixa3 = "$4$1$2$3^";

	padraoPosfixa4 = "(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(t|f|[A-Z]¬?)(v|\\^|>)\\^";
	substituicaoPosfixa4 = "$2$3$4$1^";

	this.padroesPosfixos = new HashMap<>();
	this.padroesPosfixos.put(padraoPosfixa, substituicaoPosfixa);
	this.padroesPosfixos.put(padraoPosfixa2, substituicaoPosfixa2);
	this.padroesPosfixos.put(padraoPosfixa3, substituicaoPosfixa3);
	this.padroesPosfixos.put(padraoPosfixa4, substituicaoPosfixa4);
    }

}
