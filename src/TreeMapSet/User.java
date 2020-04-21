package TreeMapSet;

import java.util.Objects;

/**
 * @author linzhiyu
 * @date 2020/3/5 15:22
 * @Email:1360482168@qq.com
 * @Describe
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof User)) {return false;}
        User user = (User) o;
        return getAge() == user.getAge() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    //使用定制排序，先按照姓名从大到小排列
    //然后按照年龄从小到大排序
    public int compareTo(Object o) {
        if (o instanceof User){
            User user = (User)o;
            int compare = -this.name.compareTo(user.name);
            if (compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age,user.age);
            }

        }else {
            throw new RuntimeException("输入数据不合法");
        }
    }
}
