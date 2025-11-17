class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        //c should be minimum
        //a and b should be maximum
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-1] + nums[n-2] - nums[0];
    }
}