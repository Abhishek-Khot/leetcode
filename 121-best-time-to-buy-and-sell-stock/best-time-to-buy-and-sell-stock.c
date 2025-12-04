int min(int a,int b){
    return a > b ? b : a;
}
int max(int a,int b){
    return a > b ? a: b;
}
int maxProfit(int* prices, int pricesSize) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for(int i= 0;i<pricesSize;i++){
        minPrice = min(minPrice,prices[i]);
        maxProfit = max(maxProfit,prices[i] - minPrice);
    }
    return maxProfit;
}