package repository;

import entity.Student;

import java.util.List;

/**
 * @author YeYaqiao
 * mybatis 接口声明
 * 接口名称需要和 mapper 文件中的 namespace 映射
 * 方法名需要和 select 的 id 映射
 */
public interface StudentMapper {

    Student findById(int id);

    List<Student> findAll();

    void save(Student student);

    void deleteById(int id);

    void update(Student student);

}
