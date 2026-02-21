class Solution {
    public int dp[][];
    public int solve(int prices[],boolean buy,int idx,int n){
        if(idx >= n){
            return 0;
        }
        int buyIdx = buy ? 1 : 0;
        if(dp[idx][buyIdx] != -1){
            return dp[idx][buyIdx];
        }
        int profit = 0;
        if(buy){
            int take = solve(prices,false,idx+1,n) -prices[idx];
            int not_take = solve(prices,true,idx+1,n);
            profit = Math.max(profit,Math.max(take,not_take));
        }
        else{
            int sell = solve(prices,true,idx+2,n) + prices[idx];
            int not_sell = solve(prices,false,idx+1,n);
            profit = Math.max(profit,Math.max(sell,not_sell));
        }
        return dp[idx][buyIdx] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[5001][2];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int idx = 0;
        boolean buy = true;
        return solve(prices,buy,idx,n);
    }
}