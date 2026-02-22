class Solution {
    public int binaryGap(int n) {
        int curr = 0;
        int prev = -1;
        int result = 0;

        while(n != 0){
            int bitMask = n & 1;
            if(bitMask == 1){
                result = prev == -1 ? result : Math.max(result,curr-prev);
                prev = curr;
            }
            curr++;
            n = n >> 1;
        }
        return result;
    }
}