class Solution {
    public int n;
    // easy take and not take options dp
    public long dp[];
    public long solve(int[][] questions,int idx){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        long take = questions[idx][0] + solve(questions,idx + 1+questions[idx][1]);// skip those points
        long not_take = solve(questions,idx+1);
        return dp[idx]=Math.max(take,not_take);
    }
    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(questions,0);
    }
}