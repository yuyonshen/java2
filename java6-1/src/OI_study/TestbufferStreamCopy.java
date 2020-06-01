package OI_study;

import java.io.*;

public class TestbufferStreamCopy {
    public static void main(String[] args) throws IOException {
        File f=new File("E:\\图片\\新建文件夹\\1.txt");
        FileInputStream fis=new FileInputStream(f);
        BufferedInputStream bis=new BufferedInputStream(fis);

        FileOutputStream fos=new FileOutputStream("E:\\图片\\2.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes);
        }
        bos.flush();
        fis.close();
        bis.close();
        fos.close();
        bos.close();
    }
}
