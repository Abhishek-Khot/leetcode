class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = -100000 ;
        int n = nums.length;
        int i = 0,j = 0;
        double sum = 0;
        int count = 0;
        while(j < n){
            sum+= nums[j];
            count++;
            while(count == k){
                ans = Math.max((sum / k),ans);
                sum -= nums[i];
                i++;
                count--;
            }
            j++;
        }
        return ans;
    }
}