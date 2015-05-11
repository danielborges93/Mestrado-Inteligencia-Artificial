package baseDeDados;

import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * @author danielborges93
 */
public class EquivalenciasLogicas {

    /**
     * Padrão de projeto: Singleton.
     */
    private static EquivalenciasLogicas singleton;

    /**
     * Lista com todas as equivalências.
     */
    private final List<Equivalencia> equivalencias;

    /**
     * Construtor privado para permitir apenas uma instância da classe.
     */
    private EquivalenciasLogicas() {
	this.equivalencias = new ArrayList<>();

	// Instânciar todas as equivalências lógicas
	Equivalencia equivalencia;

	// Comutatividade de ^
	equivalencia = new ComutatividadeE();
	equivalencias.add(equivalencia);

	// Comutatividade de v
	equivalencia = new ComutatividadeOU();
	equivalencias.add(equivalencia);

	// Associatividade de ^
	equivalencia = new AssociatividadeE();
	equivalencias.add(equivalencia);

	// Associatividade de v
	equivalencia = new AssociatividadeOU();
	equivalencias.add(equivalencia);

	// Eliminação de nageção dupla
	equivalencia = new EliminacaoNegacaoDupla();
	equivalencias.add(equivalencia);

	// Contraposição
	equivalencia = new Contraposicao();
	equivalencias.add(equivalencia);

	// Eliminação de implicação
	equivalencia = new EliminacaoImplicacao();
	equivalencias.add(equivalencia);

	// De Morgan
	equivalencia = new Morgan1();
	equivalencias.add(equivalencia);

	// De Morgan 2
	equivalencia = new Morgan2();
	equivalencias.add(equivalencia);

	// Distributividade de ^ sobre v
	equivalencia = new DistributividadeEsobreOU();
	equivalencias.add(equivalencia);

	// Distributividade de v sobre ^
	equivalencia = new DistributividadeOUsobreE();
	equivalencias.add(equivalencia);
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

	String expressao = "(A^B)";

	Pattern pattern = Pattern.compile("([A-Z])\\^([A-Z])");
	Matcher matcher = pattern.matcher(expressao);

	matcher.find();

	System.out.print(expressao + " = ");
//	System.out.print(matcher.replaceAll("(¬$1^¬$2)") + " = ");
	System.out.println(matcher.replaceAll("$2^$1"));

    }

}
