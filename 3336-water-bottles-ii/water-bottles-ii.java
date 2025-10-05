class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles;
        int drink = numBottles;
        //initially both are start at numbottles because at first you drink all bottles

        //simulate until empty are more than exchanges
        while(empty >= numExchange){
            //drink the bottles 
            empty -= numExchange;
            //for every numexchange drink you get one full water bottle
            empty++;
            //you need to drink that bottle also
            drink++;
            //every time numexchange will increase
            numExchange++;
        }
        return drink;
    }
}