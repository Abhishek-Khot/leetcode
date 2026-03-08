class Solution {
    public String findDifferentBinaryString(String[] nums) {
        //iterate every string check for different element
        // 01  10 
        // 00 11 index
        // from string 1 01 - 00 index - reverse of 0 1
        // from string 1 10 - 11 index - reverse of 0 1
        // answer 11 

        int n = nums.length;
        String res = "";
        for(int i = 0;i<n;i++){
            char ch = nums[i].charAt(i);
            res +=  ch == '0' ? '1' : '0';
        }
        return res;

    }
}