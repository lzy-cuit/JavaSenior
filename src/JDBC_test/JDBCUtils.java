package JDBC_test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author linzhiyu
 * @date 2020/4/3 6:10 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class JDBCUtils {
    /**
    * @Description: 获取数据库的连接
    * @Param: []
    * @return: java.sql.Connection
    * @Author: linzhiyu
    * @Date: 2020/4/3
    */
    public static Connection getConnection() throws Exception {
        //1、读取配置文件中的基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");


        //2、加载驱动
        Class.forName(driverClass);

        //3、获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    /** 
    * @Description: 关闭资源的操作
    * @Param: [connection, ps] 
    * @return: void 
    * @Author: linzhiyu
    * @Date: 2020/4/3 
    */ 
    public static void closeResource(Connection connection, Statement ps){
        try {
            if (ps != null)
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void closeResource(Connection connection, Statement ps, ResultSet rs){
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
