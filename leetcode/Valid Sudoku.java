class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){//Rows
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                char cellVal = board[i][j];
                if(cellVal != '.')
                    if(set.add(cellVal) == false)
                        return false;
            }
        }
        for(int i=0; i<9; i++){//Columns
            Set<Character> set = new HashSet<>();
            for(int j=0; j<9; j++){
                char cellVal = board[j][i];
                if(cellVal != '.')
                    if(set.add(cellVal) == false)
                        return false;
            }
        }
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                if(isCellValid(board, i, j) == false)
                    return false;
            }
        }
        return true;
    }
    
    private boolean isCellValid(char[][] board, int p, int q){
        Set<Character> set = new HashSet<>();
        for(int i=p; i<p+3; i++){
            for(int j=q; j<q+3; j++){
                if(board[i][j] != '.')
                    if(set.add(board[i][j]) == false)
                        return false;
            }
        }
        return true;
    }
}