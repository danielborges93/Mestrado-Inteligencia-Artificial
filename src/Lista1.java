
import questao1.Questao1;
import questao2.Questao2;
import questao3.Questao3;
import utils.Leitor;

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

	// Ler todas as proposições
	System.out.println("Digite as proposições: ");
	String proposicoesString = Leitor.lerLinha();

	// Ler a consequência
	System.out.println("Digite a consequência: ");
	String consequenciaStr = Leitor.lerLinha();

	Questao1 questao1 = new Questao1();
//	questao1.exec(proposicoesString, consequenciaStr);
	
	Questao3 questao3 = new Questao3();
//	questao3.exec(proposicoesString, consequenciaStr);
	
	Questao2 questao2 = new Questao2();
	String[] result = questao2.exec();
	
	System.out.println("");
	System.out.println("resultado do mapeamento:");
	System.out.println("proposições: " + result[0]);
	System.out.println("consequência: " + result[1]);
	System.out.println("");
	
	// Jogar na primeira questão
        questao1 = new Questao1();
	questao1.exec(result[0], result[1]);
        
        // Jogar na terceira questão
        questao3 = new Questao3();
        questao3.exec(result[0], result[1]);
	
    }

}
