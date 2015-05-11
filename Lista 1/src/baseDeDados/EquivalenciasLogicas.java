package baseDeDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Equivalencia;

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
	equivalencia = new Equivalencia("[(]([A-Z])\\^([A-Z])[)]", "($2\\^$1)");
	equivalencias.add(equivalencia);
	
	// Comutatividade de v
	equivalencia = new Equivalencia("[(]([A-Z])v([A-Z])[)]", "($2v$1)");
	equivalencias.add(equivalencia);
	
	// Associatividade de ^
	equivalencia = new Equivalencia("[(]([A-Z])\\^([A-Z])[)]\\^([A-Z])", "$1^($2^$3)");
	equivalencias.add(equivalencia);
	
	// Associatividade de v
	equivalencia = new Equivalencia("[(]([A-Z])v([A-Z])[)]v([A-Z])", "$1v($2v$3)");
	equivalencias.add(equivalencia);
	
	// Eliminação de nageção dupla
	equivalencia = new Equivalencia("¬[(]¬([A-Z])[)]", "$1");
	equivalencias.add(equivalencia);
	equivalencia = new Equivalencia("¬¬([A-Z])", "$1");
	equivalencias.add(equivalencia);
	
	// Contraposição
	equivalencia = new Equivalencia("([A-Z])>([A-Z])", "$1^(¬$2>¬$1)");
	equivalencias.add(equivalencia);
	
	// Eliminação de implicação
	equivalencia = new Equivalencia("([A-Z])>([A-Z])", "¬$1v$2");
	equivalencias.add(equivalencia);
	
	// De Morgan
	equivalencia = new Equivalencia("¬[(]([A-Z])\\^([A-Z])[)]", "(¬$1^¬$2)");
	equivalencias.add(equivalencia);
	
	// De Morgan 2
	equivalencia = new Equivalencia("¬[(]([A-Z])v([A-Z])[)]", "(¬$1v¬$2)");
	equivalencias.add(equivalencia);
	
	// Distributividade de ^ sobre v
	equivalencia = new Equivalencia("([A-Z])\\^[(]([A-Z])v([A-Z])[)]", "($1^$2)v($1^$3)");
	equivalencias.add(equivalencia);
	
	// Distributividade de v sobre ^
	equivalencia = new Equivalencia("([A-Z])v[(]([A-Z])\\^([A-Z])[)]", "($1v$2)^($1v$3)");
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
