//so we need to find minimum path and maximum value in that path 
//maximum in minimum or vice versa means binary search on answer
class Solution {
    public int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    //t is water level and time 
    public boolean isPossibleToReach(int[][] grid,int i,int j,int t,boolean visited[][]){
        int n = grid.length;
        if(i < 0 || i >= n|| j < 0 || j>= n || visited[i][j] ==true || grid[i][j] > t){
            return false;
        }

        visited[i][j] = true;

        if(i == n-1 && j == n-1){
            return true;
        }

        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(isPossibleToReach(grid,new_i,new_j,t,visited)){
                return true;
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int low = grid[0][0];
        int high = (n * n) -1;//given in contraint

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            boolean visited[][] = new boolean[n][n];

            //we check it from 0,0 to end
            if(isPossibleToReach(grid,0,0,mid,visited)){
                ans = mid;
                high = mid -1;//find minimum than current answer
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
}