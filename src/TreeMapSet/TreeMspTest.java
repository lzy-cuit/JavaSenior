package TreeMapSet;

import java.util.*;

/**
 * @author linzhiyu
 * @date 2020/3/5 15:22
 * @Email:1360482168@qq.com
 * @Describe
 */
public class TreeMspTest {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        HashMap<Integer, String> map1 = new HashMap<>();

        User u1 = new User("lihao", 32);
        User u2 = new User("ninz", 34);
        User u3 = new User("whhhj", 12);

        map.put(u1,98);
        map.put(u2,983);
        map.put(u3,981);
//遍历map中的所有数据
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object o = iterator1.next();

            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "------>" + entry.getValue());
        }


    }
}
