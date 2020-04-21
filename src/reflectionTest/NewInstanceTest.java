package reflectionTest;

import org.junit.Test;

import java.io.ObjectInputStream;
import java.util.Random;

/**
 * @author linzhiyu
 * @date 2020/3/8 22:55
 * @Email:1360482168@qq.com
 * @Describe
 */
public class NewInstanceTest {

    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException {

        Class clazz = Person.class;

        //newInstance（）：
        // 调用此方法，创建对应的运行时类的对象，内部调用类类的空参构造器
        //1、运行时类必须提供空参构造器。
        //2、空参构造器的访问权限得够。
        Object bj = clazz.newInstance();
        System.out.println(bj);
    }

    /*
    体会反射的动态性
     */
    @Test
    public void test2(){
        for (int i = 0;i < 100;i++){
            int num = new Random().nextInt(2);//0,1,2
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "reflectionTest.Person";
                    break;

            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }



    }
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       //forName():通过地址得到类
        Class clazz = Class.forName(classPath);
        //newInstance() 创建类的实例。
        Object instance = clazz.newInstance();

        return instance;


    }

}
