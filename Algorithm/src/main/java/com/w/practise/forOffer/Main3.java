package com.w.practise.forOffer;

/**
 * @ClassName Main3
 * @Description [请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。]
 * @Author ANGLE0
 * @Date 2020/6/20 12:26
 * @Version V1.0
 **/
public class Main3 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //参数检查
        if (matrix == null || rows < 1 || cols < 1|| str == null){ return false;}
        boolean[] flags = new boolean[matrix.length];
        int pos = 0;
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
                if (isRight(matrix, rows, cols, 0, 0, pos, str, flags)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isRight(char[] matrix,  int rows, int cols, int currRow, int currCol, int pos, char[] str, boolean[] flags){
        //参数检查
        if (currRow < 0 || currRow >= rows || currCol < 0 || currCol >= cols){
            return false;
        }
        //计算索引
        int index = currRow * cols + currCol;
        //字符匹配检查
        if (matrix[index] != str[pos]){
            return false;
        }
        flags[index] = true;
        pos++;
        return isRight(matrix, rows, cols, currRow, currCol + 1,  pos, str, flags)
                || isRight(matrix, rows, cols, currRow + 1, currCol, pos, str, flags)
                || isRight(matrix, rows, cols, currRow, currCol - 1,  pos, str, flags)
                || isRight(matrix, rows, cols, currRow - 1, currCol, pos, str, flags);
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if(k == word.length - 1) return true;
            char tmp = board[i][j];
            board[i][j] = '/';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
            board[i][j] = tmp;
            return res;
        }
    }

}
