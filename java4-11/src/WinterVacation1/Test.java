package WinterVacation1;



public class Test {
    //赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        //首先判断第一个字符串的长度是否大于第二个字符串的长度

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        char[] arr=magazine.toCharArray();
        StringBuffer sb=new StringBuffer(String.valueOf(arr));
        int b=0;
        for(int i=0;i<ransomNote.length();i++){
            char a=ransomNote.charAt(i);
            for(int j=0;j<sb.length();j++){
                if(a==(sb.charAt(j))){
                    sb.delete(j,j+1);
                    b++;
                    break;
                }
            }

        }
       if(b==ransomNote.length()){
           return true;
       }
       return false;
    }
    //判断一个数是否为回文数
    public boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        int num=0;
        while(x>0){
            num=num*10+x%10;
            x=x/10;
        }
        if(x==num){
            return true;
        }
        return false;
    }

}
