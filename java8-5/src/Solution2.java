/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。

 */
class Solution2 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int ret = 0;
        int[][] book = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && book[i][j] == 0){
                    ret ++;
                    DFS(grid, book, row, col, i, j);
                }
            }
        }
        return ret;
    }
    int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void DFS(char[][] grid, int[][] book, int row, int col, int i, int j) {
        for(int k = 0; k < 4; k++){
            int n1 = i + next[k][0];
            int n2 = j + next[k][1];

            if(n1 < 0 || n1 >= row || n2 < 0 || n2 >= col){
                continue;
            }
            if(grid[n1][n2] == '1' && book[n1][n2] == 0){
                DFS(grid, book, row, col, n1, n2);
            }
        }
    }
}