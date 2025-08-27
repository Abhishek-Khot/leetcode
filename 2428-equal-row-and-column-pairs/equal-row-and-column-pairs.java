class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int trans[][] = new int[n][n];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                trans[i][j] = grid[j][i];
            }
        }
        for(int rowOg[] : grid){
            for(int rowTr[] : trans){
                if(Arrays.equals(rowOg,rowTr)){
                    count++;
                }
            }
        }
        return count;
    }
}