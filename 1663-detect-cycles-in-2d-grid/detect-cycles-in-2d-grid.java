class Solution {
    public int m;
    public int n;
    public boolean inbound(int new_i,int new_j){
        return new_i >=0 && new_i < m && new_j >=0 && new_j < n;
    }
    public int directions[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public boolean cycle(int i ,int j,int prev_i,int prev_j,char[][] grid,boolean vis[][]){
        if(vis[i][j] == true){
            return true;
        }
        vis[i][j] = true;

        for(int dir[] : directions){
            int new_i = i + dir[0];
            int new_j = j+ dir[1];
            if(inbound(new_i,new_j) && grid[i][j] == grid[new_i][new_j]){
                if(new_i == prev_i && new_j == prev_j){
                    continue;
                }
                
                    if(cycle(new_i,new_j,i,j,grid,vis)){
                        return true;
                    }
                
            }
        }
        return false;
        
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                // dfs when not visited true && true
                if(!vis[i][j] && cycle(i,j,i,j,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}