class Solution {
    public int n;
    // change in the two variables idx and k memorize using the two d matrix
    public int dp[][];
    public int solve(List<List<Integer>> piles,int k ,int idx){
        if(idx >= n){
            return 0;
        }
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        int not_taken = solve(piles,k,idx+1);
        int taken = 0,sum = 0;
        // small optimization here if not written its okay 
        for(int j = 0;j<Math.min(piles.get(idx).size(),k);j++){
            sum += piles.get(idx).get(j);
            taken = Math.max(taken,sum + solve(piles,k-(j+1),idx+1)); // k - j means used piles in that 
            // inner list and +1 for the 0 based indexing
        }
        return dp[idx][k] = Math.max(taken,not_taken);
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[1001][2001];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        n = piles.size();
        int idx = 0;
        return solve(piles,k,idx);
    }
}