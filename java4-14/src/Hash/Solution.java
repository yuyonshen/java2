package Hash;

import java.util.*;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}


public class Solution {
    //深度拷贝一个链表
    public Node copyRandomList(Node head) {
// 首先床架map对象,key为旧链表的每个节点 value为新的链表节点
        Map<Node, Node> map=new HashMap<>();
        for(Node cur=head;cur!=null;cur=cur.next){
            map.put(cur, new Node(cur.val));
        }
        for(Node cur=head;cur!=null;cur=cur.next){
            Node Newcur=map.get(cur);
            Newcur.next=map.get(cur.next);
            Newcur.random=map.get(cur.random);
        }
        return map.get(head);
    }
    //给定一个字符串J,之后再S字符串中找到和J字符串字符相同的个数
    public int numJewelsInStones(String J, String S){
        //首先创建一个set集合对象
        //将给定字符串的字符分别保存在set集合中
        Set<Character> set=new HashSet<>();
        for(char x : J.toCharArray()){
            set.add(x);
        }
        int nums=0;
        for(char x : S.toCharArray()){
            if(set.contains(x)){
                nums++;
            }
        }
        return nums;
    }
    //给定一个单词字符串,输出前k个出现次数最多的单词
    public List<String> topKFrequent(String[] words, int k) {
        //首先创建一个Map的集合 key表示单词 value表示次数
        Map <String, Integer> map=new HashMap<>();
        for(String s : words){
            Integer value=map.get(s);
            if(value==null){
                map.put(s,1);
            }else{
                map.put(s,value+1);
            }
        }
        List<String> list=new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1=map.get(o1);
                int count2=map.get(o2);
                if(count1==count2){
                    return o1.compareTo(o2);//字典序排列
                }
                return count2-count1;
            }
        });
        return list.subList(0,k);
    }
}
