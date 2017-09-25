package model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_school", schema = "public", catalog = "postgres")
public class ExdrSchoolEntity implements Identifiable {
    private Integer id;
    private String nameSchool;
    private String addressSchool;
    private int phoneNumber;
    private List<ExdrCertificateEntity> certificates;

    @Id
    @Column(name = "id_school")
    public Integer getId() {
        return id;
    }

    public void setId(Integer idSchool) {
        this.id = idSchool;
    }

    @Basic
    @Column(name = "name_school", nullable = false)
    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    @Basic
    @Column(name = "address_school", nullable = false)
    public String getAddressSchool() {
        return addressSchool;
    }

    public void setAddressSchool(String addressSchool) {
        this.addressSchool = addressSchool;
    }

    @Basic
    @Column(name = "phone_number", nullable = false)
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "school")
    public List<ExdrCertificateEntity> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<ExdrCertificateEntity> certificates) {
        this.certificates = certificates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExdrSchoolEntity that = (ExdrSchoolEntity) o;
        return phoneNumber == that.phoneNumber &&
                Objects.equals(id, that.id) &&
                Objects.equals(nameSchool, that.nameSchool) &&
                Objects.equals(addressSchool, that.addressSchool) &&
                Objects.equals(certificates, that.certificates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSchool, addressSchool, phoneNumber, certificates);
    }
}
