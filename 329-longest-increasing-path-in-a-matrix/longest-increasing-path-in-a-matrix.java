class Solution {
    public int m, n;
    public int dp[][];
    public int MOD = (int)1e9 + 7;
    public int directions[][] = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean isSafe(int x,int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    public int dfs(int matrix[][],int i,int j){
        int answer = 0;
        if(dp[i][j]  != -1){
            return dp[i][j];
        }
        for(int dir[] : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(isSafe(x,y) && matrix[x][y] > matrix[i][j]){
                answer = Math.max(answer,dfs(matrix,x,y));
            }
        }
        dp[i][j] = answer+1;
        return answer + 1;
    }
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int result = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                result = Math.max(result,dfs(matrix,i,j));
            }
        }
        return result;
    }
}