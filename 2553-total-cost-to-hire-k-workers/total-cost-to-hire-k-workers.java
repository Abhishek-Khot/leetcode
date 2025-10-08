class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long ans = 0;
        int hired = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int i = 0,j = n -1;

        // take candidates from start and end 

        //we need to hire k candidates
        while(hired < k){
            //take candidates amount of costs 
            while(i <=j && pq1.size() < candidates){
                pq1.add(costs[i]);
                i++;
            }
            while(j >= i && pq2.size() < candidates){
                pq2.add(costs[j]);
                j--;
            }
            int a = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int b = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

            if(a <= b){
                ans += pq1.remove();
            }
            else{
                ans += pq2.remove();
            }

            hired++;
        }
        return ans;
    }
}