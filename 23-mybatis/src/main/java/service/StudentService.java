package service;

import entity.Student;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author YeYaqiao
 */
public class StudentService {

    /**
     * myBatis 原生使用，较为繁琐，耦合度高
     */
    public static void originalUse() {
        //加载配置文件 config.xml
        InputStream inputStream = StudentService.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //开启连接会话
        SqlSession sqlSession = factory.openSession();
        //指定查询语句，由 namespace + id 构成
        String statement = "mapper.StudentMapper.findById";
        //执行sql，传入参数
        Student student = sqlSession.selectOne(statement, 2);
        System.out.println(student);
    }

    public static void interfaceUse() {
        //加载配置文件 config.xml
        InputStream inputStream = StudentService.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        //开启连接会话
        SqlSession sqlSession = factory.openSession();

        //获取接口的实现(获取代理对象)
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //增删改查
        mapper.save(new Student(100, "student"));
        Student student = mapper.findById(100);
        System.out.println(student);

        mapper.update(new Student(100, "new Student"));
        List<Student> studentList = mapper.findAll();
        System.out.println(studentList);

        mapper.deleteById(100);

    }

    public static void main(String[] args) {

        //原生使用
        originalUse();

        //封装成接口使用
        interfaceUse();
    }
}
