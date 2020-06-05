package base;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {
    //创建一个服务器
    public static void main(String[] args) throws IOException {
       ServerSocket ss=new ServerSocket(6666);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os);

        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
//        String line=br.readLine();
//        System.out.println(line);
            pw.println("你好"+line);
            pw.flush();
        }
    }
}
