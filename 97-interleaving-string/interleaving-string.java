class Solution {
    // if all three out of bound then its true
    // if only the N is out of bound means one of the string s1 or s2 must be empty
    // if both string s1 and s2 have same characters then try both --> DP 
    public int dp[][][];
    public boolean solve(int i,int j,int k,String s1, String s2, String s3){
        
        int m = s1.length(), n = s2.length(), N = s3.length();
        
        if(i == m && j == n && k == N){
            return true;
        }
        if(k >= N){
            return false;
        }
        if(dp[i][j][k] != -1){
            return dp[i][j][k] == 1;
        }
        boolean result = false;
        if(i < m && s1.charAt(i) == s3.charAt(k)){
            result = solve(i+1,j,k+1,s1,s2,s3);
        }
        if(result == true)return result;
        if(j < n && s2.charAt(j) == s3.charAt(k)){
            result = solve(i,j+1,k+1,s1,s2,s3);
        }
        // noob programmer 
        if(result == true ){
            dp[i][j][k] = 1 ;
        }
        else {
            dp[i][j][k] =  0;
        }
        return result;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int[101][101][201];
        for(int done[][]: dp){
            for(int dtwo[]: done ){
                Arrays.fill(dtwo,-1);
            }
        }
        return solve(0,0,0,s1,s2,s3);
    }
}