class Solution {
    //if you do it with degree then difficult to find the common edge
    public void addEdge(List<List<Integer>> adj,int src,int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int road[] : roads){
            int src = road[0];
            int dest = road[1];
            addEdge(adj,src,dest);
        }
        //for all pairs we are finding
        int maxRank = 0;

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int first = adj.get(i).size();
                int second = adj.get(j).size();
                int currRank = first + second;
                if(adj.get(i).contains(j)){
                    currRank --;
                }
                maxRank = Math.max(maxRank,currRank);
                
            }
        }
        return maxRank;
    }
}