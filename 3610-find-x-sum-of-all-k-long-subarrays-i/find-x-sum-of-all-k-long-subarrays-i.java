class Solution {
    //freq and value
    public int findTopXElements(Map<Integer,Integer> map,int x){
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) ->{
            if(!a.getKey().equals(b.getKey())) {
                return a.getKey() - b.getKey();
            }
            else{
                return a.getValue() - b.getValue();
            }
            }
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getKey();
            int freq = entry.getValue();
            pq.add(new Pair<>(freq,val));

            if(pq.size() > x){
                pq.remove();
            }
        }
        int sum = 0;
        while(!pq.isEmpty()){
            Pair<Integer,Integer> curr = pq.remove();
            int freq = curr.getKey();
            int val = curr.getValue();
            sum+=(freq * val);
        }
        return sum;
    }
    public int[] findXSum(int[] nums, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        while(j < n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j - i +1 == k){
                res.add(findTopXElements(map,x));
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        int ans[] = new int[res.size()];
        for(i = 0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}