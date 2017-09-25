package model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_owner", schema = "public", catalog = "postgres")
public class ExdrOwnerEntity implements Identifiable {
    private Integer id;
    private String name;
    private String patronymic;
    private String surname;
    private Date dateOfBirth;
    private List<ExdrVehicleEntity> transportList;
    private ExdrLicenseOfDriverEntity license;

    @Id
    @Column(name = "id_owner")
    public Integer getId() {
        return id;
    }

    public void setId(Integer idOwner) {
        this.id = idOwner;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
    public List<ExdrVehicleEntity> getTransportList() {
        return transportList;
    }

    public void setTransportList(List<ExdrVehicleEntity> transportList) {
        this.transportList = transportList;
    }

    @OneToOne
    @JoinColumn(name = "id_owner")
    public ExdrLicenseOfDriverEntity getLicense() {
        return license;
    }

    public void setLicense(ExdrLicenseOfDriverEntity license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExdrOwnerEntity that = (ExdrOwnerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(transportList, that.transportList) &&
                Objects.equals(license, that.license);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patronymic, surname, dateOfBirth, transportList, license);
    }
}