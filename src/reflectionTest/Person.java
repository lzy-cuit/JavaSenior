package reflectionTest;

import org.junit.Test;

import java.util.Objects;

/**
 * @author linzhiyu
 * @date 2020/3/8 18:25
 * @Email:1360482168@qq.com
 * @Describe
 */
public class Person {
    private String name;
    public int age;
    public Integer integer;

    public Person() {
        System.out.println("person()");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
