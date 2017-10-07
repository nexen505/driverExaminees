package com.komarmoss.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_categories", schema = "public", catalog = "postgres")
public class CategoryEntity implements Identifiable {
    private String id;
    private Boolean activityFlag;
    private List<CertificateEntity> certificates;
    private List<TypeOfVehicleEntity> types;

    @Id
    @Column(name = "name_categories")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_categories_seq_name")
    @SequenceGenerator(name = "name_categories_seq_name", sequenceName = "name_categories_seq", allocationSize = 1)
    public String getId() {
        return id;
    }

    public void setId(String nameCategories) {
        this.id = nameCategories;
    }

    @Basic
    @Column(name = "activity_flag")
    public Boolean getActivityFlag() {
        return activityFlag;
    }

    public void setActivityFlag(Boolean activityFlag) {
        this.activityFlag = activityFlag;
    }

    @OneToMany(mappedBy = "category")
    public List<CertificateEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificateEntity> licenses) {
        this.certificates = licenses;
    }

    @OneToMany(mappedBy = "category")
    public List<TypeOfVehicleEntity> getTypes() {
        return types;
    }

    public void setTypes(List<TypeOfVehicleEntity> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(activityFlag, that.activityFlag) &&
                Objects.equals(certificates, that.certificates) &&
                Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activityFlag, certificates, types);
    }
}
