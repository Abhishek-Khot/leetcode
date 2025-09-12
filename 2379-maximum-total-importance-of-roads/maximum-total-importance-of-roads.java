class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // degrees -> 2 3 4 1 2
                //    3 4 5 1 2
        // if the degree is more then assign the big value to that
        long res = 0;
        int[] degree = new int[n];
        for(int road[] : roads){
            int src = road[0];
            int dest = road[1];
            degree[src]++;
            degree[dest]++;
        }
        Arrays.sort(degree);
        long count = 1;
        for(int i = 0;i<degree.length;i++){
            res+= (count * degree[i]);
            count++;
        }
        return res;
    }
}