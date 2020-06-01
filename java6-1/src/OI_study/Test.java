package OI_study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    //图片的复制
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\图片\\timg[3].jpg");
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos=new FileOutputStream("E:\\图片\\BitCopy.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes))!=-1){
        fos.write(bytes);
        }
        fos.close();
        fis.close();
    }
}
