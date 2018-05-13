class Solution {
    int[][] dp;
    int m,n;
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0)
            return 0;
        this.m = m;
        this.n = n;
        dp = new int[m][n];//initialzing dp array
        for(int i=0; i<m; i++)
            dp[i][0] = 1;
        for(int i=0; i<n; i++)
            dp[0][i] = 1;
        return dfs(m-1,n-1);
    }
    
    int dfs(int p, int q){
        if( dp[p][q] != 0)
            return dp[p][q];
        dp[p][q] = dfs(p-1, q) + dfs(p, q-1);
        return dp[p][q];
    }
    
}