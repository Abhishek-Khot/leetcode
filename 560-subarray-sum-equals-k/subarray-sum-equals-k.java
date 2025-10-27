class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for(int i = 0;i<n;i++){
            cum+=nums[i];
            if(map.containsKey(cum -k)){
                count+=map.get(cum - k);
            }
            map.put(cum,map.getOrDefault(cum,0)+1);
        }
        return count;
    }
}