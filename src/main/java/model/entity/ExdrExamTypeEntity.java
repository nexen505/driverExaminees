package model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exdr_type_exams", schema = "public", catalog = "postgres")
public class ExdrExamTypeEntity implements Identifiable {
    private String id;
    private int numberOfMistakes;
    private int numberOfQuestions;
    private List<ExdrExamEntity> exams;

    @Id
    @Column(name = "type_exam")
    public String getId() {
        return id;
    }

    public void setId(String typeExam) {
        this.id = typeExam;
    }

    @Basic
    @Column(name = "number_of_mistakes")
    public int getNumberOfMistakes() {
        return numberOfMistakes;
    }

    public void setNumberOfMistakes(int numberOfMistakes) {
        this.numberOfMistakes = numberOfMistakes;
    }

    @Basic
    @Column(name = "number_of_questions")
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    @OneToMany(mappedBy = "examType")
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
        ExdrExamTypeEntity that = (ExdrExamTypeEntity) o;
        return numberOfMistakes == that.numberOfMistakes &&
                numberOfQuestions == that.numberOfQuestions &&
                Objects.equals(id, that.id) &&
                Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfMistakes, numberOfQuestions, exams);
    }
}
