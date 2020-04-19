package Hashmap;

public class HashBucked {
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

    public void put(int key,int value){
        int index=key/array.length;
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(key==cur.key){
                cur.value=value;
                return ;
            }
        }
        Node node=new Node(key,value);
        node.next=array[index];
        array[index]=node;
        size++;

        if(size/array.length>LOAD_FACTOR){
            resize();
        }
    }

    private void resize() {
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            for(Node cur=array[i];cur!=null;cur=cur.next){
                int index=cur.key/newArray.length;
                Node newNode=new Node(cur.key,cur.value);
                newNode.next=newArray[index];
                newArray[index]=newNode;
            }
        }
        array=newArray;
    }
    public int  get(int key){
        int index=key/array.length;
        Node list=array[index];
        for(Node cur=list;cur!=null;cur=cur.next){
            if(cur.key==key){
                return cur.value;
            }
        }
        return -1;
    }
}
