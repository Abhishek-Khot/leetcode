class Solution {
    public int MOD = (int)1e9 + 7;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        for(int query[] : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            int idx = l;
            while(idx <= r){
                // convert to long to get proper mod 
                nums[idx] = (int)(1L * nums[idx] * v % MOD);
                idx = idx + k;
            }
        }
        int res = 0;
        for(int i = 0;i<n;i++){
            res ^= nums[i];
        }
        return res;
        
    }
}