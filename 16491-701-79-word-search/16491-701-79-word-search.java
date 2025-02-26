class Solution {
    private int rows , cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(dfs(board , word , i , j , 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char [][] board , String word , int r , int c , int index){
        if(index == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >=  rows || c >= cols || board[r][c] != word.charAt(index) || board[r][c] == '#'){
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board , word , r+1 , c , index + 1) ||
                      dfs(board , word , r , c + 1 , index + 1) ||
                      dfs(board , word , r - 1 , c  , index + 1) ||
                      dfs (board , word , r , c - 1 , index + 1) ;

        board[r][c] = word.charAt(index);
        return res;

    }

}