package LeetCode;

import java.util.*;

public class Solution {
    //两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> map=new HashMap<>();
        for(int x : nums2){
            Integer count=map.get(x);
            if(count==null){
                map.put(x,1);
            }else{
                map.put(x,count+1);
            }
        }
        int k=0;
        for(int x : nums1){
          Integer count=map.getOrDefault(x,0);
          if(count>0){
              nums1[k++]=x;
              map.put(x,count-1);
          }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums2){
            set.add(x);
        }
        int k=0;
        for(int x : nums1){
            if(set.contains(x)){
                nums1[k++]=x;
                set.remove(x);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
    //字符串中无一一个字符
    public int firstUniqChar(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(char x : s.toCharArray()){
            Integer count=map.get(x);
            if(count==null){
                map.put(x,1);
            }else{
                map.put(x,count+1);
            }
        }
       for(int i=0;i<s.length();i++){
           char x=s.charAt(i);
           if(map.get(x)==1){
               return i;
           }
       }
       return -1;
    }
    //员工重要性
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        //创建map的对象
        map=new HashMap<>();
        //将员工的属性增加到hashMap的键值对中
        for(Employee e:employees){
            map.put(e.id,e);
        }
        return def(id);
    }

    public int def(int id){
        Employee employee=map.get(id);
        int ans=employee.importance;
        for(Integer sub:employee.subordinates){
            ans+=def(sub);
        }
        return ans;
    }
}
