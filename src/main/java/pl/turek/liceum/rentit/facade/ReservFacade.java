/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.turek.liceum.rentit.model.Reserv;
import pl.turek.liceum.rentit.model.Reserv_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Date;
import pl.turek.liceum.rentit.model.Equipment;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.model.ReservStatus;

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

    public boolean isEquipmentIdEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotNull(reserv.get(Reserv_.equipmentId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Equipment findEquipmentId(Reserv entity) {
        return this.getMergedEntity(entity).getEquipmentId();
    }

    public boolean isReservationIdEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.reservationId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Integer findReservationId(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Integer reservationId = mergedEntity.getReservationId();
//        reservationId.size();
        return reservationId;
    }

    public boolean isReservationMadeDateEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.reservationMadeDate)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Date findReservationMadeDate(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Date reservationMadeDate = mergedEntity.getReservationMadeDate();
//        reservationMadeDate.size();
        return reservationMadeDate;
    }

    public boolean isDescriptionEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.description)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public String findDescription(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        String description = mergedEntity.getDescription();
//        description.size();
        return description;
    }

    public boolean isIdEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.id)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Integer findId(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Integer id = mergedEntity.getId();
//        id.size();
        return id;
    }

    public boolean isReservationStartEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.reservationStart)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Date findReservationStart(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Date reservationStart = mergedEntity.getReservationStart();
//        reservationStart.size();
        return reservationStart;
    }

    public boolean isReservationEndEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.reservationEnd)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Date findReservationEnd(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Date reservationEnd = mergedEntity.getReservationEnd();
//        reservationEnd.size();
        return reservationEnd;
    }

    public boolean isEquipmentCollectionEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.equipmentCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Equipment> findEquipmentCollection(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Collection<Equipment> equipmentCollection = mergedEntity.getEquipmentCollection();
        equipmentCollection.size();
        return equipmentCollection;
    }

    public boolean isAccountAccountidEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
//        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotEmpty(reserv.get(Reserv_.accountAccountid)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Account findAccountAccountid(Reserv entity) {
        Reserv mergedEntity = this.getMergedEntity(entity);
        Account accountAccountid = mergedEntity.getAccountAccountid();
        accountAccountid.size();
        return accountAccountid;
    }

    public boolean isReservStatusIdEmpty(Reserv entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Reserv> reserv = cq.from(Reserv.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(reserv, entity), cb.isNotNull(reserv.get(Reserv_.reservStatusId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ReservStatus findReservStatusId(Reserv entity) {
        return this.getMergedEntity(entity).getReservStatusId();
    }
    
}
