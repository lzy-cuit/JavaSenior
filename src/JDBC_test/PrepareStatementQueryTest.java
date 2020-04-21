package JDBC_test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author linzhiyu
 * @date 2020/4/4 4:12 下午
 * @Email:1360482168@qq.com
 * @Describe
 * 使用PrepareStatementQueryTest来实现针对不同表的通用的查询操作
 *
 */
public class PrepareStatementQueryTest {

    @Test
    public void test(){
        String sql = "select id,name,email from customer where id = ?";
        Customer instance = getInstance(Customer.class, sql, 1);
        System.out.println(instance);
    }

    /**
    * @Description:  使用PrepareStatementQueryTest来实现针对不同表的通用的查询操作
     * 只能返回一条记录
    * @Param: [clazz, sql, args]
    * @return: T
    * @Author: linzhiyu
    * @Date: 2020/4/4
    */
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
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
                ps.setObject(i + 1, args[i]);
            }
            //执行语句,返回结果集存储在rs中
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
/*************************************************************/
            //通过resultSetMetadata获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //如果查询多条记录就用list把数据存储起来，把if转为while
            //List<T> list = new ArrayList<>();
            if (rs.next()) {
                //处理结果集中每一行的每一列
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //在获取每一个列的列名
//
                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名
//                    String columnLabel = rsmd.getColumnLabel();

                    //给t对象的制定属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
/*************************************************************/
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, rs);
        }
        return null;
    }
}