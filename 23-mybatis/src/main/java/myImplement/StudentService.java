package myImplement;

import mapper.StudentMapper;

/**
 * @author YeYaqiao
 * mybatis 底层实现
 */
public class StudentService {

    public static void main(String[] args) {
        MyBatis myBatis=new MyBatis();
        StudentMapper studentMapper = (StudentMapper) myBatis.getInstance(StudentMapper.class);
        studentMapper.test();
    }
}
