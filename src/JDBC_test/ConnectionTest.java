package JDBC_test;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author linzhiyu
 * @date 2020/4/2 9:30 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class ConnectionTest {
    //方式一   出现了第三方的API new com.mysql.cj.jdbc.Driver();
    @Test
    public void testConnection1() throws SQLException {
        //获取driver的实现类对像
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/myemployees";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }
    //方式二 对方式一的迭代  在程序中不出现第三方API.使得程序有更好的可移植性。
    @Test
    public  void testConnection2() throws Exception {
        //1、获取driver的实现类对像
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();
        //2、提供要链接的数据库
        String url = "jdbc:mysql://localhost:3306/myemployees";
        //3、提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");
        //4、获取连接
        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }

    //方式三 使用driverManager来代替driver
    @Test
    public void testConnection3() throws Exception, InstantiationException {
        //获取driver的实现类对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)clazz.newInstance();
        //提供需要的信息
        String url = "jdbc:mysql://localhost:3306/myemployees";
        String user = "root";
        String password = "root";
        //1、注册驱动
        DriverManager.registerDriver(driver);

        //2、获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
    //方式4，在3的基础上进行优化 只是加载驱动，不用显示注册驱动。
    @Test
    public void testConnection4() throws Exception, InstantiationException {
        //1、提供需要的信息
        String url = "jdbc:mysql://localhost:3306/myemployees";
        String user = "root";
        String password = "root";

        //2、加载driver，比较与方式三可以不要如下操作。
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver)clazz.newInstance();
//        //1、注册驱动
//        DriverManager.registerDriver(driver);

        //2、获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    //方式五   最终版本 将数据库连接的必要信息放置在配置文件中，
    //通过读取配置文件的方式，获取连接
    //实现了数据和代码的分离


    @Test
    public void testConnection5() throws Exception {

        //1、读取配置文件中的基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
        System.out.println(connection);
    }


}
