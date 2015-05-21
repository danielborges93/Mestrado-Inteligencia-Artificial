package questao2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Leitor;

/**
 *
 * @author danielborges93
 */
public class Questao2 {

    /**
     * Executa a questão.
     *
     * @return Retorna um array de <code>String</code> com duas posições, a
     * primeira com as proposições e a segunda com a consequência.
     */
    public String[] exec() {

	System.out.println("Digite em português...");

	List<String> linhas = new ArrayList<>();

	// Ler linha por linha, onde cada linha é uma proposição.
	// A última linha vai conter o formato "Logo, (...)", que é a consequência
	while (true) {
	    // Ler a linha
	    String linha = Leitor.lerLinha();
	    linhas.add(linha);

	    // Verificar se é começa com "logo, "
	    if (linha.length() > 6 && linha.substring(0, 6).equals("logo, ")) {
		// Para a execução
		break;
	    }
	}

	// Declarar os padrões
	Pattern seEntaoPattern = Pattern.compile("^se (não )?(.+), então (não )?(.+)$");
	Pattern eOuPattern = Pattern.compile("^(não )?(.+) (e|ou) (não )?(.+)$");
	Pattern afirmacaoPattern = Pattern.compile("^(não )?(.+)$");
	Pattern consequenciaEOuPattern = Pattern.compile("^logo, (não )?(.+) (e|ou) (não )?(.+)$");
	Pattern consequenciaAfirmacaoPattern = Pattern.compile("^logo, (não )?(.+)$");

	// Set para guardar os operandos
	Set<String> operandos = new HashSet<>();

	// Ir de linha em linha encontrando os padrões e guardando no Set
	for (String linha : linhas) {
	    // tentar encontrar os padrões...
	    Matcher matcher = consequenciaEOuPattern.matcher(linha);
	    if (matcher.find()) {
		// Salvar o que encontrou
		operandos.add(matcher.group(2));
		operandos.add(matcher.group(5));

		// Ir para a próxima linha
		continue;
	    }

	    matcher = consequenciaAfirmacaoPattern.matcher(linha);
	    if (matcher.find()) {
		// Salvar o que encontrou
		operandos.add(matcher.group(2));

		// Ir para a próxima linha
		continue;
	    }

	    matcher = eOuPattern.matcher(linha);
	    if (matcher.find()) {
		// Salvar o que encontrou
		operandos.add(matcher.group(2));
		operandos.add(matcher.group(5));

		// Ir para a próxima linha
		continue;
	    }

	    matcher = seEntaoPattern.matcher(linha);
	    if (matcher.find()) {
		// Salvar o que encontrou
		operandos.add(matcher.group(2));
		operandos.add(matcher.group(4));

		// Ir para a próxima linha
		continue;
	    }

	    matcher = afirmacaoPattern.matcher(linha);
	    if (matcher.find()) {
		// Salvar o que encontrou
		operandos.add(matcher.group(2));
	    }
	}

	// Mapear os operandos
	Map<String, String> map = new HashMap<>();

	char controle = 65;
	for (String operando : operandos) {
	    map.put(operando, "" + controle++);
	}

	// Gerar as proposições e a consequência...
	// Gerador das proposições
	StringBuilder proposicoesBuilder = new StringBuilder();

	// Consequência
	String consequencia = null;

	// Percorrer as linhas, detectando os padrões e criando as expressões lógicas
	for (String linha : linhas) {

	    // tentar encontrar os padrões...
	    Matcher matcher = consequenciaEOuPattern.matcher(linha);
	    if (matcher.find()) {
		// Recuperar os grupos
		String[] group = {
		    ((matcher.group(1) == null) ? "" : "¬"),
		    map.get(matcher.group(2)),
		    ((matcher.group(3).equals("e")) ? "^" : "v"),
		    ((matcher.group(4) == null) ? "" : "¬"),
		    map.get(matcher.group(5))
		};

		// Criar a consequência
		consequencia = ""
			+ group[0] + group[1]  // ¬A
			+ group[2]	       //  ^
			+ group[3] + group[4]; // ¬B

		// Ir para a próxima linha
		continue;
	    }

	    matcher = consequenciaAfirmacaoPattern.matcher(linha);
	    if (matcher.find()) {
		// Recuperar os grupos
		String[] group = {
		    ((matcher.group(1) == null) ? "" : "¬"),
		    map.get(matcher.group(2))
		};

		// Criar a consequência
		consequencia = ""
			+ group[0] + group[1]; // ¬A

		// Ir para a próxima linha
		continue;
	    }

	    matcher = eOuPattern.matcher(linha);
	    if (matcher.find()) {
		// Recuperar os grupos
		String[] group = {
		    ((matcher.group(1) == null) ? "" : "¬"),
		    map.get(matcher.group(2)),
		    ((matcher.group(3).equals("e")) ? "^" : "v"),
		    ((matcher.group(4) == null) ? "" : "¬"),
		    map.get(matcher.group(5))
		};

		// Criar a proposição
		proposicoesBuilder
			.append(group[0]).append(group[1])  // ¬A
			.append(group[2])		    //  ^
			.append(group[3]).append(group[4]); // ¬B
		
		proposicoesBuilder.append(", ");
		
		// Ir para a próxima linha
		continue;
	    }

	    matcher = seEntaoPattern.matcher(linha);
	    if (matcher.find()) {
		// Recuperar os grupos
		String[] group = {
		    ((matcher.group(1) == null) ? "" : "¬"),
		    map.get(matcher.group(2)),
		    ((matcher.group(3) == null) ? "" : "¬"),
		    map.get(matcher.group(4))
		};

		// Criar a proposição
		proposicoesBuilder
			.append(group[0]).append(group[1])  // ¬A
			.append(">")			    //  >
			.append(group[2]).append(group[3]); // ¬B
		
		proposicoesBuilder.append(", ");
		
		// Ir para a próxima linha
		continue;
	    }

	    matcher = afirmacaoPattern.matcher(linha);
	    if (matcher.find()) {
		// Recuperar os grupos
		String[] group = {
		    ((matcher.group(1) == null) ? "" : "¬"),
		    map.get(matcher.group(2))
		};

		// Criar a proposição
		proposicoesBuilder
			.append(group[0]).append(group[1]); // ¬A
		
		proposicoesBuilder.append(", ");
		
	    }

	}
	
	// Remover o último ", " das proposições
	proposicoesBuilder.delete(proposicoesBuilder.length()-2, proposicoesBuilder.length());
	
	// Declarar a variável de retorno
	String[] retorno = {proposicoesBuilder.toString(), consequencia};
	
	// Retornar
	return retorno;
    }

    /**
     * Testar...
     *
     * @param args
     */
    public static void main(String[] args) {

	StringBuilder b = new StringBuilder();
	b.append("asd, asd, asd, asd, ");
	System.out.println(b.toString());
	
	b.delete(b.length()-2, b.length());
	System.out.println(b.toString());

	Pattern pattern = Pattern.compile("^logo, (não )?(.+) (e|ou) (não )?(.+)$");
	Matcher matcher = pattern.matcher("logo, chove e faz sol");
	matcher.find();

	System.out.println("group 1: " + matcher.group(1));
	System.out.println("group 2: " + matcher.group(2));
	System.out.println("group 3: " + matcher.group(3));
	System.out.println("group 4: " + matcher.group(4));
	System.out.println("group 5: " + matcher.group(5));
    }

}
