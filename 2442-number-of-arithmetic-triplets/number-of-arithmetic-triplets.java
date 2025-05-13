class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int num: nums)set.add(num);

        for(int i= 0;i<nums.length;i++){
            //why 2 times because 10-3 = 7 && 7-3 = 4 triplet 10 7 4
            if(set.contains(nums[i] - diff)  && set.contains(nums[i] - 2*diff)){
                res++;
            }
        }
        return res;
    }
}