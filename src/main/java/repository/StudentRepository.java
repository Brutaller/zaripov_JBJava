package repository;


import model.Score;
import model.Student;

import java.math.BigInteger;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
public interface StudentRepository {

    Integer findStudent(Student student);

}
