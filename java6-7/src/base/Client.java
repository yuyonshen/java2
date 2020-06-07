package base;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    private static String Host="127.0.0.1";

    public static void main(String[] args) throws IOException {
        //创建一个客户端
        Socket socket=new Socket(Host, 6666);
        InputStream is=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(isr);

        OutputStream os=socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os,true);

        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            pw.println(line);
            pw.flush();
            String s=br.readLine();
            System.out.println("服务端:"+s);
        }
    }
}
