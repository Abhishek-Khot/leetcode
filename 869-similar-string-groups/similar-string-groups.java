// why dfs is connected components line written in the question 
// easy to do this question just need to create the connected components using the similarity
// ulitimatly make graph using strings as integers
class Solution {
    public void makeAdj(int i , int j,List<List<Integer>> adj){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }
    public boolean isSimilarStrings(String s1,String s2){
        int count = 0;
        int n = s1.length();
        //two or zero . two because one swap is fine 
        for(int i = 0;i<n;i++){
            if(s1.charAt(i)!= s2.charAt(i)){
                count++;
            }
        }
        return count == 2 || count == 0;
    }
    public void dfsOnComponents(List<List<Integer>> adj,boolean visited[],int src){
        visited[src] = true;
        for(int dest :adj.get(src)){
            if(!visited[dest]){
                dfsOnComponents(adj,visited,dest);
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        int V = strs.length;
        int n = strs.length;
        int res = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i= 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isSimilarStrings(strs[i],strs[j])){
                    makeAdj(i,j,adj);
                }
            }
        }
        boolean visited[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                dfsOnComponents(adj,visited,i);
                res++;
            }
        }
        return res;
    }
}