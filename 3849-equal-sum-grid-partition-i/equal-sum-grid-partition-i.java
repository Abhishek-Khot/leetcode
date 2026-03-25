class Solution {
    // trick for true and false -> which is more outside 
    // less inside -> single condition kinda 
    // lower = total - upper

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long rowSum[] = new long[m];
        long colSum[] = new long[n];

        long total = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                // in one go find the row and col sum 
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                total += grid[i][j];
            }
        }
        // two partition so optimization line
        if(total % 2 != 0){
            return false;
        }
        //horizontal cut 
        long upper = 0;
        for(int i = 0;i<m;i++){
            upper += rowSum[i];
            long lower = total - upper;
            if(lower == upper){
                return true;
            }
        }
        //horizontal cut 
        long lower = 0;
        for(int j = 0;j<n;j++){
            lower += colSum[j];
            upper = total - lower;
            if(lower == upper){
                return true;
            }
        }
        return false;
    }
}