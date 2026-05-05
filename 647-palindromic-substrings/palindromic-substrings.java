class Solution {
    public int dp[][];
    public boolean solve(String s,int i,int j){
        if(i > j){
            return true;
        }
        if(dp[i][j] != -1){
            return (dp[i][j] == 0) ? false : true;
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = solve(s,i+1,j-1) == false ? 0 : 1;
            return dp[i][j] == 0 ? false : true;
        }
        return false;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(solve(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
}