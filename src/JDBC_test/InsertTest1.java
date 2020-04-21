package JDBC_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author linzhiyu
 * @date 2020/4/4 5:21 下午
 * @Email:1360482168@qq.com
 * @Describe 像customer表中插入一条数据
 *
 */
public class InsertTest1 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.next();
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        System.out.print("请输入生日：");
        String birthday = scanner.next();

//        String name = "错误";
//        String email = "错误";
//        String birthday = "1998-09-09";


//
        String sql = "insert into customer(name,email,birth)values(?,?,?)";
        int insertCount = update(sql, name, email, birthday);
        if (insertCount>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }


    }

    //通用的增删改查操作
    public static int update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1、获取数据库连接
            connection = JDBCUtils.getConnection();
            //2、预编译sql语句，返回prepareStatement的实例
            ps = connection.prepareStatement(sql);

            //3、填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
//            //4、执行语句
//            ps.execute();

            //使用eXcuteUpdate来接收改变来多少条语句
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5、资源的关闭
            JDBCUtils.closeResource(connection, ps);
        }
        return 0;
    }





}