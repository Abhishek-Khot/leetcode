class Solution {
    public int findSubSets(int idx,int currOr,int[] nums,int maxOr){
        if(nums.length == idx){
            if(currOr == maxOr){
                return 1;
            }
            else{
                return 0;
            }
        }
        int withNextElement = findSubSets(idx+1,currOr|nums[idx],nums,maxOr);

        int withOutNextElement = findSubSets(idx+1,currOr,nums,maxOr);

        return withNextElement + withOutNextElement;
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num : nums){
            maxOr |= num;
        }

        int currOr = 0;
        return findSubSets(0,currOr,nums,maxOr);
    }
}