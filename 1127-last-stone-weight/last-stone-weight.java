class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones)pq.add(stone);

        while(pq.size() > 1){
            int one = pq.remove();
            int two = pq.remove();
            if(one == two)continue;
            if(one != two){
                pq.add(one - two);
            }
        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
}