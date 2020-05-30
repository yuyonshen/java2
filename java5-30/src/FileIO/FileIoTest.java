package FileIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIoTest {

    @Test
    public void t1() throws IOException {
       FileInputStream fis=new FileInputStream(new File("E:\\java5-1\\java5-30\\data\\随便.txt"));
//       FileInputStream fis= (FileInputStream) this.getClass().getClassLoader().getResourceAsStream("随便.txt");
        byte[] bytes=new byte[1024];
        int len;
        while((len=fis.read(bytes)) !=-1){
            String s=new String(bytes,0,len);
            System.out.println(s);
        }
        fis.close();

    }
}
