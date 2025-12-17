class Solution {
    public int reverse(int x) {
        // greater then return 0
        long res = 0;
        
        // for the positive integers 
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(x != 0){
            int last = x % 10;
            res = res * 10 + last;
            if(res > max || res < min){
                return 0;
            }
            x = x / 10;
        }
        
        return (int)res;
    }
}