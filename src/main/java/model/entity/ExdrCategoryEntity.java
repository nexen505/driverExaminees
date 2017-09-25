package model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_categories", schema = "public", catalog = "postgres")
public class ExdrCategoryEntity implements Identifiable {
    private String id;
    private Boolean activityFlag;
    private List<ExdrCertificateEntity> certificates;
    private List<ExdrTypeOfVehicleEntity> types;

    @Id
    @Column(name = "name_categories")
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
    public List<ExdrCertificateEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<ExdrCertificateEntity> licenses) {
        this.certificates = licenses;
    }

    @OneToMany(mappedBy = "category")
    public List<ExdrTypeOfVehicleEntity> getTypes() {
        return types;
    }

    public void setTypes(List<ExdrTypeOfVehicleEntity> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExdrCategoryEntity that = (ExdrCategoryEntity) o;
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
