class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        // easy just do the simulation of problem 
        int m = grid.length;
        int n = grid[0].length;
        int ans[][] = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                //sorting + unique for min diff 
                TreeSet<Integer> set = new TreeSet<>();
                for (int r = i; r <= i + k - 1; r++) {
                    for (int c = j; c <= j + k - 1; c++) {
                        set.add(grid[r][c]);
                    }
                }
                if(set.size() == 1){
                    ans[i][j] = 0;
                    continue;// if k ==1 or only same element then answer is 0 so ignore it 
                }
                int minDiff = Integer.MAX_VALUE;

                int prev = -1 ;
                boolean first = true;
                for(int curr : set){
                    if(first){
                        prev = curr;
                        first = false;
                        continue;
                    }
                    minDiff = Math.min(minDiff,curr - prev);
                    prev = curr;
                }

                ans[i][j] = minDiff;
            }
        }
        return ans;
    }
}