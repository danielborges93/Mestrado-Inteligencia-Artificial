package utils.posfixa;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementação da pilha para ser utilizada na conversão da expressão da forma
 * infixa para a posfixa.
 *
 * @author danielborges93
 */
public class Pilha {

    /**
     * Lista de caracteres contidos na pilha.
     */
    private List<Character> caracteres = new LinkedList<>();

    /**
     * Empilha um elemento na pilha.
     *
     * @param c Caractere a ser empilhado.
     */
    public void empilha(char c) {
	// Adicionar o caractere na lista
	this.caracteres.add(c);
    }

    /**
     * Desempilha um elemento da pilha.
     *
     * @return Caractere do topo da pilha.
     */
    public char desempilha() {
	// Recuperar o tamanho atual da pilha
	int tamanho = this.caracteres.size();

	// Remover e recuperar o último caractere da pilha
	char c = this.caracteres.remove(tamanho - 1);

	// Retornar o caractere
	return c;
    }

    /**
     * Verifica se a pilha está vazia ou não.
     *
     * @return <code>true</code> se a pilha está vazia. Caso contrário,
     * <code>false</code>.
     */
    public boolean vazia() {
	// Verificar se está vazia
	return this.caracteres.isEmpty();
    }

    /**
     * Recupera o caractere que está no topo da pilha.
     *
     * @return Retorna o caractere que está no topo da pilha.
     */
    public char topo() {
	// Recuperar o tamanho atual da pilha
	int tamanho = this.caracteres.size();

	// Recuperar o último caractere da pilha
	char c = this.caracteres.get(tamanho - 1);

	// Retornar o caractere
	return c;
    }
    
    @Override
    public String toString() {
	return this.caracteres.toString();
    }

}
