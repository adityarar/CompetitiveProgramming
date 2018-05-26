class Solution {
    
    int[] dp;
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = cost[0];
        dp[1] = cost[1];
        return Math.min(find(cost, n-1), find(cost, n-2));
    }
    
    int find(int[] cost, int n) {
        if (dp[n] != Integer.MAX_VALUE) {
            return dp[n];
        }
        dp[n] = Math.min(find(cost, n-1), find(cost, n-2)) + cost[n];
        return dp[n];
    }
    
    
}