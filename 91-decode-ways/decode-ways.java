class Solution {
    public int dp[];
    public int solve(int idx, int n, String s) {
        // if the string is empty means at the end idx goes
        if (idx == n) {
            return 1;
        }
        // if the cahracter is 0 then not possible on that branch
        if (s.charAt(idx) == '0') {
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        // so possible to break by 1 or 2 (26)
        int res = 0;
        res = solve(idx + 1, n, s);
        // two letter ka group then search for idx + 2
        if (idx + 1 < n) {
            if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6')) {
                res += solve(idx + 2, n, s);
            }
        }
        return dp[idx] =res;
    }

    public int numDecodings(String s) {
        // HERE NEED TO count number of possible decode --> no need too actual spit just count 
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0, n, s);
    }
}