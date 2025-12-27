class Solution {
    public int m;
    public int n;
    public int dp[][];
    public int solve(int[][] obstacleGrid,int i,int j){
        // base case on changing parameters
        if(i < 0 || i > m - 1|| j <0 || j > n - 1 || obstacleGrid[i][j] == 1){
            return 0;
        }
        // operation
        if(i == m -1 &&j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // call 
        int down = solve(obstacleGrid,i+1,j);
        int right = solve(obstacleGrid,i,j+1);
        return dp[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[101][101];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(obstacleGrid,0,0);
    }
}