// easy initution -> dsa notes 
// for every cell check all the paths are ending add those paths will be the answer
class Solution {
    public int m,n;
    public int MOD = (int)1e9+7;
    public int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public int dp[][];
    public boolean isSafe(int i,int j,int grid[][]){
        return (i >=0 && i<m && j >=0 && j <n);
    }
    public int dfs(int grid[][],int i,int j){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int answer = 1;// that cell will be counted as one 
        for(int[] dir:directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(isSafe(new_i,new_j,grid) && grid[i][j] > grid[new_i][new_j]){// should be less 
                answer = (answer + dfs(grid,new_i,new_j))% MOD;
            }
        }
        return dp[i][j] = answer;
    }
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        dp = new int[1001][1001];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                result = (result + dfs(grid,i,j)) % MOD;
            }
        }
        return result;
    }
}