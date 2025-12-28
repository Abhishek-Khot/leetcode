// notes in the dsa notes folder
// default value of boolean is false
class Solution {
    public int n;
    public Boolean dp[];
    public boolean solve(int[] nums,int idx){
        if(idx >= n){
            return true;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        boolean res = false;
        // rule 1 
        if(idx + 1 < n && nums[idx] == nums[idx+1]){
            res |= solve(nums,idx+2);
        }
        // rule 2
        if(idx +2 < n && nums[idx] == nums[idx +1] && nums[idx+1] == nums[idx+2]){
            res|= solve(nums,idx+3);
        }
        // rule 3 
        if(idx +2 < n && nums[idx] +1 == nums[idx+1] && nums[idx+2] -1 == nums[idx+1] ){
            res|= solve(nums,idx+3);
        }
        return dp[idx] = res;
    }
    public boolean validPartition(int[] nums) {
        n = nums.length;
        dp = new Boolean[n];
        // Arrays.fill(dp,null);
        return solve(nums,0);
    }
}