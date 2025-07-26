class Solution {
    public int maxSum(int[] nums) {
        int sum = 0;
        // HashSet<Integer> set = new HashSet<>();
        boolean vis[] = new boolean[101];
        //finding the smallest neg
        int neg = -100;
        int n = nums.length;
        for(int i = 0;i<n ;i++){
            if(nums[i] > 0 && !vis[nums[i]]){
                sum+=nums[i];
                vis[nums[i] - 0] = true;
            } 
            else if(nums[i] <= 0){
                neg = Math.max(neg,nums[i]);
            }
            // set.add(nums[i]);
        }
        return sum == 0 ? neg : sum;
    }
}