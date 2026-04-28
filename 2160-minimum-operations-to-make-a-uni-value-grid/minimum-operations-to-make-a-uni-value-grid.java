class Solution {
    public int minOperations(int[][] grid, int x) {
        // how many operations diff / x 
        int m = grid.length, n = grid[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i< m;i++){
            for(int j = 0;j<n;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        m = list.size();
        int target = list.get((int)(m/2));
        int result = 0;

        for(int num : list){
            // both are possible to make equal 
            if(num % x != target % x){
                return -1;
            }
            int diff = Math.abs(target - num);
            result += (diff/x);
        }
        return result;
    }
}