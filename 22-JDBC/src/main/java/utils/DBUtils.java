package utils;

import entity.Course;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author YeYaqiao
 */
public class DBUtils {

    public static void main(String[] args) throws SQLException {

        String sqlCourse = "select * from mysql_learn.course";

        String sqlCourseById = "select * from mysql_learn.course where id = ?";


        Connection connection = ConnectionPool.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        //使用 BeanListHandler 接收查询的结果
        List<Course> courseList = queryRunner.query(connection, sqlCourse, new BeanListHandler<>(Course.class));

        //使用 BeanListHandler 接收查询的结果，并且传入查询参数，底层使用的还是 PreparedStatement 占位符
        Course course = queryRunner.query(connection, sqlCourseById, new BeanHandler<>(Course.class), 1);

        System.out.println(Arrays.toString(courseList.toArray()));
        System.out.println(course);
    }
}
