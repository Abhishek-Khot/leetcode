class Solution {
    public long flowerGame(int n, int m) {
        //number of odd combination 
        //odd + even
        //even + odd

        long oddN = (n+1)/2;
        long evenN = n/2;
        long oddM = (m+1)/2;
        long evenM = m/2;

        return oddN * evenM + oddM * evenN;

    }
}