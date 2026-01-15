class Solution {
    public int n;
    public int dp[][];// n ^ 2 form 2 ^ n

    public int solve(int idx, int remain, int cost[], int time[]) {
        // firstly walls finish
        // then out of bound so order is important 
        // remaining is zero then 0 .. cost will be 0 
        if (remain <= 0) {
            return 0;
        }
        // if all walls done return min from other branch
        if (idx >= n) {
            return (int) 1e9 + 7;
        }
        if (dp[idx][remain] != -1) {
            return dp[idx][remain];
        }
        // current painting wall for free painter -1 .. time taken by paid painter 
        int take = cost[idx] + solve(idx + 1, remain - 1 - time[idx], cost, time);
        int not_take = solve(idx + 1, remain, cost, time);
        return dp[idx][remain] = Math.min(take, not_take);
    }

    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new int[n + 1][n + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        int idx = 0;
        int remain = n;
        return solve(idx, remain, cost, time);
    }
}