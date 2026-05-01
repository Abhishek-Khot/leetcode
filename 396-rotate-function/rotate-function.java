class Solution {
    public int maxRotateFunction(int[] nums) {
        // completly formula based but easy to derive 
        int n = nums.length;
        int F = 0;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            F += nums[i] * i;
        }
        int result = F;
        for(int i = 0;i<n;i++){
            int newF = F + sum - n*nums[n-i-1];
            result = Math.max(result,newF);
            F = newF;
        }
        return result;
    }
}