package leetcodeList;
class NodeList{
    int val;
    NodeList next;
    public NodeList(int val){
        this.val=val;
    }
}

public class MyLinkedList {
        int size;
        NodeList head;

    public MyLinkedList() {
        size=0;
        head=new NodeList(0);
    }

    //根据下标找指定位置上的元素
    public int get(int index) {
        if(index<0||index>=size){
            return -1;
        }
        NodeList cur=head;
        for(int i=0;i<index+1;i++){
            cur=cur.next;
        }
        return cur.val;
    }

    //在头节点位置上增加元素
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    //在链表的尾部增加元素
    public void addAtTail(int val) {
    addAtIndex(size,val);
    }

    //在指定结点位置上增加元素
    public void addAtIndex(int index, int val) {
    if(index>size){
        return ;
    }
    if(index<0){
        index=0;
        size++;
    }
    NodeList cur=head;
    for(int i=0;i<index;i++){
        cur=cur.next;
    }
    NodeList addprv=new NodeList(val);
    addprv.next=cur.next;
    cur.next=addprv;
    }

    //删除指定位置上的节点
    public void deleteAtIndex(int index) {
    if(index<0||index>=size){
        return ;
    }
    size--;
    NodeList cur=head;
    for(int i=0;i<index;i++){
        cur=cur.next;
    }
    cur.next=cur.next.next;
    }

}
