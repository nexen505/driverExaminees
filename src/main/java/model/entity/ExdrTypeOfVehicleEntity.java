package model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_type_of_vehicle", schema = "public", catalog = "postgres")
public class ExdrTypeOfVehicleEntity implements Identifiable {
    private String id;
    private float minimumWeight;
    private float maximumWeight;
    private List<ExdrVehicleEntity> vehicles;
    private ExdrCategoryEntity category;

    @Id
    @Column(name = "type_transport")
    public String getId() {
        return id;
    }

    public void setId(String typeTransport) {
        this.id = typeTransport;
    }

    @Basic
    @Column(name = "minimum_weight")
    public float getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(float minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    @Basic
    @Column(name = "maximum_weight")
    public float getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(float maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    @OneToMany(mappedBy = "type")
    public List<ExdrVehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<ExdrVehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "name_categories")
    public ExdrCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ExdrCategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExdrTypeOfVehicleEntity that = (ExdrTypeOfVehicleEntity) o;
        return Float.compare(that.minimumWeight, minimumWeight) == 0 &&
                Float.compare(that.maximumWeight, maximumWeight) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(vehicles, that.vehicles) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, minimumWeight, maximumWeight, vehicles, category);
    }
}
