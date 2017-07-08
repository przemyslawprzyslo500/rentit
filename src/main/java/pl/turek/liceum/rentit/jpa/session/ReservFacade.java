/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.turek.liceum.rentit.model.Reserv;

/**
 *
 * @author miszcz
 */
@Stateless
public class ReservFacade extends AbstractFacade<Reserv> {

    @PersistenceContext(unitName = "pl.turek.liceum.rentit_RentIt_war_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservFacade() {
        super(Reserv.class);
    }
    
}
