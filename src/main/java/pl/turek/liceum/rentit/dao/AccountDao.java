/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.turek.liceum.rentit.model.Account;

/**
 *
 * @author miszcz
 */
@Stateless
public class AccountDao implements AccountDaoLocal {

    @PersistenceContext
    
    private EntityManager em;
    
    @Override
    public void addAccount(Account account) {
        em.persist(account);
    }

    @Override
    public void editAccount(Account account) {
        em.merge(account);
    }

    @Override
    public void deleteAccount(int accountId) {
        em.remove(getAccount(accountId));
    }

    @Override
    public Account getAccount(int accountId) {
        return em.find(Account.class, accountId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return em.createNamedQuery("Account.getAll").getResultList();
    }


}
