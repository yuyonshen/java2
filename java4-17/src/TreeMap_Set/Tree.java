package TreeMap_Set;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Tree {
    public static class Node{
        int key;
        Node right;
        Node left;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node root=null;

    public Node search(int key){
        Node cur=root;
        while(cur!=null){
            if(cur.key>key){
                cur=cur.left;
            }else if(cur.key<key){
                cur=cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }
    //增夹节点
    public boolean insert(int key){
        Node cur=root;
        Node prev=null;
        if(root==null){
            root=new Node(key);
            return true;
        }
        while(cur!=null){
            if(cur.key<key){
                prev=cur;
                cur=cur.right;
            }else if(cur.key>key){
                prev=cur;
                cur=cur.left;
            }else{
                return false;
            }
        }
        if(prev.key>key){
            prev.left=new Node(key);
        }else{
            prev.right=new Node(key);
        }
        return true;
    }
    //给定两个字符串 s 和 t，判断它们是否是同构的。
    //
    //如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    //
    //所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

    public boolean isIsomorphic(String s, String t) {
        int[] map1=new int[128];
        int[] map2=new int[128];
        char[] a1=s.toCharArray();
        char[] a2=t.toCharArray();
        for(int i=0;i<a1.length;i++){
            if(map1[a1[i]] == 0 && map2[a2[i]] == 0) { // 还没有建立相互的映射
                map1[a1[i]] = a2[i]; // 从1到2的映射 角标表示1中的字符，值表示隐射到的值
                map2[a2[i]] = a1[i];

            }else if(map1[a1[i]]==a2[i]&&map2[a2[i]]==a1[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

}
