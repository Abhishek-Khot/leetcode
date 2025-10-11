class Solution {
    public int K;
    public int n;
    public int solve(int[] energy,int[] dp,int i){
        if(i >= n){
            return 0;
        }
        if(dp[i] != Integer.MIN_VALUE){
            return dp[i];
        }
        return dp[i] = energy[i] + solve(energy,dp,i+K);
    }
    public int maximumEnergy(int[] energy, int k) {
        //options then recursion
        K = k;
        n = energy.length;
        int maxEnergy = Integer.MIN_VALUE;

        int dp[] = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);

        for(int i= 0;i<n;i++){
            maxEnergy = Math.max(maxEnergy,solve(energy,dp,i));
        }
        return maxEnergy;
    }
}