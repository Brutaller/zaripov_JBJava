package model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstname;

    private String surname;

    private String lastname;

    private String studgroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudgroup() {
        return studgroup;
    }

    public void setStudgroup(String studgroup) {
        this.studgroup = studgroup;
    }
}
