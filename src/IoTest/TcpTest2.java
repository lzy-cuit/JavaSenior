package IoTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author linzhiyu
 * @date 2020/3/8 15:59
 * @Email:1360482168@qq.com
 * @Describe
 */
public class TcpTest2 {
    //测试客户端发送文件个服务端，服务器端保存文件到本地。
    @Test
    public void client() throws Exception {
        //1、得到一个socket套接字
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //2、得到一个输出流
        OutputStream os = socket.getOutputStream();
        //3、得到一个输入流，得到一个文件的数据
        FileInputStream fis = new FileInputStream(new File("linzhiyu.png"));
        //4、开始操作数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //5、资源关闭
        fis.close();
        os.close();
        socket.close();
    }
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1、创建一个serversocket
            ss = new ServerSocket(9090);
            //2、表示可以接收数据
            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("linzhiyu1.png"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
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
            if (socket != null){
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
