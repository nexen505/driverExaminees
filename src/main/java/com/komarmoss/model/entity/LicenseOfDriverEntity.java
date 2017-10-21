package com.komarmoss.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 * Водительское удостоверение.
 */
@Entity
@Table(name = "exdr_license_of_driver", schema = "public", catalog = "postgres")
public class LicenseOfDriverEntity implements Identifiable {
    /**
     * Идентификатор
     */
    private Integer id;
    /**
     * Серия и номер удостоверения
     */
    private String series;
    /**
     * Дата выдачи
     */
    private Date dateOfIssue;
    /**
     * Владелец удостоверения
     */
    private OwnerEntity owner;
    /**
     * Категории удостоверения
     */
    private List<CategoryEntity> categories;

    public LicenseOfDriverEntity() {
    }

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
    @Column(name = "series")
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Basic
    @Column(name = "date_of_issue")
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @OneToOne
    @JoinColumn(name = "id_owner")
    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "exdr_certificate",
            inverseJoinColumns = {@JoinColumn(name = "category")},
            joinColumns = {@JoinColumn(name = "id_license_of_driver")})
    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseOfDriverEntity that = (LicenseOfDriverEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dateOfIssue, that.dateOfIssue) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfIssue, owner, categories);
    }
}
