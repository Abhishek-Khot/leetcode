class Solution {
    public int bitwiseComplement(int n) {
        int counter = 0;
        int res = 0;
        if(n == 0){
            return 1;
        }
        while(n != 0){
            int bit = n % 2;
            res+= Math.pow(2,counter) * ((bit == 1) ? 0 : 1);
            counter++;
            n = n / 2;
        }
        return res;
    }
}