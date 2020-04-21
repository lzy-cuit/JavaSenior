package TreeSetTest;

/**
 * @author linzhiyu
 * @date 2020/3/4 15:29
 * @Email:1360482168@qq.com
 * @Describe
 */
public class Mydate {
    private int year;
    private int month;
    private int day;

    public Mydate() {
    }

    public Mydate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Mydate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
