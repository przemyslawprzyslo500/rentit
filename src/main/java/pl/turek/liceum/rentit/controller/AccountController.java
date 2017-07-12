package pl.turek.liceum.rentit.controller;

import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.facade.AccountFacade;
import pl.turek.liceum.rentit.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "accountController")
@ViewScoped
public class AccountController extends AbstractController<Account> {

    @Inject
    private MobilePageController mobilePageController;

    public AccountController() {
        // Inform the Abstract parent controller of the concrete Account Entity
        super(Account.class);
    }

}
