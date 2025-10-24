class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int res[] = new int[q];
        int sum = 0;
        int k = 0;

        for(int num : nums){
            if(num % 2 == 0){
                sum+=num;
            }
        }

        for(int i = 0;i<q;i++){
            int val = queries[i][0];
            int idx = queries[i][1];
            //if it is even 
            if(nums[idx]%2 == 0){
                sum-=nums[idx];
            }
            //perform the operation
            nums[idx]+=val;

            if(nums[idx]%2== 0){
                sum+=nums[idx];
            }
            res[k++] = sum;
        }
        return res;
    }
}