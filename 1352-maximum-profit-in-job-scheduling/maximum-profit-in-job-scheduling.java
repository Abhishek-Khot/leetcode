class Solution {
    private int dp[] = new int[50001];
    private int n;
    public int findNextPossibleJob(int[][] jobs,int low,int currJobEnd){
        int high = n-1;
        int res = n+1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(jobs[mid][0] >= currJobEnd){
                res = mid;
                //there might be duplicate starttimes 
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return res;
    }
    //memorization idx only changing
    public int solve(int[][] jobs,int idx) {
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        //take one job check for job which is end time <= startTime of another job
        int nextPossibleJobIndex = findNextPossibleJob(jobs,idx+1,jobs[idx][1]);
        int take = jobs[idx][2] + solve(jobs,nextPossibleJobIndex);
        int notTake = solve(jobs,idx+1);
        return dp[idx] = Math.max(take,notTake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // how dp pattern 
        // minimum, maximum, optimize
        // options take and skip
        n = startTime.length;
        int[][] jobs = new int[n][3]; // {start,end,profit}
        for(int i = 0;i<n;i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.fill(dp,-1);
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        int res = solve(jobs,0);
        return res;
    }   
}