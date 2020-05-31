package IOfile;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class io_study {
@Test
    public void t1(){
    InputStream in=this.getClass().getResourceAsStream("../标签2.txt");

    System.out.println(in);
    InputStream in2=this.getClass().getClassLoader().getResourceAsStream("标签2.txt");
    System.out.println(in2);
}
@Test
    public void t2() throws IOException {


        File f1=new File("E:\\java5-1\\java5-31\\data\\随便.txt");
        //File f=new File("E:\java5-1\java5-31\data\随便.txt");
    System.out.println(f1.isDirectory() );
    System.out.println(f1.isFile());
    int num =10;
    String s=num+"";
    System.out.println(s);
    String s1="123";
    int nums2=Integer.parseInt(s1);
    System.out.println(nums2);

}
}
