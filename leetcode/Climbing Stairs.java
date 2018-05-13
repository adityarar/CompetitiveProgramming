class Solution {
    
    int[] dp = new int[65536];
    
    public int climbStairs(int n) {
        if(n==1 || n==0)
            return 1;
        if(dp[n] == 0)
            dp[n] = climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }
}