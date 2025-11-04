class Solution {
    public int maxSubArray(int[] nums) {
        int cum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            cum+=nums[i];
            maxSum = Math.max(maxSum,cum);
            if(cum < 0){
                cum = 0;
            }
        }
        return maxSum;
    }
}