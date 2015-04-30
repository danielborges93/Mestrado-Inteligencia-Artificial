package baseDeDados;

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
     * Construtor privado para permitir apenas uma instância da classe.
     */
    private EquivalenciasLogicas() {
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

}
