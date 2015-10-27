package model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "subject_type")
    private Subjects subject_type;

    private Integer score;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subjects getSubject_type() {
        return subject_type;
    }

    public void setSubject_type(Subjects subject_type) {
        this.subject_type = subject_type;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudent_id() {
        return student;
    }

    public void setStudent_id(long student_id) {
        this.student = student;
    }
}
