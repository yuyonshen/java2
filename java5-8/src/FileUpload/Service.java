package FileUpload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Service {
    //客户端
    public static void main(String[] args) throws IOException {
        //首先创建Sorcke对象
        Socket socket=new Socket("127.0.0.1",8888);
        FileInputStream fis=new FileInputStream("D:3.jpeg");
        OutputStream out=socket.getOutputStream();
        int len=0;
        byte[] bytes=new byte[1024];
        while((len=fis.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream in= socket.getInputStream();
        while((len=in.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }

}
