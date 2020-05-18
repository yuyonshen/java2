package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {

    public static final int TARGET_SUM = 15;

    private Stack<Integer> stack = new Stack<Integer>();


    private int sumInStack = 0;

    public void populateSubset(final int[] data, int fromIndex, int endIndex) {

        if (sumInStack >= TARGET_SUM) {
            if (sumInStack == TARGET_SUM) {
                print(stack);
            }


            return;
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= TARGET_SUM) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];

                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }



    private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static void main(String[] args) {
         int[] DATA = { 1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13,
                14, 15 };
        Solution2 example = new Solution2();
        example.populateSubset(DATA, 0, DATA.length);
    }
}
