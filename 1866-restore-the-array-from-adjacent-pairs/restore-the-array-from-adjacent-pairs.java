class Solution {
    public int res[];

    public void dfs(int u,int prev, int res[],HashMap<Integer,List<Integer>> map,int idx){
        res[idx] = u;
        for(int v : map.get(u)){
            if(v != prev){
                dfs(v,u,res,map,idx+1);
            }
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int n = adjacentPairs.length;
        for (int adj[] : adjacentPairs) {
            int u = adj[0];
            int v = adj[1];
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
        int startPoint = -1;
        for (int keys : map.keySet()) {
            if (map.get(keys).size() == 1) {
                startPoint = keys;
                break;
            }
        }
        res = new int[map.size()];
        int idx = 0;
        dfs(startPoint, Integer.MIN_VALUE, res, map, idx);
        return res;
    }
}