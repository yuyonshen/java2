package IOfile;

import org.junit.Test;

import java.io.*;

public class io_study2 {

    @Test
            public void t1() throws IOException {
        InputStream fis = null;
        fis=this.getClass().getClassLoader().getResourceAsStream("随便.txt");
        byte[] bytes=new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            String s=new String(bytes,0,len);
            System.out.println(s);
        }
        fis.close();
    }
    @Test
    public void t2() throws IOException {
        //使用文件字节输入流读取
        FileReader fis=new FileReader("E:\\java5-1\\java5-31\\标签2.txt");
        char[] chars=new char[1024];
        int len;
        while ((len = fis.read(chars)) != -1){
            String s=new String(chars,0,len);
            System.out.println(s);
        }
        fis.close();
    }
    @Test
    public void t3() throws IOException {
        //使用文件字节输入流来读取
        FileInputStream fis=new FileInputStream("E:\\java5-1\\java5-31\\标签2.txt");
        byte[] bytes=new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            String s=new String(bytes,0,len);
            System.out.println(s);
        }
        fis.close();
    }
    @Test
    public void t4() throws IOException {
        //字节字符流转换
        FileInputStream fis=new FileInputStream("E:\\java5-1\\java5-31\\标签2.txt");
        //转换为字符流
        InputStreamReader put=new InputStreamReader(fis,"UTF-8");
        //使用缓冲流
        BufferedReader buff=new BufferedReader(put);
        String s;
        while((s=buff.readLine())!=null){
            System.out.println(s);
        }

    }
    @Test
    public void t5() throws IOException {
        FileInputStream fis=new FileInputStream("E:\\java5-1\\java5-31\\标签2.txt");
        BufferedInputStream buff=new BufferedInputStream(fis);
        byte[] bytes=new byte[1024];
        int len;
        while((len=buff.read(bytes))!=-1){
            String s=new String (bytes);
            System.out.println(s);
        }
    }
}
