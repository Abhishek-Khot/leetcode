class Solution {
    public int missingNumber(int[] nums) {
        int an = nums.length;
        int sum = (an * (an+1))/2;
        int acsum = 0;
        for(int num : nums){
            acsum+= num;
        }
        return sum - acsum;
    }
}