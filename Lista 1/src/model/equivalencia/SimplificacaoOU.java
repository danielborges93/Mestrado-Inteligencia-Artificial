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
	Matcher matcher = pattern.matcher(no.getExpressao().getPosfixa());

	StringBuffer stringBuffer = new StringBuffer();

	// Analizar todas as ocorrências
	while (matcher.find()) {
	    // Verificar se os dois grupos são iguais
	    if (matcher.group(1).equals(matcher.group(2))) {
		matcher.appendReplacement(stringBuffer, "$1");
	    } // Verificar se um dos dois grupos é true
	    else if (matcher.group(1).equals("t") || matcher.group(2).equals("t")) {
		matcher.appendReplacement(stringBuffer, "t");
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
