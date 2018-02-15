package leetcode;
/**
*
* @author Scott
*/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

//    compare board[x][y] and start of string
    private boolean exist(char[][] board, int x, int y, String word, int start) {
        if(start >= word.length()) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (board[x][y] == word.charAt(start++)) {
            char c = board[x][y];
//            ["aa"]  in this case the third a will go back to the first a
//             "aaa"
//          since each letter can be used only once
            board[x][y] = '#';
            boolean res = exist(board, x + 1, y, word, start) || exist(board, x - 1, y, word, start) ||
            exist(board, x, y + 1, word, start) || exist(board, x, y - 1, word, start);
            board[x][y] = c;
            return res;
        }
        return false;
    }
    
   
}
