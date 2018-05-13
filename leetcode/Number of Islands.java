class Solution {
    
    int[][] visited;
    int[] rows = new int[]{0,-1,0,1};
    int[] cols = new int[]{1,0,-1,0};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length == 0)
            return 0;
        visited = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){//not yet visited
                    dfs(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int row, int col){
        visited[row][col] = 1;
        for(int i=0; i<4; i++){
            int p = row + rows[i];
            int q = col + cols[i];
            if(isSafe(grid, p, q) == false)
                continue;
            if(grid[p][q] == '1' && visited[p][q] == 0){
                dfs(grid, p, q);
            }
        }
    }
    
    boolean isSafe(char[][] grid, int p, int q){
        if(p<0 || q<0 || p>=grid.length || q>=grid[0].length)
            return false;
        return true;
    }
    
}