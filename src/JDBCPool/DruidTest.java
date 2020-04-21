package JDBCPool;

import JDBC_test.Customer;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

/**
 * @author linzhiyu
 * @date 2020/4/5 11:58 上午
 * @Email:1360482168@qq.com
 * @Describe   全是使用的通用的
 */
public class DruidTest {
    @Test
    public void getConnection() throws Exception {

        //1、建立连接使用数据库池
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties pros = new Properties();
        pros.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
        Connection connection = dataSource.getConnection();
        //System.out.println(connection);
        //2、使用commons-dbutils 来进行增删改
        //dbutils是apache提供的一个开源的jdbc工具库类
        QueryRunner Runner = new QueryRunner();
//        String sql = "insert into customer (name,email,birth)values(?,?,?)";
//
//        int insertCount = queryRunner.update(connection, sql, "蔡徐坤", "caixukun@gmail.com", "1999-9-9");
//        System.out.println("insert :" + insertCount + "条记录");

        //3、测试查询一条记录
        //BeanHandler是ResultSetHandler接口的实现类，用于封装一条记录。
//        String sql = "select id,name,birth from customer where id = ?";
//        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
//
//        Customer customer = Runner.query(connection, sql, handler, 5);
//        System.out.println(customer);
        //3、测试查询多条数据
        //使用BeanListHandler是ResultSetHandler接口的实现类，用于封装一条记录。
        String sql1 = "select id,name,birth from customer where id < ?";
        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);

        List<Customer> list= Runner.query(connection, sql1, handler, 5);
        DbUtils.closeQuietly(connection);

        list.forEach(System.out::println);

    }
}
