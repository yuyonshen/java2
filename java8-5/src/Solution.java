import javax.naming.spi.DirStateFactory;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solution {
    public void solve(char[][] board) {
        if(board.length == 0){
            return ;
        }
        int row = board.length;
        int col = board[0].length;
        //寻找第一行和最后一行为o的字符
        for(int i = 0; i < col; i++){
            if (board[0][i] == 'O'){
                DFS(board, row, col, 0, i);
            }
            if(board[row-1][i] == 'O'){
                DFS(board, row, col, row-1, i);
            }
        }
        //寻找第一列和最后一列;
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O'){
            DFS(board, row, col,i, 0 );
            }
            if(board[i][col-1] == 'O'){
                DFS(board, row, col, i, col-1);
            }
        }
        for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
            if(board[i][j] =='*'){
                board[i][j] = 'O';
            }else if(board[i][j] == 'O'){
                board[i][j] = 'X';
            }
        }
    }
}
    int[][] next = {{0, 1}, {1, 0}, {0 ,-1}, {-1, 0}};
    private void DFS(char[][] board, int row, int col, int i, int j) {
        board[i][j] = '*';
        for(int k = 0; k < 4; k++){
            int n1 = i + next[k][0];
            int n2 = j + next[k][1];
            if(n1 < 0 || n1>= row || n2 < 0 || n2 >=col){
                continue;
            }
            if(board[n1][n2] != '*' && board[n1][n2] != 'X'){
                DFS(board, row, col, n1, n2);
            }
        }
    }
}
