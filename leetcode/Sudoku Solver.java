class Solution {
    public void solveSudoku(char[][] board) {
        int count = 0;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    count++;
                }
            }
        }
        System.out.println(count);
        if (count == 0)
            return;
        isValid(board, count); 
    }
    
    boolean isValid(char[][] board, int count) {
        int p=0,q=0;
        boolean found = false;
        //Find empty location
        for( p=0; p<9; p++) {
            for(q=0; q<9; q++) {
                if(board[p][q] == '.') {
                    found = true;
                    break;
                }
            }
            if (found ) break;
        }
        for (char i='1'; i<='9'; i++) {
            board[p][q] = i;
            if (Validator.isValidSudoku(board)) {
                if(count == 1)
                    return true;
                else { //solve further
                    if (isValid(board, count-1))
                        return true;
                }
            }
        }
        board[p][q] = '.';//To ensure that callers of this method get the array that they sent.
        return false;
    }
}

class Validator {
    public static boolean isValidSudoku(char[][] board) {
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
    
    private static boolean isCellValid(char[][] board, int p, int q){
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