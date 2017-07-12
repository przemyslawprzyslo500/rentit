package pl.turek.liceum.rentit.controller;

import pl.turek.liceum.rentit.model.Equipment;
import pl.turek.liceum.rentit.facade.EquipmentFacade;
import pl.turek.liceum.rentit.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "equipmentController")
@ViewScoped
public class EquipmentController extends AbstractController<Equipment> {

    @Inject
    private LicenseTypeController licenseTypeIdController;
    @Inject
    private ReservController reservationReservationIdController;
    @Inject
    private UsePlaceController usePlaceIdController;
    @Inject
    private MobilePageController mobilePageController;

    public EquipmentController() {
        // Inform the Abstract parent controller of the concrete Equipment Entity
        super(Equipment.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        licenseTypeIdController.setSelected(null);
        reservationReservationIdController.setSelected(null);
        usePlaceIdController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the LicenseType controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLicenseTypeId(ActionEvent event) {
        Equipment selected = this.getSelected();
        if (selected != null && licenseTypeIdController.getSelected() == null) {
            licenseTypeIdController.setSelected(selected.getLicenseTypeId());
        }
    }

    /**
     * Sets the "selected" attribute of the Reserv controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareReservationReservationId(ActionEvent event) {
        Equipment selected = this.getSelected();
        if (selected != null && reservationReservationIdController.getSelected() == null) {
            reservationReservationIdController.setSelected(selected.getReservationReservationId());
        }
    }

    /**
     * Sets the "selected" attribute of the UsePlace controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUsePlaceId(ActionEvent event) {
        Equipment selected = this.getSelected();
        if (selected != null && usePlaceIdController.getSelected() == null) {
            usePlaceIdController.setSelected(selected.getUsePlaceId());
        }
    }

}
