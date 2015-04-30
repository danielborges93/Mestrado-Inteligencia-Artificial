
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danielborges93
 */
public class Lista1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        questao1();
//        
//        String str = "Av(B^C)";
//        String[] arr = str.split("[A-Z]");
//	
//        Pattern pattern = Pattern.compile("([A-Z]*)");
//        Matcher matcher = pattern.matcher(str);
//        System.out.println(matcher.groupCount());
//	System.out.println(Arrays.toString(arr));
//	System.out.println(arr.length);
//	
//	for (char c : str.toCharArray()) {
//	    System.out.println(c + " " + (Character.isAlphabetic(c) && c!='v'));
//	}
//	
//        str = str.replaceFirst("([A-Z]v\\([A-Z]\\^[A-Z]\\))", "(AvB)^(AvC)");
//        System.out.println(str);
	int qtd = 4;
	int qtdNumeros = (int) Math.pow(2, qtd);
	boolean[][] tabelaVerdade = new boolean[qtdNumeros][qtd];

	for (int j = 0; j < qtd; j++) {
	    int passo = (int) Math.pow(2, j);
	    boolean zero = false;
	    
	    for (int i = 0; i < qtdNumeros; i++) {
		if (i % passo == 0) {
		    zero = !zero;
		}
		
		tabelaVerdade[i][j] = !zero;
	    }
	}
	
	for (boolean[] linha : tabelaVerdade) {
	    for (int i=0; i<linha.length/2; i++) {
		boolean temp = linha[i];
		linha[i] = linha[linha.length-i-1];
		linha[linha.length-i-1] = temp;
	    }
	}

	for (int i = 0; i < qtdNumeros; i++) {
	    for (int j=0; j<qtd; j++) {
		System.out.print(tabelaVerdade[i][j] + "\t");
	    }
	    System.out.println("");
	}

    }

    private static void questao1() {

    }

}
