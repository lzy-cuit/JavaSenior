package TreeSetTest;

/**
 * @author linzhiyu
 * @date 2020/3/4 15:29
 * @Email:1360482168@qq.com
 * @Describe
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private Mydate birthday;

    public Employee() {
    }

    public Employee(String name, int age, Mydate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee)o;
            return this.name.compareTo(e.getName());
        }
        throw new RuntimeException("传入数据类型不一样");
    }

}
