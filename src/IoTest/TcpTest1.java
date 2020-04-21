package IoTest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author linzhiyu
 * @date 2020/3/8 15:28
 * @Email:1360482168@qq.com
 * @Describe
 */
public class TcpTest1 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1、创建Socket对象，指明服务器ip和端口号
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            socket = new Socket(byName,8899);
            //2、获取输出流，用输出数据
            os = socket.getOutputStream();
            //3、写出输出数据
            os.write("你好，我是客服端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
    @Test
    public void server()  {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream b = null;
        try {
            //1、创建服务器端socket，指明自己端口号
            ss = new ServerSocket(8899);
            //2、调用accept表示接收客服端socket
            accept = ss.accept();
            //3、获取输入流
            is = accept.getInputStream();
//      //字节流处理中文汉字容易出现乱码
//        byte[] buffer = new byte[1024];
//
//        int len;
//        while ((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }
            //使用ByteArrayOutputStream来存数据
            //4、读去输入流数据
            b = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1){
                b.write(buffer,0,len);

            }
            System.out.println(b.toString());
            System.out.println(accept.getInetAddress().getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            if (b != null){
                try {
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }





    }
}
