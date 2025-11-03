class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int cumSum = 0;
        int count = 0;
        map.put(0,1);
        for(int i = 0;i<n;i++){
            cumSum += nums[i];
            if(map.containsKey(cumSum - k)){
                count+=map.get(cumSum-k);
            }
            map.put(cumSum,map.getOrDefault(cumSum,0)+1);
        }
        return count;
    }
}