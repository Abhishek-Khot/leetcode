class Solution {
    public int dp[][] = new int[1001][1001];
    public int solve(String s1,int i , int j){
        if(i > j){
            return 0;
        }
        if(i == j){
            //single length of the string
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s1.charAt(j)){
            return 2 + solve(s1,i+1,j-1);
        }
        return dp[i][j] = Math.max(solve(s1,i+1,j), solve(s1,i,j-1));
    }
    public int longestPalindromeSubseq(String s) {
        // String rev = reverse(s);
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(s,0,s.length()-1);
    }
}