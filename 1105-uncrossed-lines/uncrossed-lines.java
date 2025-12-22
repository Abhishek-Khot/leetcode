// notes written in the dsa notes folder 
// options + optimal 
// template base + op + rec for the optimal answer

class Solution {
    public int m;
    public int n;
    public int dp[][];
    public int solve(int nums1[],int nums2[],int i ,int j){
        if(i >= m || j >= n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // if equal then 
        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(nums1,nums2,i+1,j+1);
        }
        return dp[i][j] = Math.max(solve(nums1,nums2,i+1,j),solve(nums1,nums2,i,j+1));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        m  = nums1.length;
        n = nums2.length;
        dp = new int[m][n];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(nums1,nums2,0,0);
    }
}