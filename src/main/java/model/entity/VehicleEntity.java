package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "exdr_transport", schema = "public", catalog = "postgres")
public class VehicleEntity implements Identifiable {
    private Integer id;
    private String name;
    private String brand;
    private int yearOfIssue;
    private OwnerEntity owner;
    private TypeOfVehicleEntity type;

    @Id
    @Column(name = "id_transport")
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
    @JoinColumn(name = "type_transport")
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
