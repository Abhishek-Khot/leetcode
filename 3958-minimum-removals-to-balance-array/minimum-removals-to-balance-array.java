class Solution {
    public int minRemoval(int[] nums, int k) {
        // minimum removal to make it balanced is n - max length of balanced array 
        // n ^2 is not acceptable
        // nlogn or n 
        // sorting is good to get min and max 
        // on that i can use sliding window 
        Arrays.sort(nums);
        long min = nums[0];
        long max = nums[0];
        int i  =0;
        int j = 0;
        int n = nums.length;
        long res = 1L;
        while(j < n){
            max = (long)nums[j];
            min = (long)nums[i];
            while(i < j && (max > min * k)){
                i++;
                min = nums[i];
            }
            res = Math.max(res,j-i+1);
            j++;
        }
        return (int)(n - res);
    }
}