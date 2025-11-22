class Solution {
    //brute force will be add all possible options in array and check for match condi
    public int mod = 1000000007;
    public int countOrders(int n) {
        if(n == 1){
            return 1;
        }
        long res = 1;
        for(int i = 2;i<=n;i++){
            //check for all possible permutation it will come like 4 3 2 1 
            int spaces = (i - 1) * 2 + 1;
            int possible = spaces * (spaces +1 )/2;//sum of the n numbers 
            res *= possible;
            res = res % mod;
        }
        return (int)res;
    }
}