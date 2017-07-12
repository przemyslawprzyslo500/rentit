package pl.turek.liceum.rentit.controller;

import pl.turek.liceum.rentit.model.Reserv;
import pl.turek.liceum.rentit.model.Equipment;
import java.util.Collection;
import pl.turek.liceum.rentit.facade.ReservFacade;
import pl.turek.liceum.rentit.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "reservController")
@ViewScoped
public class ReservController extends AbstractController<Reserv> {

    @Inject
    private ReservStatusController reservStatusIdController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isEquipmentCollectionEmpty;

    public ReservController() {
        // Inform the Abstract parent controller of the concrete Reserv Entity
        super(Reserv.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        reservStatusIdController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEquipmentCollectionEmpty();
    }

    public boolean getIsEquipmentCollectionEmpty() {
        return this.isEquipmentCollectionEmpty;
    }

    private void setIsEquipmentCollectionEmpty() {
        Reserv selected = this.getSelected();
        if (selected != null) {
            ReservFacade ejbFacade = (ReservFacade) this.getFacade();
            this.isEquipmentCollectionEmpty = ejbFacade.isEquipmentCollectionEmpty(selected);
        } else {
            this.isEquipmentCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Equipment entities that
     * are retrieved from Reserv and returns the navigation outcome.
     *
     * @return navigation outcome for Equipment page
     */
    public String navigateEquipmentCollection() {
        Reserv selected = this.getSelected();
        if (selected != null) {
            ReservFacade ejbFacade = (ReservFacade) this.getFacade();
            Collection<Equipment> selectedEquipmentCollection = ejbFacade.findEquipmentCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Equipment_items", selectedEquipmentCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/equipment/index";
    }

    /**
     * Sets the "selected" attribute of the ReservStatus controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareReservStatusId(ActionEvent event) {
        Reserv selected = this.getSelected();
        if (selected != null && reservStatusIdController.getSelected() == null) {
            reservStatusIdController.setSelected(selected.getReservStatusId());
        }
    }

}
