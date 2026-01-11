class Solution {
    public int dp[][];
    public int m ,n;
    public int solve(int nums1[],int nums2[],int i,int j){
        if(i == m || j == n){
            // there will be case where the product is negative
            return -(int)(1e9+7);
        }
        if(dp[i][j] != -1){
            return dp[i][j];    
        }
        int takeboth = nums1[i] * nums2[j];
        int takebothij = nums1[i] * nums2[j] + solve(nums1,nums2,i+1,j+1);
        int takeonlyi = solve(nums1,nums2,i+1,j);
        int takeonlyj = solve(nums1,nums2,i,j+1);
        return dp[i][j] = Math.max(Math.max(takeboth,takebothij),Math.max(takeonlyi,takeonlyj));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[501][501];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(nums1,nums2,0,0);
    }
}