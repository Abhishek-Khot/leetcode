class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        int maxFreq = 0;
        for(int num : nums){
            freq[num-0]++;
            maxFreq = Math.max(maxFreq,freq[num]);
        }
        int ans = 0;
        for(int i = 0;i<101;i++){
            if(freq[i] == maxFreq){
                ans+= freq[i];
            }
        }
        return ans;
    }
}