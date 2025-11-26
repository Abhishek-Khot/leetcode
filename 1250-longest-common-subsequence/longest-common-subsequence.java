class Solution {
    // abcde eca 
    public int dp[][] = new int[1001][1001];
    public int solve(String txt1,String txt2,int i,int j){
        if(i == txt1.length() || j == txt2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(txt1.charAt(i) == txt2.charAt(j)){
            return dp[i][j] = 1 + solve(txt1,txt2,i+1,j+1);
        }
        return dp[i][j] = Math.max(solve(txt1,txt2,i+1,j),solve(txt1,txt2,i,j+1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(text1,text2,0,0);
    }
}