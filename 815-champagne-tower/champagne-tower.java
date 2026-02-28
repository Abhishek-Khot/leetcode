class Solution {
    public double dp[][];
    public double solve(int poured,int i ,int j){
        // i < j cell not present
        if(i <0 || j < 0 || i < j){
            return 0.0;
        }
        if(i == 0 && j == 0){
            return poured;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // that state -1 and half is given
        double left = (solve(poured,i-1,j-1)-1)/2.0;
        double right = (solve(poured,i-1,j)-1)/2.0;

        if(left < 0){
            // if i get negative answer due to not present cells -0.5 kind of answers parent negative case
            left = 0.0;
        }
        if(right < 0){
            right = 0.0;
        }
        return dp[i][j] = left + right;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        // if the water is spill out but we start with that i and j so if it is more return 1
        
        // if(res > 1.0){
        //     return 1.0;
        // }
        dp = new double[101][101];
        for(double d[] : dp){
            Arrays.fill(d,-1);
        }
        return Math.min(1.0,solve(poured,query_row,query_glass));
    }
}