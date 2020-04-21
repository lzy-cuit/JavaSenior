package IoTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author linzhiyu
 * @date 2020/3/6 17:31
 * @Email:1360482168@qq.com
 * @Describe
 */
public class FileTest {
    public static void main(String[] args) {
        File file1 = new File("hello.txt" );
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file1.getName());
        System.out.println(file1.hashCode());


//      file1.delete();

    }
    @Test
    public void test1(){
        System.out.printf("*******");
    }



}
