class Solution {
    private int m;
    private int n;
    public int mod = (int)1e9+7;
    private int dp[][][];
    public int solve(int[][] grid,int k,int i,int j,int currSum){
        if(i >= m || j >= n){
            return 0;
        }
        if(i == m -1 && j == n - 1){
            return ((currSum + grid[i][j]) % k== 0) ? 1 : 0;
        }
        if(dp[i][j][currSum] != -1){
            return dp[i][j][currSum];
        }
        //finding all possible paths
        int right = solve(grid,k,i+1,j,(currSum + grid[i][j])%k);
        int bottom = solve(grid,k,i,j+1,(currSum + grid[i][j])%k);
        return dp[i][j][currSum] = (right + bottom) % mod;
    }

    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int currSum = 0;
        // i j and currSum 
        dp = new int[m+1][n+1][k+1];
        for(int outer_dp[][] : dp){
            for(int inner_dp[] : outer_dp){
                Arrays.fill(inner_dp,-1);
            }
        }
        int res = solve(grid,k,0,0,currSum);
        return res;
    }
}