/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.turek.liceum.rentit.dao.AccountDaoLocal;
import pl.turek.liceum.rentit.model.Account;

/**
 *
 * @author miszcz
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {
    @EJB
    private AccountDaoLocal accountDao;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        String accountIdStr = request.getParameter("accountId");
        int accountId=0;
        if (accountIdStr!=null && !accountIdStr.equals(""))
            accountId=Integer.parseInt(accountIdStr);
        //int accountId = accountIdStr.equals("") ? 0 : Integer.parseInt(accountIdStr);
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        
        Account account = new Account(login, name, surname);
        
        if("Add".equalsIgnoreCase(action)){
            accountDao.addAccount(account);
        }else if ("Edit".equalsIgnoreCase(action)){
            accountDao.editAccount(account);
        }else if ("Delete".equalsIgnoreCase(action)){
            accountDao.deleteAccount(accountId);
        }else if ("Search".equalsIgnoreCase(action)){
            account = accountDao.getAccount(accountId);
        }
        request.setAttribute("account", account);
        request.setAttribute("allAccount", accountDao.getAllAccounts());
        request.getRequestDispatcher("accountInfo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
