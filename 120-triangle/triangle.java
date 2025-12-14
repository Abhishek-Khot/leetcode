// class Solution {
//     // why greedy fails bcz one will max at first and get minimize at the end or vice versa
//     // options to explore that below, below + right 
//     public int dp[][];
//     public int solve(List<List<Integer>> triangle,int row,int col){
//         if(row == triangle.size() -1){
//             return triangle.get(row).get(col);
//         }
//         if(dp[row][col] != -1){
//             return dp[row][col];
//         }
//         int left = triangle.get(row).get(col) + solve(triangle,row+1,col);
//         int right = triangle.get(row).get(col) + solve(triangle,row+1,col+1);
//         int minSum = Math.min(left,right);
//         return dp[row][col] = minSum;
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         dp = new int[201][201];
//         for(int d[] : dp){
//             Arrays.fill(d,-1);
//         }
//         return solve(triangle,0,0);
//     }
// }
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = triangle;
        for(int row = n-2;row >= 0;row--){
            for(int col = 0;col<=row;col++){
                int val= dp.get(row).get(col) + Math.min(dp.get(row+1).get(col),dp.get(row+1).get(col+1));
                dp.get(row).set(col,val);
            }
        }

        return dp.get(0).get(0);
    }
}