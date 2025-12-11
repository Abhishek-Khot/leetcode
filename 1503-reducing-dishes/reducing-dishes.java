class Solution {
    public int n;
    public int dp[][];

    public int solve(int satisfaction[],int idx,int time){
        if(idx >= n){
            return 0;
        }
        if(dp[idx][time]!= -1){
            return dp[idx][time];
        }
        int include = satisfaction[idx] * time + solve(satisfaction,idx+1,time+1);
        int notInclude = solve(satisfaction,idx+1,time);
        return dp[idx][time] = Math.max(include,notInclude);
    }
    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        Arrays.sort(satisfaction);
        dp = new int[501][501];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }

        return solve(satisfaction,0,1);//index and the time
    }
}