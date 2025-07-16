class Solution {
    //simple observation
    //all even subsequences
    //add odd subsequences
    //or alternative
    public int maximumLength(int[] nums) {
        int n = nums.length;

        int countEven = 0;
        int countOdd = 0;
        int alternative = 1;


        for(int num : nums){
            if(num %2 == 0){
                countEven++;
            }
            else{
                countOdd++;
            }
        }
        int parity = nums[0] %2;
        for(int i = 1;i<n;i++){
            int currParity = nums[i] %2;
            if(parity != currParity){
                alternative++;
                parity = currParity;
            }
        }
        return Math.max(alternative,Math.max(countEven,countOdd));
    }
}