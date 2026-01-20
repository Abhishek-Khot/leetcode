class Solution {
    public int minOperations(int[] nums) {
        // same question as 2244 
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(freq == 1){
                return -1;
            }
            if(freq % 3 == 0){
                count += (freq/3);
            }
            else {
                // for the 3k+1 and the 3k +2 will be +1 
                count+=((int)freq/3)+1;
            }
        }
        return count;
    }
}