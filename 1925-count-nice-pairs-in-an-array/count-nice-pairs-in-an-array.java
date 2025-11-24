class Solution {
    public int mod = 1000000007;
    public int rev(int n){
        int rev = 0;
        while(n > 0){
            int last = n % 10;
            rev = (rev * 10) + last;
            n/=10;
        }
        return rev;
    }
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        //nums[i]-rev(nums[i])
        //18,0,0,18 there are two pairs 18,18 and 0,0 
        for(int i = 0;i<n;i++){
            nums[i] = nums[i] - rev(nums[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i =0;i<n;i++){
            if(map.containsKey(nums[i])){
                res = ((res + map.get(nums[i]))% mod);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
}