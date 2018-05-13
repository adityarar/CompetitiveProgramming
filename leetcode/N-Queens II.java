class Solution {
    
    int total = 0;
    
    public int totalNQueens(int n) {
        if(n==0) return 1;
        int[] visited = new int[n];
        dfs(0, n, visited);
        return total;
    }
    
    private void dfs(int row, int n, int[] visited){
        if (row == n){
            total ++;
        }
        for(int j=0; j<n; j++){
            if (isSafe(row,j,visited)){
                visited[row] = j;
                dfs(row+1, n, visited);
            }
        }
    }
    
    boolean isSafe(int x, int y, int[] visited){
        for(int i=0; i<x; i++){
            int j = visited[i];
            if(y==j)//same columns
                return false;
            if((y-j) == (x-i))
                return false;
            if((i+j) == (x+y))
                return false;
        }
        return true;
    }
}