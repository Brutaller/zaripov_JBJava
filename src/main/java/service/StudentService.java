package service;

import model.Student;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
public interface StudentService {

    Integer findStudent(Student student);

}