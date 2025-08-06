class FindSumPairs {
    //store the num2 and iterate on num1 because of contraints - solve like two sum 

    HashMap<Integer,Integer> map = new HashMap<>();
    int store1[];
    int store2[];

    public FindSumPairs(int[] nums1, int[] nums2) {
        store1 = new int[nums1.length];
        store2 = new int[nums2.length];
        for(int i = 0;i<nums1.length;i++)store1[i] = nums1[i];
        for(int i = 0;i<nums2.length;i++)store2[i] = nums2[i];
        
        for(int num : nums2)map.put(num,map.getOrDefault(num,0)+1);
    }
    
    public void add(int index, int val) {
        map.put(store2[index],map.get(store2[index])-1);
        store2[index] += val;
        map.put(store2[index],map.getOrDefault(store2[index],0)+1);
    }
    
    public int count(int tot) {
        int counts = 0;
        for(int i = 0;i<store1.length;i++){
            if(map.containsKey(tot-store1[i])){
                counts+=map.get(tot - store1[i]);
            }
        }
        return counts;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */