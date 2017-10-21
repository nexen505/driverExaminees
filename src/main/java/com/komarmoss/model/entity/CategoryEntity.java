package com.komarmoss.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Категория водительского удостоверения. Определяет типы ТС, допустимых к вождению владельцем удостоверения.
 */
@Entity
@Table(name = "exdr_categories", schema = "public", catalog = "postgres")
public class CategoryEntity implements Identifiable {
    /**
     * Идентификатор
     */
    private Integer id;
    /**
     * Название категории
     */
    private String name;
    /**
     * Типы ТС, допущенные к управлению с данной категорией
     */
    private List<TypeOfVehicleEntity> types;
    /**
     * Водительские удостоверения с данной категорией
     */
    private List<LicenseOfDriverEntity> licenses;

    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_categories_seq_name")
    @SequenceGenerator(name = "name_categories_seq_name", sequenceName = "name_categories_seq", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    public List<TypeOfVehicleEntity> getTypes() {
        return types;
    }

    public void setTypes(List<TypeOfVehicleEntity> types) {
        this.types = types;
    }

    @ManyToMany(mappedBy = "categories")
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
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(types, that.types) &&
                Objects.equals(licenses, that.licenses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, types, licenses);
    }
}
