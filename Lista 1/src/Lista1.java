
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import questao1.Questao1;

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

        questao1();
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

    }

    private static void questao1() {
	Questao1 questao1 = new Questao1();
	questao1.exec();
    }

}
