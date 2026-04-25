class Solution {
    public int len;
    public int dp[][][];
    public int solve(List<int[]> strings, int m, int n, int idx) {
        if (idx >= len || (m == 0 && n == 0)) {
            return 0;
        }
        if(dp[m][n][idx] != -1){
            return dp[m][n][idx];
        }
        //take -> when you have capacity to take
        int take = 0;
        if (strings.get(idx)[0] <= m && strings.get(idx)[1] <= n) {
            take = 1 + solve(strings, m - strings.get(idx)[0], n - strings.get(idx)[1], idx + 1);
        }

        //skip
        int skip = solve(strings, m, n, idx + 1);
        return dp[m][n][idx] = Math.max(take, skip);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // 0 1 knapsack -> greedy fails 
        // m zeros and n ones 
        // stores zeros and ones for each string
        len = strs.length;
        dp = new int[101][101][601];
        for(int d1[][] : dp){
            for(int d2[] : d1){
                Arrays.fill(d2,-1);
            }
        }
        List<int[]> strings = new ArrayList<>();
        for (String str : strs) {
            int countZero = 0;
            int countOne = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            strings.add(new int[] { countZero, countOne });
        }
        return solve(strings, m, n, 0);
    }
}