class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int empty  = numBottles;
        while(empty >= numExchange){
            int currBottle = empty / numExchange;
            ans += currBottle;
            empty = currBottle + (empty % numExchange);
        }
        return ans;
    }
}