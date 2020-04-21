package JDBC_test;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author linzhiyu
 * @date 2020/4/3 4:31 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
    //使用PreparedStatement来进行增删改查
public class PreparedStatementTest {


    @Test//测试通用的增删改。
    public void testUpdate(){
        String sql = "delete from customer where id = ?";
        update(sql,3);
    }

    //通用的增删改查操作
    public void update(String sql,Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库连接
            connection = JDBCUtils.getConnection();
            //2、预编译sql语句，返回prepareStatement的实例
            ps = connection.prepareStatement(sql);

            //3、填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //4、执行语句
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //5、资源的关闭
            JDBCUtils.closeResource(connection,ps);
        }

    }




    //修改customer表中的记录
    @Test //通用的增删改查操作
    public void TestUpdate() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库连接
            connection = JDBCUtils.getConnection();
            //2、预编译sql语句，返回实列
            String sql = "update customer set name = ? where id = ? ";
            String sql1 = "insert into customer (name,email) values (?,?)";

            Statement statement = connection.createStatement();
            ps = connection.prepareStatement(sql1);
            //3、填充占位符
            ps.setObject(1,"淋至鱼");
            ps.setObject(2,2);
            //4、执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、资源的关闭
            JDBCUtils.closeResource(connection,ps);
        }
    }


    //向表中添加一条记录
    @Test
    public void testInsert() throws Exception{
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
        //System.out.println(connection);
        //4、预编译sql ，返回preparedStatemet实列
        String sql = "insert into customer(name,email,birth)values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        //5、填充占位符
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ps.setString(1,"刘德华");
        ps.setString(2,"liudehua@gmail.com");
        java.util.Date data = simpleDateFormat.parse("1976-01-19");
        ps.setDate(3,new Date(data.getTime()));
        //6、执行sql语句操作
        ps.execute();
        //7、资源的关闭
        ps.close();
        connection.close();

    }
}
