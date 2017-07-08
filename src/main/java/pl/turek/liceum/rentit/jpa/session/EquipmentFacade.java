/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.turek.liceum.rentit.model.Equipment;

/**
 *
 * @author miszcz
 */
@Stateless
public class EquipmentFacade extends AbstractFacade<Equipment> {

    @PersistenceContext(unitName = "pl.turek.liceum.rentit_RentIt_war_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipmentFacade() {
        super(Equipment.class);
    }
    
}
