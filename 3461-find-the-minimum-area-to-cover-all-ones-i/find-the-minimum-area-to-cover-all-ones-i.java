class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;//row
        int n = grid[0].length;//col

        int maxRow = -1;
        int maxCol = -1;
        int minRow = m;
        int minCol = n;
        for(int i = 0;i<m;i++){//row 
            for(int j = 0;j<n;j++){//col
                if(grid[i][j] == 1){
                    maxRow = Math.max(maxRow,i);
                    minRow = Math.min(minRow,i);
                    minCol = Math.min(minCol,j);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }
        return (maxRow - minRow + 1) * (maxCol - minCol +1);
    }
}