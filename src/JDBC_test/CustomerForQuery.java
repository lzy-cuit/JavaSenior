package JDBC_test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linzhiyu
 * @date 2020/4/3 8:28 下午
 * @Email:1360482168@qq.com
 * @Describe  针对与customer表的查询操作
 */
public class CustomerForQuery {

    @Test
    public void test(){
        String sql = "select id,name from customer where id = ?";
        List<Customer> list = queryForCustomer(sql, 1);
        System.out.println(list);

    }

    public List<Customer> queryForCustomer(String sql, Object ...args)  {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1、获取连接
            connection = JDBCUtils.getConnection();
            //预编译sql语句
            ps = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //执行语句,返回结果集存储在rs中
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
/*************************************************************/
            //通过resultSetMetadata获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            ArrayList<Customer> list = new ArrayList<>();
            while (rs.next()){
                //处理结果集中每一行的每一列
                Customer customer = new Customer();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //在获取每一个列的列名
//
                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
//                    String columnLabel = rsmd.getColumnLabel();

                    //给customer对象的制定属性，赋值为columValue：通过反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(customer,columnValue);
/*************************************************************/
                    list.add(customer);
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,ps,rs);
        }
        return null;


    }
}
