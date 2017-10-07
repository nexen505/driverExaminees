package com.komarmoss.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_license_of_driver", schema = "public", catalog = "postgres")
public class LicenseOfDriverEntity implements Identifiable {
    private Integer id;
    private Date dateOfIssue;
    private OwnerEntity owner;
    private List<CertificateEntity> certificates;
    private InspectionEntity inspection;

    @Id
    @Column(name = "id_license_of_driver")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_license_of_driver_seq_name")
    @SequenceGenerator(name = "id_license_of_driver_seq_name", sequenceName = "id_license_of_driver_seq", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer idLicenseOfDriver) {
        this.id = idLicenseOfDriver;
    }

    @Basic
    @Column(name = "date_of_issue")
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @OneToOne(mappedBy = "license", cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_owner")
    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "license")
    public List<CertificateEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateEntity> categories) {
        this.certificates = categories;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_inspection")
    public InspectionEntity getInspection() {
        return inspection;
    }

    public void setInspection(InspectionEntity inspection) {
        this.inspection = inspection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseOfDriverEntity that = (LicenseOfDriverEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dateOfIssue, that.dateOfIssue) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(certificates, that.certificates) &&
                Objects.equals(inspection, that.inspection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfIssue, owner, certificates, inspection);
    }
}
