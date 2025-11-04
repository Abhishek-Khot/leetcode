class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(reach < i){
                return false;
            }
            reach = Math.max(reach,nums[i]+i);
        }
        return true;
    }
}