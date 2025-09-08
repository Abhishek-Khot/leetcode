class Solution {
    public void addTheEdge(List<List<Integer>> adj,int src,int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    public long dfs(List<List<Integer>> adj,int src,boolean vis[]){
        long count = 1;
        vis[src] = true;
        for(int dest : adj.get(src)){
            if(!vis[dest]){
                count+=dfs(adj,dest,vis);
            }
        }
        return count;
    }
    public long countPairs(int n, int[][] edges) {
        int currRemain = n;
        long res = 0;

        // number of pairs is the multiplication of two component(number of nodes)
        // number of pairs = size * (remaining)
        // remaining is n - size 
        // pairs = size * (currRemain - size)

        List<List<Integer>> adj = new ArrayList<>();
        // first initialize all the list of list
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges){
            int src = edge[0];
            int dest = edge[1];
            addTheEdge(adj,src,dest);
        }
        boolean vis[] = new boolean[n];

        for(int i= 0;i<n;i++){
            if(!vis[i]){
                long count = 0;
                long size = dfs(adj,i,vis);
                res += size * (currRemain - size);// do iteration if needed 
                currRemain -= size;
            }
        }
        return res;
    }
}