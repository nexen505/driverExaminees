package com.komarmoss.model.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Транспортное средство (ТС).
 */
@Entity
@Table(name = "exdr_transport", schema = "public", catalog = "postgres")
public class VehicleEntity implements Identifiable {
    /**
     * Идентификатор
     */
    private Integer id;
    /**
     * Название модели транспортного средства
     */
    private String name;
    /**
     * Марка модели транспортного средства
     */
    private String brand;
    /**
     * Год выпуска транспортного средства
     */
    private int yearOfIssue;
    /**
     * Владелец транспортного средства
     */
    private OwnerEntity owner;
    /**
     * Тип транспортного средства
     */
    private TypeOfVehicleEntity type;

    @Id
    @Column(name = "id_transport")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_transport_seq_name")
    @SequenceGenerator(name = "id_transport_seq_name", sequenceName = "id_transport_seq", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer idTransport) {
        this.id = idTransport;
    }

    @Basic
    @Column(name = "name_transport")
    public String getName() {
        return name;
    }

    public void setName(String nameTransport) {
        this.name = nameTransport;
    }

    @Basic
    @Column(name = "brand_transport")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brandTransport) {
        this.brand = brandTransport;
    }

    @Basic
    @Column(name = "year_of_issue")
    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @ManyToOne
    @JoinColumn(name = "id_owner")
    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_transport")
    public TypeOfVehicleEntity getType() {
        return type;
    }

    public void setType(TypeOfVehicleEntity type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return yearOfIssue == that.yearOfIssue &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, yearOfIssue, owner, type);
    }
}
