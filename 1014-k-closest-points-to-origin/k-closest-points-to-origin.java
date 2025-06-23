class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> distance(b) - distance(a));
        for(int point[] : points){
            pq.add(point);
            if(pq.size() > k){
                pq.remove();
            }
        }
        int idx = 0;
        int res[][] = new int[k][2];
        for(int point[] : pq){
            res[idx++] = point;
        }
        return res;
    }
    public int distance(int point[]){
        return point[0] * point[0] + point[1] * point[1];
    }
}