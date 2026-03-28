class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        // future position
        int row = mat.length;
        int col = mat[0].length;
        k = k % col;
        if(k == 0){
            return true;
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                // even row then right
                int currIdx = j;
                int futureIdx;
                if(i % 2 == 0){
                    futureIdx = (j + k) % col; // col checks 
                }
                else {
                    futureIdx = (j - k + col) % col;// +n for negative case handling
                }
                if(mat[i][currIdx] != mat[i][futureIdx]){
                    return false;
                }
            }
        }
        return true;
    }
}