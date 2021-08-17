package pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author YeYaqiao
 */
public class ConnectionPool {


    //读取配置文件
    private static final InputStream INPUT_STREAM = ConnectionPool.class.getResourceAsStream("/druid.properties");
    private static final Properties PROPERTIES = new Properties();

    private static DataSource DATA_SOURCE = null;

    //加载配置文件
    static {
        try {
            PROPERTIES.load(INPUT_STREAM);
            DATA_SOURCE = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DATA_SOURCE.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }



}
