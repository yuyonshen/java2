import java.awt.*;
import java.util.*;


public class Solution2 {
    /**给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，
     * 请找出路径上的所有数字之和最小的路径。
     *注意：你每次只能向下或向右移动。
     *
     * @param grid int整型二维数组 
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if(row == 0 && col == 0 ){
            return 0;
        }
        for(int i = 1 ; i < row; i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < col; i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[row-1][col-1];
    }
}