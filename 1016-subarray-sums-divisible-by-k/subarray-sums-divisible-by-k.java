class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // rem, count
        // 4,5,0,-2,-3,1 here similar to subarray sum equal to k 
        // remainder of one subarray , and remainder of one subarray - for the prefix subarray
        // if they are equal then subarray of big - small = remaining portion will be 
        // division by k 
        // for the corner case of negative remainder + k to handle

        HashMap<Integer,Integer> map = new HashMap<>();
        int cumSum = 0;
        // int rem = 0;
        int count = 0;
        map.put(0,1);
        int n = nums.length;
        for(int i = 0;i<n;i++){
            cumSum += nums[i];
            int rem = cumSum % k;
            if(rem < 0){
                rem = rem + k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}