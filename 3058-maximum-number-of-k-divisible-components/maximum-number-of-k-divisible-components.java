class Solution {
    private int count;
    // good constraint that all nodes sum is divisible by k 
    // then if joint component is division by k then other remaining is divisible by k - 
    // not used but important 
    public void addEdge(List<List<Integer>> adj,int u ,int v){
        adj.get(v).add(u);
        adj.get(u).add(v);
    }
    public int dfs(List<List<Integer>> adj,int src,int par,int values[],int k){
        int sum = values[src];
        for(int dest : adj.get(src)){
            //instead of using the just use the parent and the curr node 
            if(dest != par){
                sum += dfs(adj,dest,src,values,k);
                sum = sum % k;
            }
        }
        // sometimes node dont have his neighbor
        // this will skip the for loop 
        // taking sum and doing mod is same as taking mod value from the previous state 

        sum = sum % k;
        if(sum == 0){
            count++;
        }
        return sum;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            addEdge(adj,u,v);
        }
        count = 0;
        dfs(adj,0,-1,values,k);
        return count;
    }
}