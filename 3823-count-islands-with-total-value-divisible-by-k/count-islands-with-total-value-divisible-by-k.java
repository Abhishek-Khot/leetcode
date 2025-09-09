class Solution {
    public int dfsToFindAreaSum(int grid[][],int i,int j){
        int m = grid.length;
        int n= grid[0].length;
        int sum = 0;
        //if one condition is true just return 0 
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        
        sum += grid[i][j];

        grid[i][j] = 0;

        sum += dfsToFindAreaSum(grid,i,j+1);
        sum += dfsToFindAreaSum(grid,i,j-1);
        sum += dfsToFindAreaSum(grid,i+1,j);
        sum += dfsToFindAreaSum(grid,i-1,j);

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n= grid[0].length;

        int count = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){
                    int sumOfLands = dfsToFindAreaSum(grid,i,j);
                    if(sumOfLands % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}