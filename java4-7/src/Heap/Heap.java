package Heap;

public class Heap {
    //优先队列的应用
    //1.操作-入队列
    //以大堆为例
    //向上调整;
    public static void shiftup(int[] array,int index){
        while(index>0){
            int parent=(index-1)/2;
            if(array[index]>array[parent]){
                int temp=array[index];
                array[index]=array[parent];
                array[parent]=temp;
            }else{
                break;
            }
            index=parent;
        }

    }
    //向下调整
    public static void shiftDown(int[] array,int size,int index){
        int child=index*2+1;
        int parent=index;
        while(child<size){
            if(child+1<size&&array[child+1]>array[child]){
                child=child+1;
            }
            if(array[parent]<array[child]){
                int temp=array[child];
                array[child]=array[parent];
                array[parent]=temp;
            }else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }
    //2,返回队首元素
    public class MyPriorityQueue{
        private int[] array=new int[100];
        private int size=0;
        //向队列增加元素
        public void offer(int e){
            array[size++]=e;
            shiftup(array,size-1);
        }
        //出队列
        public int poll(){
            int oldValue=array[0];
            array[0]=array[size--];
            shiftDown(array,size,0);
            return oldValue;
        }

        //获取队首元素
        public int peek(){
            return array[0];
        }

    }
}
