package OI_study;


import java.io.*;
import java.nio.BufferUnderflowException;

public class abc {
    //文件的拷贝
    public static void main(String[] args) throws IOException {
        File f=new File("E:\\qq文件\\JMM.zip");
        FileReader fr=new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw=new FileWriter("E:\\图片\\新建文件夹\\JMM2.zip");
        BufferedWriter bw=new BufferedWriter(fw);
        String L;
        while ((L=br.readLine())!=null) {
            bw.write(L);
        }
        bw.flush();

    }

}
