package model.equivalencia;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.No;

/**
 *
 * @author danielborges93
 */
public class SimplificacaoImplica extends Contraposicao {

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
		matcher.appendReplacement(stringBuffer, "t");
//		System.out.println("realizou alterações em " + getClass());
	    } // Verificar se é do tipo t>A
	    else if (group1.equals("t")) {
		matcher.appendReplacement(stringBuffer, "$2");
//		System.out.println("realizou alterações em " + getClass());
	    } // Verificar se é do tipo f>A
	    else if (group1.equals("f")) {
		matcher.appendReplacement(stringBuffer, "t");
//		System.out.println("realizou alterações em " + getClass());
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

}
