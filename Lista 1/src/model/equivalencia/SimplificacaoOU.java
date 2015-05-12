package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.No;

/**
 *
 * @author danielborges93
 */
public class SimplificacaoOU extends ComutatividadeOU {

    @Override
    public String matches(No no) {

	// Criar o padrão
	Pattern pattern = Pattern.compile(padraoPosfixa);
	Matcher matcher = pattern.matcher(no.getExpressao());

	StringBuffer stringBuffer = new StringBuffer();

	// Analizar todas as ocorrências
	while (matcher.find()) {

	    String group1 = matcher.group(1);
	    String group2 = matcher.group(2);

	    // Verificar se os dois grupos são iguais
	    if (group1.equals(group2)) {
		matcher.appendReplacement(stringBuffer, "$1");
		System.out.println("realizou alterações em " + getClass());
	    } // Verificar se um dos dois grupos é true
	    else if (group1.equals("t") || group2.equals("t")) {
		matcher.appendReplacement(stringBuffer, "t");
		System.out.println("realizou alterações em " + getClass());
	    } // Verificar se é do tipo ¬AvA
	    else if (group1.equals("¬" + group2) || group2.equals("¬" + group1)) {
		matcher.appendReplacement(stringBuffer, "t");
		System.out.println("realizou alterações em " + getClass());
	    } // Verificar se é do tipo Avf ou fvA
	    else if (group1.equals("f")) {
		matcher.appendReplacement(stringBuffer, "$2");
		System.out.println("realizou alterações em " + getClass());
	    } else if (group2.equals("f")) {
		matcher.appendReplacement(stringBuffer, "$1");
		System.out.println("realizou alterações em " + getClass());
	    }
	}

	matcher.appendTail(stringBuffer);

	// Retornar
	if (stringBuffer.toString().equals("")) {
	    return null;
	} else {
	    return stringBuffer.toString();
	}
    }

    /**
     * Testar...
     *
     * @param args
     */
    public static void main(String[] args) {
	String pos = "AB^AA^Bf^vv";

	SimplificacaoOU se = new SimplificacaoOU();

	// Criar o padrão
	Pattern pattern = Pattern.compile(se.padraoPosfixa);
	Matcher matcher = pattern.matcher(pos);

	StringBuffer stringBuffer = new StringBuffer();

	// Analizar todas as ocorrências
	while (matcher.find()) {

	    // Verificar se os dois grupos são iguais
	    if (matcher.group(1).equals(matcher.group(2))) {
		matcher.appendReplacement(stringBuffer, "$1");
	    } // Verificar se um dos dois grupos é false
	    else if (matcher.group(1).equals("f") || matcher.group(2).equals("f")) {
		matcher.appendReplacement(stringBuffer, "f");
	    }
	}

	matcher.appendTail(stringBuffer);

	System.out.println(stringBuffer.toString());

    }
}
