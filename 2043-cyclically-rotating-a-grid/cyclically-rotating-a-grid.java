class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        // take 
        // rotate and then put
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m,n)/2;// min of row and col is the number of layers

        for(int layer = 0;layer< layers;layer++){
            int startRow = layer;
            int endRow = m - layer - 1;
            int startCol = layer;
            int endCol = n - layer - 1;
            List<Integer> temp = new ArrayList<>();
            for(int j = startCol;j <= endCol;j++){
                temp.add(grid[startRow][j]);
            }
            for(int j = startRow+1;j<=endRow;j++){
                temp.add(grid[j][endCol]);
            }
            for(int j = endCol-1;j>= startCol;j--){
                temp.add(grid[endRow][j]);
            }
            for(int j = endRow - 1;j> startRow;j--){
                temp.add(grid[j][startCol]);
            }

            int len = temp.size();
            int normalizedK = k % len;

            Collections.rotate(temp,-normalizedK);//rotate left

            int idx = 0;

            for(int j = startCol;j <= endCol;j++){
                grid[startRow][j] = temp.get(idx);
                idx++;
            }
            for(int j = startRow+1;j<=endRow;j++){
                grid[j][endCol] = temp.get(idx);
                idx++;
            }
            for(int j = endCol-1;j>= startCol;j--){
                grid[endRow][j] = temp.get(idx);
                idx++;
            }
            for(int j = endRow - 1;j> startRow;j--){
                grid[j][startCol] = temp.get(idx);
                idx++;
            }
        }
        return grid;
    }
}