package OI_study;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileWriter {
    //文件的复制
    public static void main(String[] args) throws IOException {


        File f = new File("E:\\图片\\2.txt");
        FileReader fr = new FileReader(f);
        FileWriter fw = new FileWriter("E:\\tt");
        int ch;
        while ((ch = fr.read())!=-1){
            fw.write(ch);
        }
        fw.flush();
    }
}
