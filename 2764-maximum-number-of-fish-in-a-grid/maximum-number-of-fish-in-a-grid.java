class Solution {
    public int dfsToFindFishes(int[][] grid,int i,int j){
        int maxCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >=m || j < 0 || j >= n || grid[i][j] == 0){
            return 0;
        }
        // if(grid[i][j] == 0){
        //     return 0;
        // }
        maxCount += grid[i][j];
        grid[i][j] = 0;

        maxCount+=dfsToFindFishes(grid,i+1,j);
        maxCount+=dfsToFindFishes(grid,i,j+1);
        maxCount+=dfsToFindFishes(grid,i-1,j);
        maxCount+=dfsToFindFishes(grid,i,j-1);
        return maxCount;
    }
    public int findMaxFish(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i< m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){
                    int currMax = dfsToFindFishes(grid,i,j);
                    res = Math.max(res,currMax);
                }
            }
        }
        return res;
    }
}