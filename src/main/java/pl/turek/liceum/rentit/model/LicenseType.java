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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
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
@Table(name = "LICENSE_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LicenseType.findAll", query = "SELECT l FROM LicenseType l")})
@TableGenerator(name = "LicenseTypeIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", pkColumnValue = "License_type", initialValue=10)

public class LicenseType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "LicenseTypeIdGen")
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "LICENSE_NAME")
    private String licenseName;
        
    @Size(max = 30)
    @Column(name = "LICENSE_SERIAL")
    private String licenseSerial;
    
    @Column(name = "LICENSE_START")
    @Temporal(TemporalType.DATE)
    private Date licenseStart;
    
    @Column(name = "LICENSE_END")
    @Temporal(TemporalType.DATE)
    private Date licenseEnd;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenseTypeId")
    private Collection<Equipment> equipmentCollection;

    public LicenseType() {
    }

    public LicenseType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public String getLicenseSerial() {
        return licenseSerial;
    }

    public void setLicenseSerial(String licenseSerial) {
        this.licenseSerial = licenseSerial;
    }

    public Date getLicenseStart() {
        return licenseStart;
    }

    public void setLicenseStart(Date licenseStart) {
        this.licenseStart = licenseStart;
    }

    public Date getLicenseEnd() {
        return licenseEnd;
    }

    public void setLicenseEnd(Date licenseEnd) {
        this.licenseEnd = licenseEnd;
    }

    @XmlTransient
    public Collection<Equipment> getEquipmentCollection() {
        return equipmentCollection;
    }

    public void setEquipmentCollection(Collection<Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
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
        if (!(object instanceof LicenseType)) {
            return false;
        }
        LicenseType other = (LicenseType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.turek.liceum.wypozyczalnia.model.LicenseType[ id=" + id + " ]";
    }
    
}
