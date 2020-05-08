package Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Service {
    //客服端
    public static void main(String[] args) throws IOException {
        System.out.println("客服端发送请求.......");
        //创建客户端对象,绑定服务器ip和端口号
        Socket socket=new Socket("localhost",6666);
        //使用soc课挺对象提供的方法,写入字节流.
        OutputStream out=socket.getOutputStream();
        out.write("你好吗?".getBytes());
        //获取服务器的字节流
        InputStream in=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=in.read(bytes);
        System.out.println(new String(bytes,0,len));
        out.close();
        socket.close();
    }
}
