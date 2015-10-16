package services.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import services.interfaces.BooLocal;
import services.interfaces.BooRemote;

/**
 * Session Bean implementation class Boo
 */
@Stateless
@LocalBean
public class Boo implements BooRemote, BooLocal {

    /**
     * Default constructor. 
     */
    public Boo() {
        // TODO Auto-generated constructor stub
    }

}
