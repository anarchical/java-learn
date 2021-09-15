package service;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentMapper;

import java.util.List;

/**
 * @author YeYaqiao
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStudents() {
        return studentMapper.findAll();
    }


}
