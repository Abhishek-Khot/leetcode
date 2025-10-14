class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int knew = k -1;
        if(knew == 0)return true;

        for(int i = k+1;i<nums.size();i++){
            if(nums.get(i) > nums.get(i-1) && nums.get(i-k) > nums.get(i-k-1)){
                knew--;
            }
            //rest the knew at k -1 everytime
            else{
                knew = k -1;
            }
            if(knew == 0)return true;
        }
        return false;
    }
}