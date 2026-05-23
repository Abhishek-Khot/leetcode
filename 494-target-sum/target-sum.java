class Solution {
    public int n;
    // minus -> array out of bound 
    public HashMap<String,Integer> map;
    public int solve(int nums[],int target,int idx,int sum){
        if(idx == n){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        String key = idx +"_" + sum;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int plus = solve(nums,target,idx+1,sum+ nums[idx]);
        int minus = solve(nums,target,idx+1,sum- nums[idx]);
        map.put(key,plus+ minus);
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        n = nums.length;
        int idx = 0;
        int sum = 0;
        // Forever young i want to be forever young 
        return solve(nums,target,idx,sum);
    }
}