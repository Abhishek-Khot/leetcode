// if the radius distance is greater than the distance between the two centers
// directed graph because a can destroy b but sometime b not a
// it contains 0 to n graph creations only distance x and y and for r is just for radius 
// for connected component we need to find the relation using graph 
class Solution {
    public void dfsForEveryNode(HashSet<Integer> set,ArrayList<ArrayList<Integer>> adj,int src){
        set.add(src);
        for(int dest : adj.get(src)){
            if(!set.contains(dest)){
                dfsForEveryNode(set,adj,dest);
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        int res = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                // if i and j are same then - the condition is like destroying himself
                if(i == j)continue;
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                int r2 = bombs[j][2];

                long distance = ((x2-x1) * (x2 - x1) + (y2 - y1)* (y2 - y1));

                if(r1 * r1 >= distance){
                    adj.get(i).add(j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            dfsForEveryNode(set,adj,i);
            int currInvet = set.size();
            res = Math.max(res,currInvet);
            set.clear();
        }
        return res;
    }
}