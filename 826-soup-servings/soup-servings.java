class Solution {
    //two variables means two dimension dp 
    double[][] dp;
    int serves[][] = new int[][]{{100,0},{75,25},{50,50},{25,75}};
    public double solve(int A,int B){
        //all this is from the question
        if(A <= 0 && B <= 0){
            return 0.5;
        }
        if(A <= 0){
            return 1.0;
        }
        if(B <= 0){
            return 0.0;
        }
        if(dp[A][B] != -1.0){
            return dp[A][B];
        }
        double prob = 0.0;
        for(int serve[] : serves){
            int choose_A = serve[0];
            int choose_B = serve[1];
            prob += solve(A - choose_A , B - choose_B);
        }
        return dp[A][B] = 0.25 * prob;
    }
    public double soupServings(int n) {
        //to avoid the large values at last
        if(n >= 4276){
            return 1.0;
        }
        
        dp = new double[n+1][n+1];
        
        for(double d[] : dp){
            Arrays.fill(d,-1.0);
        }
        return solve(n,n);
    }
}