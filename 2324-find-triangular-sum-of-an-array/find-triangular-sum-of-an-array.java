class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for(int num : nums){
            temp.add(num);
        }
    
        while(temp.size() > 1){
            List<Integer> newArr = new ArrayList<>();
            for(int i = 0;i<temp.size()-1;i++){
                newArr.add((temp.get(i) + temp.get(i+1)) % 10);
            }
            temp = newArr;
        }
        return temp.get(0);
    }
}