package service;

import entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author YeYaqiao
 */
public class StudentService {

    public static void main(String[] args) {

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
}
