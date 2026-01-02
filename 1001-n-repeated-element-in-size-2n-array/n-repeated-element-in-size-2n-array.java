class Solution {
    public int repeatedNTimes(int[] nums) {
        // int freq[] = new int[10001];
        // int n = nums.length;
        // for(int num : nums){
        //     freq[num]++;
        // }
        // for(int i= 0;i<10001;i++){
        //     if(freq[i] == (int)n/2){
        //         return i;
        //     }
        // }
        // return -1;
        // all are unique expect one elt
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            // else if(!set.contains(num)){
            else{
                set.add(num);
            }

        }
        return -1;
    }
}