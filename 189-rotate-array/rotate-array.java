class Solution {
    public void rotateOnce(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateOnce(nums,0,n-1);
        rotateOnce(nums,0,k-1);
        rotateOnce(nums,k,n-1);
    }
}