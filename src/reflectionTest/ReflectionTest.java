package reflectionTest;

import org.junit.Test;

/**
 * @author linzhiyu
 * @date 2020/3/8 18:24
 * @Email:1360482168@qq.com
 * @Describe
 */
public class ReflectionTest {
    //获取Class的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二:通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //(用的比较多)方式三:调用class的静态方法： forName(String classPath)
        //forName()得到一个指定路径的类
        Class clazz3 = Class.forName("reflectionTest.Person");
        System.out.println(clazz3);
    }
}
