package ObjectComparison;

import java.util.Comparator;

//创建一个扑克牌的类
class Card implements Comparable<Card>{
    public String rank;
    public String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    //我们需要从写一个equals方法
    public boolean equals(Object obj){
       if(this==obj){
           return true;
       }
       if(obj==null){
           return false;
       }
       if(!(obj instanceof Card)){
         return   false;
       }
       Card c=(Card)obj;
       return this.rank.equals(c.rank)&&this.suit.equals(c.suit);
    }

    @Override
    public int compareTo(Card o) {
        if(o==null){
            return 1;
        }
        int rank1=this.getValue();
        int rank2=o.getValue();
        return rank1-rank2;
    }
    //创建一个方法将字符串转换为整形数字
    public int getValue(){
        int value=0;
        if("J".equals(rank)){
            value=11;
        }else if("Q".equals(rank)){
            value=12;
        }else if("K".equals(rank)){
            value=13;
        }else if("A".equals(rank)){
            value=1;
        }else{
            value=Integer.parseInt(rank);
        }
        return value;
    }
}
class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if(o1==o2){
            return 0;
        }
        if(o1==null){
            return -1;
        }
        if(o2==null){
            return 1;
        }
        int value=o1.getValue();
        int value2=o2.getValue();
        return value-value2;
    }


}
public class Test {

    public static void main(String[] args) {
        Card p=new Card("1","♣");
        Card q=new Card("1","♣");
        Card o=p;
        //身份的比较
        //比较的是对象的地址
        System.out.println(p==q);
        System.out.println(p==o);
        System.out.println("====================");
        //比较对象地内容
        System.out.println(p.equals(q));
        System.out.println(o.equals(p));//true
        System.out.println("=================");
        System.out.println(p.compareTo(o));
        System.out.println(p.compareTo(q));
        System.out.println("================");
      CardComparator c=new CardComparator();
        System.out.println(c.compare(p,q));
    }
    //关于对象值大于,等于,小于的比较-基于自然顺序Comparable
    //首先需要比较的对象的类继承Comparable这个接口
    //在使用这个接口的时候我们需要改动源代码.所以不提倡使用类内部的这个接口来改动他

    //因此我们还提供了一种在类的外部创建一个类,来比较对象的大小

}
