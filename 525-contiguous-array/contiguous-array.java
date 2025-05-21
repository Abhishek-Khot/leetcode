class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0,preSum = 0,n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            preSum += (nums[i] == 0)? -1:1;

            if(preSum == 0){
                //handle last case
                maxLen = i +1;
            }
            if(map.containsKey(preSum)){
                maxLen = Math.max(maxLen,i - map.get(preSum));
            }
            else{
                map.put(preSum,i);
            }
        }
        return maxLen;
    }
}