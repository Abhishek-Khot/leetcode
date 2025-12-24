// notes in the notes folder
class Solution {
    public int n;
    public int MOD = (int)1e9 + 7;
    public int dp[][];
    public int solve(int[] locations,int i,int finish,int fuel){
        if(fuel < 0){
            return 0;
        }
        if(dp[i][fuel] != -1){
            return dp[i][fuel];
        }
        int ans = 0;
        if(i == finish){
            ans+=1;
        }
        // to explore all options use for loop
        for(int j = 0;j<n;j++){
            if(i == j){
                continue;
            }
            int remainingFuel = fuel - (Math.abs(locations[i] - locations[j]));
            ans = (ans + solve(locations,j,finish,remainingFuel))  % MOD;
        }
        return dp[i][fuel] = ans;

    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n = locations.length;
        dp = new int[101][201];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return solve(locations,start,finish,fuel);
    }
}