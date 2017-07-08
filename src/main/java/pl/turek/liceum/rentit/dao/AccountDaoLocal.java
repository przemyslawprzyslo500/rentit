/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.dao;

import java.util.List;
import javax.ejb.Local;
import pl.turek.liceum.rentit.model.Account;

/**
 *
 * @author miszcz
 */
@Local
public interface AccountDaoLocal {

    void addAccount(Account account);

    void editAccount(Account account);

    void deleteAccount(int accountId);

    Account getAccount(int accountId);

    List<Account> getAllAccounts();
    
}
