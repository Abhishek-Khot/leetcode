class Solution {
    // number of 2 and 3 so try to convert the number in the form of 3k 
    // 3k
    // 3k +1 == 8 == 3,3,2 == 8 / 3 == 2 + 1
    // 3k +2 == 7 == 3,3,1 == 3, 2, 2 == 7 / 3 = 2 +1
    // for 3k +1 and +2 we will use the +1 extra along with the divided answer 
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map =  new HashMap<>();
        for(int task : tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        int count = 0;
        for(int key : map.keySet()){
            int freq = map.get(key);

            if(freq == 1){
                return -1;
            }
            else if(freq % 3== 0){
                count+=(freq/3);
            }
            else {
                count+=((int)(freq/3)+1);
            }
        }
        return count;
    }
}