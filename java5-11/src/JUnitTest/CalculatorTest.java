package JUnitTest;

import JUnit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    //实现一个单元测试
    //使用@Test是声明为一个测试类
    @Test
    public void testAdd(){
        Calculator c= new Calculator();
        int reslut = c.add(1, 2);
        System.out.println(reslut);
        //为了测试的结果和预期的结构是一样的.我们需要使用断言,我断言这个结果为3
        Assert.assertEquals(3,reslut);

    }
    @Test
    public void testsub(){
        Calculator c= new Calculator();
        int reslut1 = c.sub(1, 2);
        System.out.println(reslut1);
        Assert.assertEquals(-1,reslut1);

    }
    //在单元测试中我们还有连个方法
    //其中一个是在执行测试代码前,需要执行的一个方法为,资源申请方法
    //使用前 我们需要在上面注解
    @Before
    public void init(){
        System.out.println("init........");
    }
    //在方法执行结束的时候我们需要释放资源.
    @After
    public void close(){
        System.out.println("close....................");
    }
}
