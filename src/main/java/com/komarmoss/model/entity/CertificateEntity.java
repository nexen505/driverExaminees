package com.komarmoss.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_certificate", schema = "public", catalog = "postgres")
public class CertificateEntity implements Identifiable {
    private Integer id;
    private CategoryEntity category;
    private LicenseOfDriverEntity license;
    private SchoolEntity school;
    private List<ExamEntity> exams;

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
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "id_license_of_driver")
    public LicenseOfDriverEntity getLicense() {
        return license;
    }

    public void setLicense(LicenseOfDriverEntity license) {
        this.license = license;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_school")
    public SchoolEntity getSchool() {
        return school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
    }

    @OneToMany(mappedBy = "certificate")
    public List<ExamEntity> getExams() {
        return exams;
    }

    public void setExams(List<ExamEntity> exams) {
        this.exams = exams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificateEntity that = (CertificateEntity) o;
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
