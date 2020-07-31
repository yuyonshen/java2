import java.util.*;

/**
 * 题目描述
 * 一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置）。
 * 机器人每次向下或向右移动。机器人要到达地图的右下角。（终点，下图中的标记“Finish"的位置）。
 * 可以有多少种不同的路径从起点走到终点？
 */

public class Solution {
    /**
     *
     * @param m int整型 
     * @param n int整型 
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        int[][] arr = new int[m][n];
        for(int i = 0; i < m ;i++){
            arr[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            arr[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        return arr[m-1][n-1];

    }
}