package services.impl;

import javax.ejb.Stateless;
import services.interfaces.NadiaLocal;
import services.interfaces.NadiaRemote;

/**
 * Session Bean implementation class Nadia
 */
@Stateless
public class Nadia implements NadiaRemote, NadiaLocal {

    /**
     * Default constructor. 
     */
    public Nadia() {
        // TODO Auto-generated constructor stub
    }

}
