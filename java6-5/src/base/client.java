package base;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
//客户端
public class client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",6666);

        InputStream is = socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(isr);

        OutputStream os = socket.getOutputStream();
        PrintWriter pw=new PrintWriter(os,true);
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        pw.println(str);
        pw.flush();
//        br.readLine();
        System.out.println(br.readLine());
    }
}
