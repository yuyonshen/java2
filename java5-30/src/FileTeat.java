import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTeat {
    @Test
    public void t1(){
//        File file=new File("E:\\java5-1\\java5-30\\data\\随便.txt");
//        System.out.println(file.exists());
//        File f2=new File("./data/随便.txt");
//        System.out.println(f2.exists());
//        //怎么查查看当前java代码的路径
//        File f3=new File(".");
//        System.out.println(f3.getAbsolutePath());
//        File f4=new File("data/随便.txt");
//        System.out.println(f4.exists());//判断文件是否存在
//        System.out.println(f4.getPath());//获取路径
//        System.out.println(f4.lastModified());//上次修改时间
        File f5=new File("C:\\Windows");
        File[] files = f5.listFiles();
        for(File child : files){
            System.out.println(child.getName());
        }
    }
    public  static List<File> list(File f){
        List<File> list=new ArrayList<>();
        if(f.isFile()){
          list.add(f);
        }else{
            File[] files = f.listFiles();
            for(File child : files){
                List<File> subs=list(child);
                list.addAll(subs);
            }
        }
       return list;
    }
}
