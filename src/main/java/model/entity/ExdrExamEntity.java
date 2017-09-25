package model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "exdr_exams", schema = "public", catalog = "postgres")
public class ExdrExamEntity implements Identifiable {
    private Integer id;
    private Date examDate;
    private boolean isPassed;
    private ExdrCertificateEntity certificate;
    private ExdrExamTypeEntity examType;

    @Id
    @Column(name = "id_exam")
    public Integer getId() {
        return id;
    }

    public void setId(Integer idExam) {
        this.id = idExam;
    }

    @Basic
    @Column(name = "exam_date")
    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    @Basic
    @Column(name = "is_passed")
    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    @ManyToOne
    @JoinColumn(name = "id_certificate")
    public ExdrCertificateEntity getCertificate() {
        return certificate;
    }

    public void setCertificate(ExdrCertificateEntity certificate) {
        this.certificate = certificate;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_exam")
    public ExdrExamTypeEntity getExamType() {
        return examType;
    }

    public void setExamType(ExdrExamTypeEntity examType) {
        this.examType = examType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExdrExamEntity that = (ExdrExamEntity) o;
        return isPassed == that.isPassed &&
                Objects.equals(id, that.id) &&
                Objects.equals(examDate, that.examDate) &&
                Objects.equals(certificate, that.certificate) &&
                Objects.equals(examType, that.examType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, examDate, isPassed, certificate, examType);
    }
}
