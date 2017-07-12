/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miszcz
 */
@Entity
@Table(name = "RESERV_STATUS", catalog = "", schema = "RENTIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservStatus.findAll", query = "SELECT r FROM ReservStatus r")
    , @NamedQuery(name = "ReservStatus.findById", query = "SELECT r FROM ReservStatus r WHERE r.id = :id")
    , @NamedQuery(name = "ReservStatus.findByReservationStatusName", query = "SELECT r FROM ReservStatus r WHERE r.reservationStatusName = :reservationStatusName")})
public class ReservStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "RESERVATION_STATUS_NAME", length = 255)
    private String reservationStatusName;
    @OneToMany(mappedBy = "reservStatusId")
    private Collection<Reserv> reservCollection;

    public ReservStatus() {
    }

    public ReservStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReservationStatusName() {
        return reservationStatusName;
    }

    public void setReservationStatusName(String reservationStatusName) {
        this.reservationStatusName = reservationStatusName;
    }

    @XmlTransient
    public Collection<Reserv> getReservCollection() {
        return reservCollection;
    }

    public void setReservCollection(Collection<Reserv> reservCollection) {
        this.reservCollection = reservCollection;
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
        if (!(object instanceof ReservStatus)) {
            return false;
        }
        ReservStatus other = (ReservStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.turek.liceum.rentit.model.ReservStatus[ id=" + id + " ]";
    }
    
}
