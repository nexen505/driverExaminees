package com.komarmoss.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_inspection", schema = "public", catalog = "postgres")
public class InspectionEntity implements Identifiable {
    private Integer id;
    private String name;
    private String address;
    private List<LicenseOfDriverEntity> licenses;

    @Id
    @Column(name = "id_inspection")
    public Integer getId() {
        return id;
    }

    public void setId(Integer idInspection) {
        this.id = idInspection;
    }

    @Basic
    @Column(name = "name_inspection")
    public String getName() {
        return name;
    }

    public void setName(String nameInspection) {
        this.name = nameInspection;
    }

    @Basic
    @Column(name = "address_inspection")
    public String getAddress() {
        return address;
    }

    public void setAddress(String addressInspection) {
        this.address = addressInspection;
    }

    @OneToMany(mappedBy = "inspection")
    public List<LicenseOfDriverEntity> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseOfDriverEntity> licenses) {
        this.licenses = licenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InspectionEntity that = (InspectionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(licenses, that.licenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, licenses);
    }
}
