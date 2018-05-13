class Solution {
    
    List<List<String>> solution;
    
    public List<List<String>> solveNQueens(int n) {
        solution = new ArrayList<>();
        if(n==0){
            List<String> list = new ArrayList<>();
            solution.add(list);
            return solution;
        }
        int[] visited = new int[n];
        dfs(0, n, visited);
        return solution;
    }
    
    private void dfs(int row, int n, int[] visited){
        if (row == n){
            generateSolution(n, visited);
        }
        for(int j=0; j<n; j++){
            if (isSafe(row,j,visited)){
                visited[row] = j;
                dfs(row+1, n, visited);
            }
        }
    }
    
    void generateSolution(int n, int[] visited){
        char[] arr = new char[n];
        for(int i=0; i<n; i++){
            arr[i] = '.';
        }
        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr[visited[i]] = 'Q';
            String row = new String(arr);
            arr[visited[i]] = '.';
            list.add(row);
        }
        solution.add(list);
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