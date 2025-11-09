class Solution {
    long dp[][] = new long[100001][2];
    int n;
    public long solve(int idx,int[] nums,boolean flag){
        //if idx skip last element go further
        if(idx >= n){
            return 0;
        }
        int flagVal = flag ? 0 : 1;
        if(dp[idx][flagVal] != -1){
            return dp[idx][flagVal];
        }

        //skip
        long skip = solve(idx+1,nums,flag);
        //take
        long val = nums[idx];
        if(flag == false){
            val = -val;
        }
        long take = solve(idx+1,nums,!flag)+val;
        return dp[idx][flagVal] = Math.max(skip,take);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,nums,true);
    }
}