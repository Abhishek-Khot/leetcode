class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;
        for(int i = 0;i<n;i++){
            buyPrice = Math.min(buyPrice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-buyPrice);
        }
        return maxProfit;
    }
}