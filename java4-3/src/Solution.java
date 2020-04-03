import java.io.Serializable;

public class Solution {
    //使其能将字符串转换成整数
    public int myAtoi(String str) {
        int num=0;
        String str1 = str.trim();
        if (str1.length() == 0) {
            return 0;
        }
        if ( str1.charAt(0)-'0' > 10 ) {
            return 0;
        }


    int sum=0;
        for (int i = 0; i < str1.length(); i++) {

            if (str1.charAt(i)-'0' <= 9 && str1.charAt(i)-'0' >= 0) {
                if (str1.charAt(0) == '-') {

                    sum = (sum * 10 + str1.charAt(i) - '0');
                    num=-sum;
                }
                else{
                    num = num * 10 + str1.charAt(i) - '0';
                }

                }
            }

        return  num;
    }

    public static void main(String[] args) {
        new Solution();
        System.out.println(new Solution().myAtoi("-542"));
    }
}

//        String str1=str.trim();
//    int index=0;
//        for(int i=0;i<str1.length();i++) {
//            if(str1.charAt(0)=='-'){
//                buffer.append(str.charAt(i));
//            }
//            if (str1.charAt(i) > 9) {
//                index++;
//            }
//            if (str1.charAt(i) >= 0 && str1.charAt(i) < 10) {
//                break;
//            }
//
//        }
//        int index1 = index;
//            for(int j=index;j<str1.length();j++){
//                if(str1.charAt(j)<10&&str1.charAt(j)<=0){
//                    index1++;
//                }
//            }
//           return ;
//    }
//}
