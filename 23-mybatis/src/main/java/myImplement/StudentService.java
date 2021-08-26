package myImplement;

import entity.Student;
import mapper.StudentMapper;

/**
 * @author YeYaqiao
 * mybatis 底层实现
 */
public class StudentService {

    public static void main(String[] args) {
        MyBatis myBatis = new MyBatis();
        String configPath = "23-mybatis/src/main/resources/config.xml";
        StudentMapper studentMapper = myBatis.getInstance(StudentMapper.class, configPath);
        Student student = studentMapper.findById(1);
        System.out.println(student);
    }
}
