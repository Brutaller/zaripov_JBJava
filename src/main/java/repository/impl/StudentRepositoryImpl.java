package repository.impl;

import model.Score;
import model.Student;
import org.springframework.stereotype.Repository;
import repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Integer findStudent(Student student) {
        Query query = em.createNativeQuery("SELECT id FROM students where lower(firstname) = lower(?) and lower(surname) = lower(?) and lower(lastname) = lower(?)");
        query.setParameter(1,student.getFirstname());
        query.setParameter(2,student.getSurname());
        query.setParameter(3,student.getLastname());
        return (Integer) query.getSingleResult();
    }
}
