class Solution {
    public int reverse(int num){
        int rev = 0;
        while(num != 0){
            int last = num % 10;
            rev = rev * 10 + last;
            num = num / 10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i])){
                res = Math.min(res,i - map.get(nums[i]));
            }
            int rev = reverse(nums[i]);
            map.put(rev,i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}