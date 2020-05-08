package FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //服务器
    public static void main(String[] args) throws IOException {
        System.out.println("服务器请求连接............");
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream in=socket.getInputStream();
        File file=new File("E:\\upload");
        if(!file.exists()){
            file.mkdirs();
        }
        FileOutputStream out=new FileOutputStream(file+"\\3.jpeg");
        int len=0;
        byte[] bytes=new byte[1024];
        while((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        OutputStream out1=socket.getOutputStream();
        out1.write("上传成功".getBytes());
        out.close();
        socket.close();
        serverSocket.close();
    }
}
