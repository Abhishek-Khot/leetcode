// notes in dsa notes folder 
// falls under the MCM Pattern 
class Solution {
    public int n;
    public int dp[][];
    public int solve(int[] values,int i,int j){
        // base case when not able to form a trigle so we need values greater than or equal to 3
        if(j - i +1 < 3){
            return 0;
        }
        if(dp[i][j]  != -1){
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            int val = values[i] * values[k]  * values[j];
            int triangularSum = solve(values,i,k) + val + solve(values,k,j);
            res = Math.min(res,triangularSum);
        }
        return dp[i][j] = res;
    }
    public int minScoreTriangulation(int[] values) {
       n = values.length; 
       dp = new int[n+1][n+1]; // time O(n ^ 2) to fill states plus n for loop so O(n ^ 3)
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
       return solve(values,0,n-1);
    }
}