// noted in dsa notes in laptop
// why dp because of duplicates 
class Solution {
    public int n;
    public int MOD = (int)1e9 + 7;
    public int dp[];
    // one parameter is changing so 1D 
    public int solve(int start,String s,int k){
        if(start >= n){
            return 1;
        }
        // no leading zeros 
        if(s.charAt(start) == '0'){
            return 0;
        }
        if(dp[start] != -1){
            return dp[start];
        }
        long ans = 0L;
        long num = 0L;
        for(int end = start;end < n;end++){
            num = (num * 10) + (s.charAt(end) -'0');
            if(num > k){
                break;// optimization if num is greater no further computation
            }
            // new string start with end + 1
            ans = (ans%MOD + solve(end+1,s,k)%MOD)%MOD;
        }
        return dp[start] = (int)ans;
    }
    public int numberOfArrays(String s, int k) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,s,k);

    }
}