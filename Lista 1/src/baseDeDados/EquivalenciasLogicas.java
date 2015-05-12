package baseDeDados;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.equivalencia.AssociatividadeE;
import model.equivalencia.AssociatividadeOU;
import model.equivalencia.ComutatividadeE;
import model.equivalencia.ComutatividadeOU;
import model.equivalencia.Contraposicao;
import model.equivalencia.DistributividadeEsobreOU;
import model.equivalencia.DistributividadeOUsobreE;
import model.equivalencia.EliminacaoImplicacao;
import model.equivalencia.EliminacaoNegacaoDupla;
import model.equivalencia.Equivalencia;
import model.equivalencia.Morgan1;
import model.equivalencia.Morgan2;
import model.equivalencia.SimplificacaoE;
import model.equivalencia.SimplificacaoOU;

/**
 *
 * @author danielborges93
 */
public class EquivalenciasLogicas extends ArrayList<Equivalencia>{

    /**
     * Padrão de projeto: Singleton.
     */
    private static EquivalenciasLogicas singleton;

    /**
     * Construtor privado para permitir apenas uma instância da classe.
     */
    private EquivalenciasLogicas() {
	
	// Instânciar todas as equivalências lógicas
	Equivalencia equivalencia;

	// Comutatividade de ^
	equivalencia = new ComutatividadeE();
	add(equivalencia);

	// Comutatividade de v
	equivalencia = new ComutatividadeOU();
	add(equivalencia);

	// Associatividade de ^
	equivalencia = new AssociatividadeE();
	add(equivalencia);

	// Associatividade de v
	equivalencia = new AssociatividadeOU();
	add(equivalencia);

	// Eliminação de nageção dupla
	equivalencia = new EliminacaoNegacaoDupla();
	add(equivalencia);

	// Contraposição
	equivalencia = new Contraposicao();
	add(equivalencia);

	// Eliminação de implicação
	equivalencia = new EliminacaoImplicacao();
	add(equivalencia);

	// De Morgan
	equivalencia = new Morgan1();
	add(equivalencia);

	// De Morgan 2
	equivalencia = new Morgan2();
	add(equivalencia);

	// Distributividade de ^ sobre v
	equivalencia = new DistributividadeEsobreOU();
	add(equivalencia);

	// Distributividade de v sobre ^
	equivalencia = new DistributividadeOUsobreE();
	add(equivalencia);
	
	// Simplificações de ^
	equivalencia = new SimplificacaoE();
	add(equivalencia);
	
	// Simplificações de v
	equivalencia = new SimplificacaoOU();
	add(equivalencia);
    }

    /**
     * Recupera a instância única de <code>EquivalenciasLogicas</code>.
     *
     * @return Retorna a instância de <code>EquivalenciasLogicas</code>.
     */
    public static EquivalenciasLogicas getInstance() {
	if (singleton == null) {
	    singleton = new EquivalenciasLogicas();
	}
	return singleton;
    }

    /**
     * Utilizado para testar...
     *
     * @param args
     */
    public static void main(String[] args) {

	String expressao = "ABC^v";

	Pattern pattern = Pattern.compile("([A-Z])([A-Z])([A-Z])\\^v");
	Matcher matcher = pattern.matcher(expressao);

	System.out.println(matcher.find());

	System.out.print(expressao + " = ");
//	System.out.print(matcher.replaceAll("$1$2¬$1¬>^") + " = ");
	System.out.println(matcher.replaceAll("$1$2v$1$3v^"));

    }

}
