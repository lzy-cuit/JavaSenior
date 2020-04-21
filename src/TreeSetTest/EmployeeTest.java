package TreeSetTest;

import sun.text.UCompactIntArray;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author linzhiyu
 * @date 2020/3/4 15:34
 * @Email:1360482168@qq.com
 * @Describe
 */
public class EmployeeTest  {
    //使用自然排序

//    public static void main(String[] args) {
//        TreeSet set = new TreeSet();
//        Employee e1 = new Employee("liudehua",55,new Mydate(1965,2,3));
//        Employee e2 = new Employee("nihao1",52,new Mydate(1923,2,3));
//        Employee e3 = new Employee("jinhgg",57,new Mydate(1954,2,3));
//        Employee e4 = new Employee("kdahifna",125,new Mydate(1965,2,3));
//        Employee e5 = new Employee("dhaiuhfa",45,new Mydate(1975,2,3));
//
//        set.add(e1);
//        set.add(e2);
//        set.add(e3);
//        set.add(e4);
//        set.add(e5);
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    }
//使用定制排序

    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    Mydate b1 = e1.getBirthday();
                    Mydate b2 = e2.getBirthday();
                    //  比较年
                    int min = b1.getYear() - b2.getYear();
                    if (min != 0) {
                        return min;
                    }
                    //比较月
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if (minusMonth != 0) {
                        return minusMonth;
                    }
                    return b1.getDay() - b2.getDay();


                }
                return 0;
            }

        });
        Employee e1 = new Employee("liudehua",55,new Mydate(1965,2,3));
        Employee e2 = new Employee("nihao1",52,new Mydate(1923,2,3));
        Employee e3 = new Employee("jinhgg",57,new Mydate(1954,2,3));
        Employee e4 = new Employee("kdahifna",125,new Mydate(1965,2,3));
        Employee e5 = new Employee("dhaiuhfa",45,new Mydate(1975,2,3));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
