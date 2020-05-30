import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

public class Test2 {
    @Test
    public void t1(){
        try {
            int i=1/0;
            System.out.println("i/0");
        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("error");

        }
        System.out.println("t1");
    }

}
