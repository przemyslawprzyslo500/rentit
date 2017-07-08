/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miszcz
 */
@Entity
@Table(name = "RESERV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserv.findAll", query = "SELECT r FROM Reserv r")})
public class Reserv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "RESERVATION_MADE_DATE")
    @Temporal(TemporalType.DATE)
    private Date reservationMadeDate;
    
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    
//    @Column(name = "EQUIPMENT_ID")
//    private Integer equipmentId;
       
    @Column(name = "RESERVATION_START")
    @Temporal(TemporalType.DATE)
    private Date reservationStart;
    
    @Column(name = "RESERVATION_END")
    @Temporal(TemporalType.DATE)
    private Date reservationEnd;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationReservationId")
    private Collection<Equipment> equipmentCollection;
    
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Account accountId;
    
    @JoinColumn(name = "RESERV_STATUS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ReservStatus reservStatusId;

    public Reserv() {
    }

    public Reserv(Integer id) {
        this.id = id;
    }

    public Integer getReservationId() {
        return id;
    }

    public void setReservationId(Integer id) {
        this.id = id;
    }

    public Date getReservationMadeDate() {
        return reservationMadeDate;
    }

    public void setReservationMadeDate(Date reservationMadeDate) {
        this.reservationMadeDate = reservationMadeDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    @XmlTransient
    public Collection<Equipment> getEquipmentCollection() {
        return equipmentCollection;
    }

    public void setEquipmentCollection(Collection<Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
    }

    public Account getAccountAccountid() {
        return accountId;
    }

    public void setAccountAccountid(Account accountId) {
        this.accountId = accountId;
    }

    public ReservStatus getReservStatusId() {
        return reservStatusId;
    }

    public void setReservStatusId(ReservStatus reservStatusId) {
        this.reservStatusId = reservStatusId;
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
        if (!(object instanceof Reserv)) {
            return false;
        }
        Reserv other = (Reserv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.turek.liceum.wypozyczalnia.model.Reserv[ id=" + id + " ]";
    }
    
}
