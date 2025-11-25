class Solution {
    public int smallestRepunitDivByK(int k) {
        // 1 % k 
        // 11 % k 
        // 111 % k
        // 1111 % k you will get the answer before hitting k 
        // for above case you will get the same reminder if you do below operation
        // reminder = reminder * 10 + 1 same as 1111 % k previous state
        int rem = 0;
        for(int length = 1;length <= k;length++){
            rem = (rem * 10 + 1) % k;
            if(rem == 0){
                return length;
            }
        }
        return -1;
    }
}