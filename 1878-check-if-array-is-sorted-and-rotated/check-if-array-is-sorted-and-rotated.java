class Solution {
    public boolean check(int[] nums) {
        // one time or zero time 
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n -1 ; i++) {
            if(nums[i] > nums[i+1]){
                count++;
            }
            if (count > 1) {
                return false;
            }

        }
        if(nums[n-1] > nums[0] && count != 0){
            return false;
        }
        return true;
    }
}