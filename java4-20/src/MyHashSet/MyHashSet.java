package MyHashSet;

public class MyHashSet {
    private static class Node{
        private int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node[] array;
    private int size=0;

    public void add(int key) {
        int index=key%array.length;
        Node list=array[index];
        if(list==null){
            Node newHead=new Node(key);
            array[index]=newHead;
        }else{
            Node newHead=new Node(key);
            newHead.next=list;
            array[index]=newHead;
        }
    }
    public void remove(int key) {
        int index=key%array.length;
        Node list=array[index];
       Node prve=null;
       Node cur=list;
       while(cur!=null){
           if(cur.key==key){
               prve.next=cur.next;
               return ;
           }else{
               prve=cur;
               cur=cur.next;
           }
       }
    }
    public boolean contains(int key) {
        int index=key%array.length;
        Node list=array[index];
        for(Node cur=list;cur!=null;cur=cur.next){
            if(cur.key==key){
                return true;
            }
        }
        return false;
    }
}
