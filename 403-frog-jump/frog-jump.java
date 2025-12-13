class Solution {
    public int n;
    public HashMap<Integer, Integer> map;
    public int dp[][];

    public boolean solve(int[] stones, int curr_stone_idx, int prev_jump) {
        if (curr_stone_idx == n - 1) {
            return true;
        }
        if(dp[curr_stone_idx][prev_jump] != -1){
            return dp[curr_stone_idx][prev_jump] == 1;
        }
        boolean result = false;
        for (int nextJump = prev_jump - 1; nextJump <= prev_jump + 1; nextJump++) {
            if (nextJump > 0) {
                int next_stone = stones[curr_stone_idx] + nextJump;
                if (map.containsKey(next_stone)) {
                    result = result || solve(stones, map.get(next_stone), nextJump);
                }
            }
        }
        dp[curr_stone_idx][prev_jump] =(result ? 1 : 0);
        return result;
    }

    public boolean canCross(int[] stones) {
        // little difficult
        // options k -1 , k , k+1 so dp
        // k is the previous jump taken by the frog
        // jump options k-1 k and k+1
        // and csi go to last then true
        // store the position + index as a map dry run from codestorywithmik easiest 
        n = stones.length;
        dp = new int[2001][2002];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        return solve(stones, 0, 0);// stone and idx
    }
}