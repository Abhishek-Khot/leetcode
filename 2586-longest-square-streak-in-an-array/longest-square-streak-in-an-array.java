class Solution {
    public int longestSquareStreak(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int res = 0,n = nums.length;
        for(int num : nums){
            int squareRoot = (int)Math.sqrt(num);

            if(squareRoot*squareRoot == num && map.containsKey(squareRoot)){
                map.put(num,map.get(squareRoot)+1);
            }
            else{
                map.put(num,1);
            }
            res = Math.max(res,map.get(num));
        }
        return res > 1 ? res : -1;
    }
}