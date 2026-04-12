class Solution {
    public int minimumDistance(int[] nums) {
        // bohot easy hai kar // 2(k-i) we need i j k and if the size is greater than 3 means all(three) are same
        // check for k and size - 2 the element which will be i 
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int k = 0;k < n;k++){
            int val = nums[k];
            map.putIfAbsent(val,new ArrayList<>());
            map.get(val).add(k);
            if(map.get(val).size() >= 3){
                List<Integer> curr = map.get(val);
                int size = curr.size();
                int ithelt = curr.get(size - 3);
                res = Math.min(res, 2 * (k - ithelt));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}