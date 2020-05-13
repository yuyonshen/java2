

@SuppressWarnings("all")
public class JDKAnnotation {
    /*
     * JDK中预定义的一些注解
     * @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
     * @Deprecated：该注解标注的内容，表示已过时
     * @SuppressWarnings：压制警告
     * 一般传递参数all  @SuppressWarnings("all")

     */

    @Override
    //检测被该注解标注的方法是否是继承自父类(接口)的
    public String toString() {
        return super.toString();
    }
    @Deprecated
    //表示过时的方法,不推荐使用,但是也死可以使用的,不是强制的
    public void show1(){
        //过时的方法
    }
    public void show2(){
        //替代之后的方法
    }
    public void Demov1(){
        show1();
    }

}
