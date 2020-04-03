public class ArrayList {
    Object[] objects=new Object[20];
    int index=0;
    //add方法;
    public void add(Object o){
        if(index==objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects=  newObjects;
        }
        objects[index]=o;
        index++;
    }
    //size方法
    public int size(){
        return index;
    }
    //remove方法
    public void remove(int index){
        Object[] newO=new Object[objects.length-1];
        System.arraycopy(objects,0,newO,0,index);
        System.arraycopy(objects, index+1, newO, index, newO.length-index);
    }
    //find方法
    public Object find(int index){
        return  objects[index];

    }
    //set方法
    public Object set(int index, Object x){
        if(index>objects.length||index<0){
            return false;
        }
        return objects[index]=x;
    }
    //subList截取部分元素
    public Object subList(int a,int b){
        if(a<0||a>objects.length||b>objects.length||b>0){
            return false;
        }
        if(a>b){
            return false;
        }
        Object[] newOb=new Object[b-a];
        System.arraycopy(objects,0,newOb,0,b-a);
        return newOb;
    }
}
