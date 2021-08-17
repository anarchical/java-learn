package transaction;

import org.apache.commons.dbutils.QueryRunner;
import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author YeYaqiao
 */
public class Transaction {

    public static void main(String[] args) throws SQLException {

        String sql = "insert into mysql_learn.course(id, name) VALUES (?,?)";

        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionPool.getConnection();

        //关闭自动提交，开启事务
        connection.setAutoCommit(false);

        try {
            queryRunner.update(connection, sql, 1, "Python 编程思想");
//            System.out.println(10/0);
            queryRunner.update(connection, sql, 2, "GoLang 编程思想");
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            connection.rollback();
        }
        connection.close();
    }
}
