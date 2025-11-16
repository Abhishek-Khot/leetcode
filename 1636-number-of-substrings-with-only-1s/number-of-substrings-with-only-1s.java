class Solution {
    public int MOD = (int)1e9+7;
    public int numSub(String s) {
        long countOne = 0;
        int n = s.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                res += (countOne * (countOne + 1) / 2 % MOD)%MOD;
                countOne = 0;
            } else {
                countOne++;
            }
        }
        res += (countOne * (countOne + 1) / 2 % MOD) % MOD;
        return (int)res;
    }
}