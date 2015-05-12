package model.equivalencia;

import model.No;

/**
 *
 * @author danielborges93
 */
public abstract class Equivalencia {
    
    protected String padrao;
    
    protected String substituicao;
    
    public boolean matches(No no) {
	
	return false;
    }

}
