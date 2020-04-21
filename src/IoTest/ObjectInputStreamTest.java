package IoTest;

import org.junit.Test;
import sun.plugin2.message.JavaObjectOpMessage;

import java.io.*;

/**
 * @author linzhiyu
 * @date 2020/3/7 22:56
 * @Email:1360482168@qq.com
 * @Describe
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream os = null;
        try {
            //1、创建文件
            os = new ObjectOutputStream(new FileOutputStream("nihao.dat"));
            //2、序列化操作
            os.writeObject(new String("我是中国人"));
            os.flush();//刷新操作
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                //3、关闭流
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }


    }
    @Test
    public void testObjectInputStream(){
        ObjectInputStream  os = null;
        try {
            os = new ObjectInputStream(new FileInputStream("nihao.dat"));
            Object obj = os.readObject();
            String str = (String)obj;

            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(os != null){

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
