package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import service.StudentService;

import java.math.BigInteger;

/**
 * Created by Azat Zaripov on 23.10.2015.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public Integer findStudent(Student student) {
        return repository.findStudent(student);
    }
}
