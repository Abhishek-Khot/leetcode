class Solution {
    public int m;
    public int n;
    Map<Integer, int[][]> directions = new HashMap<>();

    public Solution() {
        directions.put(1, new int[][]{{0, -1}, {0, 1}});
        directions.put(2, new int[][]{{-1, 0}, {1, 0}});
        directions.put(3, new int[][]{{0, -1}, {1, 0}});
        directions.put(4, new int[][]{{0, 1}, {1, 0}});
        directions.put(5, new int[][]{{0, -1}, {-1, 0}});
        directions.put(6, new int[][]{{-1, 0}, {0, 1}});
    }
    public boolean solve(int grid[][],int i,int j,boolean vis[][]){
        if(i == m -1 && j == n - 1){
            return true;
        }
        vis[i][j] = true;

        for(int dir[] : directions.get(grid[i][j])){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if(new_i < 0 || new_i >= m || new_j < 0 || new_j >= n || vis[new_i][new_j]){
                continue;
            }
            for(int backDir[] : directions.get(grid[new_i][new_j])){
                if(new_i + backDir[0] == i && new_j + backDir[1] == j){
                    if(solve(grid,new_i,new_j,vis)){
                        return true;
                    }
                }
            }
        }
        return false;


    }
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        return solve(grid,0,0,vis);
    }
}