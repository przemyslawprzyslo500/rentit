/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miszcz
 */
@Entity
@Table(name = "EQUIPMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 150)
    @Column(name = "NAME")
    private String name;
    
    @Size(max = 10)
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "RENT_PERMISSION")
    private Character rentPermission;
    
    @JoinColumn(name = "EQUIPMENT_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EquipmentStatus equipmentStatusId;
    
    @JoinColumn(name = "LICENSE_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LicenseType licenseTypeId;
    
    @JoinColumn(name = "RESERV_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Reserv reservationReservationId;
    
    @JoinColumn(name = "USE_PLACE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UsePlace usePlaceId;

    public Equipment() {
    }

    public Equipment(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentId() {
        return id;
    }

    public void setEquipmentId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Character getRentPermission() {
        return rentPermission;
    }

    public void setRentPermission(Character rentPermission) {
        this.rentPermission = rentPermission;
    }

    public EquipmentStatus getEquipmentStatusId() {
        return equipmentStatusId;
    }

    public void setEquipmentStatusId(EquipmentStatus equipmentStatusId) {
        this.equipmentStatusId = equipmentStatusId;
    }

    public LicenseType getLicenseTypeId() {
        return licenseTypeId;
    }

    public void setLicenseTypeId(LicenseType licenseTypeId) {
        this.licenseTypeId = licenseTypeId;
    }

    public Reserv getReservationReservationId() {
        return reservationReservationId;
    }

    public void setReservationReservationId(Reserv reservationReservationId) {
        this.reservationReservationId = reservationReservationId;
    }

    public UsePlace getUsePlaceId() {
        return usePlaceId;
    }

    public void setUsePlaceId(UsePlace usePlaceId) {
        this.usePlaceId = usePlaceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.turek.liceum.wypozyczalnia.model.Equipment[ id=" + id + " ]";
    }
    
}
