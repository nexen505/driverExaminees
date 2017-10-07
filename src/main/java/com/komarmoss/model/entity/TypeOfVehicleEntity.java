package com.komarmoss.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_type_of_vehicle", schema = "public", catalog = "postgres")
public class TypeOfVehicleEntity implements Identifiable {
    private String id;
    private float minimumWeight;
    private float maximumWeight;
    private List<VehicleEntity> vehicles;
    private CategoryEntity category;

    @Id
    @Column(name = "type_transport")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_transport_seq_name")
    @SequenceGenerator(name = "type_transport_seq_name", sequenceName = "type_transport_seq", allocationSize = 1)
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
    public List<VehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "name_categories")
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfVehicleEntity that = (TypeOfVehicleEntity) o;
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
