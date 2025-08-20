class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxUni = 0;
        int i = 0,j = 0;
        int n = nums.length;
        int currSum = 0;
        while(j < n){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                currSum-=nums[i];
                i++;
            }
            set.add(nums[j]);
            currSum += nums[j];
            maxUni = Math.max(maxUni,currSum);
            j++;
        }
        return maxUni;
    }
}