class Solution {
    public final int mod = 1_000_000_007;

    public long find(long a, long b) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }

        return res;
    }

    public int countGoodNumbers(long n) {
        long odd = find(5, (n + 1) / 2);
        long even = find(4, n / 2);
        return (int)((odd * even) % mod);
    }
}
