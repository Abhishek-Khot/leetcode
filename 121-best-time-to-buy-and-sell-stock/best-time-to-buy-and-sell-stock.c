int max(int a,int b){
    return a > b ? a : b;
}
int maxProfit(int* prices, int pricesSize) {
    int maxProfit = 0;
    int buyPrice = prices[0]; 
    for(int i = 1;i<pricesSize;i++){
        if(buyPrice < prices[i]){
            int profit = prices[i] - buyPrice;
            maxProfit = max(maxProfit,profit);
        }
        else{
            buyPrice = prices[i];
        }
    }
    return maxProfit;
}