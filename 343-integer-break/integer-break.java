// dsa notes 
// dp because repeated problem and every element has option to get divided into n - 1 states at every level 
// intution 
// every number 5 has options to be get divided into 1 to 4 corresponds to n - i 
// so 1,4
// i is 1 
// 4 is divided into 3,1 , 2,2 , 1,3 
// which one gives best 
// i * n - i -- current state 1,4
// need to answer for 4 best one 
// take max of both states 
// i * max of this (n-i ,solve(n-i)) 4 or 4s components
// dp of n so n and for loop then total = O(n ^ 2)
class Solution {
    public int dp[];
    public int solve(int n ){
        if(n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int result = Integer.MIN_VALUE;
        // for loop to check for 1 to n - 1 numbers 
        for(int i = 1;i<=n-1;i++){
            int prod = i * Math.max(n - i,solve(n-i));
            result = Math.max(prod,result);
        }
        return dp[n]= result;
    }
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
}