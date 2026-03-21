class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startRow = x;
        int startCol = y;

        int endRow = x + k -1;
        int endCol = y + k -1;

        while(startRow < endRow){
            //interate on the column to swap the values 
            for(int col = startCol;col <= endCol;col++){
                int temp = grid[startRow][col];
                grid[startRow][col] = grid[endRow][col];
                grid[endRow][col] = temp;
            }
            startRow++;
            endRow--;
        }
        return grid;
    }
}