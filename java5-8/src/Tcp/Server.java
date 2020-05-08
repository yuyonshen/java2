package Tcp;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //服务端
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动,正在等待请求.............");
        //服务器绑定端口
        ServerSocket ss=new ServerSocket(6666);
        //获取客户端对象.
        Socket server=ss.accept();
        //使用socket中提供的方法来读取写入流.
        InputStream is = server.getInputStream();
        byte[] b=new byte[1024];
        int len=is.read(b);
        String sb=new String(b,0,len);
        System.out.println(sb);
        OutputStream OS=server.getOutputStream();
        OS.write("好的谢谢".getBytes());
        is.close();
        server.close();




    }
}
