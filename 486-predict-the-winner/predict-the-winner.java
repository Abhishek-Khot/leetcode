// this question is - players playing optimally - game theory 
// when you play 
// choose maximum
// if opponent is playing
// expect the minimum
// dsa notes + notebook tree diagram 
class Solution {
    public int dp[][];
    public int solve(int nums[],int i,int j){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // expect minimum but choose maximum while playing
        int take_i = nums[i] + Math.min(solve(nums,i+2,j),solve(nums,i+1,j-1));
        int take_j = nums[j] + Math.min(solve(nums,i+1,j-1),solve(nums,i,j-2));
        return dp[i][j] = Math.max(take_i,take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int total = 0;
        for(int num : nums){
            total+= num;
        }
        int n = nums.length;
        dp = new int[21][21];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int player1 = solve(nums,0,n-1);
        int player2 = total - player1;

        return player1 >= player2;
    }
}