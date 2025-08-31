class KthLargest {
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    //initialize the pq with all elements and every time k should start with 0 
    public int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */