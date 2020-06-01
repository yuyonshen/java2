package OI_study;

import org.junit.Test;

import java.io.*;

public class io_study {
    @Test
    public void t() throws FileNotFoundException {
        FileOutputStream fos=new FileOutputStream("E:\\图片\\新建文件夹\\1.txt");
        PrintStream ps=new PrintStream(fos,true);
        ps.println("追加1");
        ps.println("追加2");
        ps.println("追加3");
        ps.flush();
    }
    @Test
    public void t2() throws IOException {
        FileOutputStream fos=new FileOutputStream("E:\\图片\\新建文件夹\\1.txt");
        //转换为字符输入流
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        bw.write("追加1");
        bw.newLine();
        bw.write("追加2");
        bw.write("追加3");
        bw.flush();
    }

}
