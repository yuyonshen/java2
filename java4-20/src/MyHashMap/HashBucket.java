package MyHashMap;

public class HashBucket {
    private static class Node{
        private int key;
        private int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array;
    private int size=0;
    private static final double LOAD_FACTOR=0.75;

    public void put(int key, int value) {
        int index=key%array.length;
        Node list=array[index];
        for(Node cur=list;cur!=null;cur=cur.next){
            if(key==cur.key){
                cur.value=value;
                return ;
            }
        }
        Node newHead=new Node(key,value);
        newHead.next=list;
        array[index]=newHead;
        size++;
    }
    public int get(int key) {
        int index=key%array.length;
        Node list=array[index];
        for(Node cur=list;cur!=null;cur=cur.next){
            if(key==cur.key){
                return cur.value;
            }
        }
        return -1;
    }
    public void remove(int key) {
        int index=key%array.length;
        Node list=array[index];
        Node prve=null;
        Node cur=list;
        while(cur!=null){
            if(key==cur.key){
                prve.next=cur.next;
                return ;
            }
            prve=cur;
            cur=cur.next;
        }
    }
}
