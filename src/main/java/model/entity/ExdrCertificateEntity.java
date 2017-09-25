package model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_certificate", schema = "public", catalog = "postgres")
public class ExdrCertificateEntity implements Identifiable {
    private Integer id;
    private ExdrCategoryEntity category;
    private ExdrLicenseOfDriverEntity license;
    private ExdrSchoolEntity school;
    private List<ExdrExamEntity> exams;

    @Id
    @Column(name = "id_certificate")
    public Integer getId() {
        return id;
    }

    public void setId(Integer idCertificate) {
        this.id = idCertificate;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "name_categories")
    public ExdrCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ExdrCategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "id_license_of_driver")
    public ExdrLicenseOfDriverEntity getLicense() {
        return license;
    }

    public void setLicense(ExdrLicenseOfDriverEntity license) {
        this.license = license;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_school")
    public ExdrSchoolEntity getSchool() {
        return school;
    }

    public void setSchool(ExdrSchoolEntity school) {
        this.school = school;
    }

    @OneToMany(mappedBy = "certificate")
    public List<ExdrExamEntity> getExams() {
        return exams;
    }

    public void setExams(List<ExdrExamEntity> exams) {
        this.exams = exams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExdrCertificateEntity that = (ExdrCertificateEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(category, that.category) &&
                Objects.equals(license, that.license) &&
                Objects.equals(school, that.school) &&
                Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, license, school, exams);
    }
}
